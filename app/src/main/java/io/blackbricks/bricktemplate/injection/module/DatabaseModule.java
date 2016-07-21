package io.blackbricks.bricktemplate.injection.module;

import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

import dagger.Module;
import dagger.Provides;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.model.Sample;
import io.blackbricks.bricktemplate.model.SampleStorIOSQLiteDeleteResolver;
import io.blackbricks.bricktemplate.model.SampleStorIOSQLiteGetResolver;
import io.blackbricks.bricktemplate.model.SampleStorIOSQLitePutResolver;
import io.blackbricks.bricktemplate.service.database.DatabaseHelper;

/**
 * Created by yegorkryndach on 21/07/16.
 */
@Module
public class DatabaseModule {
    @Provides
    @PerApplication
    StorIOSQLite storIOSQLiteProvider(DatabaseHelper databaseHelper) {
        return DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(databaseHelper)
                .addTypeMapping(Sample.class, SQLiteTypeMapping.<Sample>builder()
                        .putResolver(new SampleStorIOSQLitePutResolver())
                        .getResolver(new SampleStorIOSQLiteGetResolver())
                        .deleteResolver(new SampleStorIOSQLiteDeleteResolver())
                        .build())
                .build();
    }
}
