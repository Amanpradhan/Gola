package com.zappers.gola.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String Flag = "";
    public static final String ATTENDANCE = "";

    public UserDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table GolaDB" +
                "(U_Id Integer AUTO_INCREMENT," +
                "USERNAME varchar," +
                "SEMESTER varchar," +
                "Flag Integer" +
                "ATTENDANCE varchar,Primary Key(U_Id));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertUserData(String u_name, Integer semester) {
        int id = 0;
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", u_name);
        contentValues.put("SEMESTER", semester);
        db.update("GolaDB", contentValues, "id = ? ", new String[]{Integer.toString(id)});
    }
    public Cursor getUserData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select USERNAME,SEMESTER from GolaDB ;",null);
        return cursor;
    }

    public Cursor getFlag() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select Flag from GolaDB ;", null);
        return cursor;

    }

    public void setFlag(int f) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Flag", f);
    }
}
