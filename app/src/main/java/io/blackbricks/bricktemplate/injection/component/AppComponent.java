package io.blackbricks.bricktemplate.injection.component;

import android.content.Context;
import android.content.res.Resources;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import dagger.Component;
import io.blackbricks.bricktemplate.injection.module.AppModule;
import io.blackbricks.bricktemplate.injection.module.DatabaseModule;
import io.blackbricks.bricktemplate.injection.qualifier.AppContext;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.database.DatabaseHelper;
import io.blackbricks.bricktemplate.ui.base.BaseViewModelActivity;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@PerApplication
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {
    @AppContext
    Context context();

    Resources resources();

    StorIOSQLite storIO();
}