package io.blackbricks.bricktemplate.service.session;

import android.content.SharedPreferences;

import javax.inject.Inject;

import io.blackbricks.bricktemplate.injection.scope.PerApplication;

/**
 * Created by yegorkryndach on 25/07/16.
 */
@PerApplication
public class SessionService {
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "user_id";
    public static final String PASSWORD = "password";
    public static final String TOKEN = "token";
    public static final String SESSION_TYPE = "session_type";

    public enum SessionType {
        NONE, ACCOUNT, FACEBOOK, GOOGLE
    }

    private SharedPreferences sharedPreferences;

    @Inject
    public SessionService(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String getUserName() {
        return sharedPreferences.getString(USER_NAME, "DoFast");
    }

    public String getPassword() {
        return sharedPreferences.getString(PASSWORD, null);
    }

    public SessionType getSessionType() {
        if (sharedPreferences.contains(SESSION_TYPE)) {
            int sessionTypeNum = sharedPreferences.getInt(SESSION_TYPE, 0);
            return SessionType.values()[sessionTypeNum];
        } else {
            return SessionType.NONE;
        }
    }

    public void setCredentials(String userName, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.putString(PASSWORD, password);
        editor.putInt(SESSION_TYPE, SessionType.ACCOUNT.ordinal());
        editor.commit();
    }

    public void setFacebookSession() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SESSION_TYPE, SessionType.FACEBOOK.ordinal());
        editor.commit();
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN, null);
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public Integer getUserId() {
        if (sharedPreferences.contains(USER_ID)) {
            return sharedPreferences.getInt(USER_ID, 0);
        } else {
            return -1;
        }
    }

    public void setUserId(Integer userId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USER_ID, userId);
        editor.commit();
    }

    public void clearCredentials() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(USER_NAME);
        editor.remove(USER_ID);
        editor.remove(PASSWORD);
        editor.remove(TOKEN);
        editor.remove(SESSION_TYPE);
        editor.commit();
    }
}
