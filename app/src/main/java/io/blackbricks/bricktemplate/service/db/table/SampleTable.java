package io.blackbricks.bricktemplate.service.db.table;

import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.queries.Query;

/**
 * Created by yegorkryndach on 27/07/16.
 */
public class SampleTable {

    @NonNull
    public static final String TABLE = "tasks";

    @NonNull
    public static final String COLUMN_ID = "id";

    @NonNull
    public static final String COLUMN_TITLE = "title";

    @NonNull
    public static final Query QUERY_ALL = Query.builder()
            .table(TABLE)
            .build();

    private SampleTable() {
        throw new IllegalStateException("No instances please");
    }

    @NonNull
    public static String getCreateTableQuery() {
        return "CREATE TABLE " + TABLE + "("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT NOT NULL "
                + ");";
    }

    @NonNull
    public static Query withId(int id) {
        return Query.builder()
                .table(TABLE)
                .where(COLUMN_ID + " = ?")
                .whereArgs(id)
                .build();
    }
}
