package io.blackbricks.bricktemplate.service.db.core;

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

/**
 * Created by yegorkryndach on 21/07/16.
 */
@Module
public class DatabaseModule {
    @Provides
    @PerApplication
    StorIOSQLite provideStorIOSQLite(DatabaseOpenHelper databaseHelper) {
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
