package io.blackbricks.bricktemplate.model;

import com.google.gson.annotations.SerializedName;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import io.blackbricks.bricktemplate.service.db.table.SampleTable;

/**
 * Created by yegorkryndach on 11/07/16.
 */
@StorIOSQLiteType(table = SampleTable.TABLE)
public class Sample {

    @SerializedName("taskId")
    @StorIOSQLiteColumn(name = SampleTable.COLUMN_ID, key = true)
    Integer taskId;

    @SerializedName("title")
    @StorIOSQLiteColumn(name = SampleTable.COLUMN_TITLE)
    String title;
}
