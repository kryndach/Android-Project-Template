package io.blackbricks.bricktemplate.service.db.core;

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
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "sample.db";
    private static final int DATABASE_VERSION = 1;

    @Inject
    public DatabaseOpenHelper(@AppContext Context context) {
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
        // Drop tables
        db.execSQL("DROP TABLE IF EXISTS " + SampleTable.TABLE);

        onCreate(db);
    }
}
