package com.zappers.gola;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 29-02-2016.
 */
public class SubDatabase extends SQLiteOpenHelper {
    public SubDatabase (Context context,String DB_name,Integer version){
        super(context,DB_name,null,version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Subjects " +
                "(Id integer primary key AUTOINCREMENT, Subject text,Attendance integer )");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void input_Subject(String day1){
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Subject",day1);
        contentValues.put("Attendance",0);
        dataBase.insert("Subjects", null, contentValues);
    }
    public Cursor get_Subjects(){
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from Schedule",null);
        return cursor;
}}
