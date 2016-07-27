package io.blackbricks.bricktemplate.model;

import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import io.blackbricks.bricktemplate.service.db.DatabaseHelper;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@StorIOSQLiteType(table = DatabaseHelper.TABLE_TASK)
public class Sample {

    @SerializedName("taskId")
    @StorIOSQLiteColumn(name = DatabaseHelper.ID_COLUMN, key = true)
    Integer taskId;

    @SerializedName("title")
    @StorIOSQLiteColumn(name = DatabaseHelper.TASK_TITLE_COLUMN)
    String title;
}
