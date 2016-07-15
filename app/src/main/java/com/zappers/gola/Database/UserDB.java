package com.zappers.gola.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akriti on 16/7/16.
 */
public class UserDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "GolaDB";
    public static final String U_Id = "";
    public static final String USERNAME = "";
    public static final String SEMESTER = "";
    public static final String ATTENDANCE = "";
    public UserDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Journey" +
                "(U_Id Integer AUTO_INCREMENT," +
                "USERNAME varchar," +
                "SEMESTER varchar," +
                "ATTENDANCE varchar,Primary Key(U_Id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void InsertData(){

    }
}
