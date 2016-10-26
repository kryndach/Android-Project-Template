package io.blackbricks.bricktemplate.service.db;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio.sqlite.operations.put.PutResult;

import java.util.List;

import javax.inject.Inject;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.model.Sample;
import io.blackbricks.bricktemplate.service.db.table.SampleTable;
import rx.Observable;

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

    public Observable<Integer> getCount() {
        return storIOSQLite.get()
                .numberOfResults()
                .withQuery(SampleTable.QUERY_ALL)
                .prepare()
                .asRxObservable();
    }

    public Observable<List<Sample>> getSamples() {
        return storIOSQLite.get()
                .listOfObjects(Sample.class)
                .withQuery(SampleTable.QUERY_ALL)
                .prepare()
                .asRxObservable();
    }

    public Observable<Sample> getSample(int id) {
        return storIOSQLite.get()
                .object(Sample.class)
                .withQuery(SampleTable.withId(id))
                .prepare()
                .asRxObservable();
    }

    public Observable<PutResult> putSample(Sample sample) {
        return storIOSQLite.put()
                .object(sample)
                .prepare()
                .asRxObservable();
    }

    public Observable<DeleteResult> deleteSample(Sample sample) {
        return storIOSQLite.delete()
                .object(sample)
                .prepare()
                .asRxObservable();
    }
}
