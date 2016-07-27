package io.blackbricks.bricktemplate.service.db;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@PerApplication
public class SampleDatabaseService {

    private StorIOSQLite storIOSQLite;

    @Inject
    public SampleDatabaseService(StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
    }
}
