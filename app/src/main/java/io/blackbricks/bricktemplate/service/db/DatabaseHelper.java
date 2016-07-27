package io.blackbricks.bricktemplate.service.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

import io.blackbricks.bricktemplate.injection.qualifier.AppContext;
import io.blackbricks.bricktemplate.injection.scope.PerApplication;
import io.blackbricks.bricktemplate.service.db.table.SampleTable;

/**
 * Created by yegorkryndach on 21/07/16.
 */
@PerApplication
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "todo_manager_db.db";
    private static final int DATABASE_VERSION = 1;

    @Inject
    public DatabaseHelper(@AppContext Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(SampleTable.getCreateTableQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (DATABASE_VERSION < newVersion) {
            recreateDatabase(db);
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        recreateDatabase(db);
    }

    private void recreateDatabase(SQLiteDatabase db) {
        // TODO remove this hard reset DB in future
        db.execSQL("PRAGMA writable_schema = 1;" +
                "delete from sqlite_master where type in ('table', 'index', 'trigger')" +
                "PRAGMA writable_schema = 0;");

        // Drop tables
        db.execSQL("DROP TABLE IF EXISTS " + SampleTable.TABLE);

        onCreate(db);
    }
}
