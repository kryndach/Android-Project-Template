package io.blackbricks.bricktemplate.service.remote;

import java.net.HttpURLConnection;

import io.blackbricks.bricktemplate.service.remote.request.LoginRequest;
import io.blackbricks.bricktemplate.service.remote.response.LoginResponse;
import io.blackbricks.bricktemplate.service.session.UserSessionService;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by yegorkryndach on 25/07/16.
 */
public class TokenService {

    AuthRemoteService authRemoteService;
    UserSessionService sessionService;

    public TokenService(AuthRemoteService authRemoteService, UserSessionService sessionService) {
        this.authRemoteService = authRemoteService;
        this.sessionService = sessionService;
    }

    public <T> Observable<T> autoToken(Observable<T> request){
        return request.onErrorResumeNext(refreshTokenAndRetry(request));
    }

    public Observable<LoginResponse> refreshToken() {
        LoginRequest loginRequest = new LoginRequest(sessionService.getUserName(), sessionService.getPassword());
        return authRemoteService
                .login(loginRequest)
                .doOnNext(new Action1<LoginResponse>() {
                    @Override
                    public void call(LoginResponse loginResponse) {
                        sessionService.setToken(loginResponse.getToken());
                    }
                });
    }

    private  <T> Func1<Throwable,? extends Observable<? extends T>> refreshTokenAndRetry(final Observable<T> toBeResumed) {
        return new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                // Here check if the error thrown is a HTTP_UNAUTHORIZED
                if (throwable instanceof HttpException) {
                    HttpException httpException = (HttpException) throwable;
                    int statusCode = httpException.response().code();
                    if(statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                        return refreshToken().flatMap(new Func1<LoginResponse, Observable<? extends T>>() {
                            @Override
                            public Observable<? extends T> call(LoginResponse token) {
                                return toBeResumed;
                            }
                        });
                    }
                }
                // re-throw this error because it's not recoverable from here
                return Observable.error(throwable);
            }
        };
    }

}
