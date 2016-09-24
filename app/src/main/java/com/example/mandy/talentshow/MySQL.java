/*package com.example.mandy.talentshow;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQL extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "table";//表名
    public static final String CONTENT = "content"; //内容
    public static final String ID = "_id"; //数据库的id
    public static final String TIME = "time"; //时间
    public static final String USER_NAME = "user_name";//表名

    public MySQL(Context context) {
        super(context, "table", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " //id主动递增且为integer类
                + CONTENT + " TEXT NOT NULL, "
                + TIME + " TEXT NOT NULL  "
                + USER_NAME+ " TEXT NOT NULL  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
*/