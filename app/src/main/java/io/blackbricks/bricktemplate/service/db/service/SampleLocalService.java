package io.blackbricks.bricktemplate.service.db.service;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import javax.inject.Inject;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@PerApplication
public class SampleLocalService {

    private StorIOSQLite storIOSQLite;

    @Inject
    public SampleLocalService(StorIOSQLite storIOSQLite) {
        this.storIOSQLite = storIOSQLite;
    }
}
