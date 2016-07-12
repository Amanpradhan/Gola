package com.zappers.gola;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akriti on 28/2/16.
 */
public class AttenDB extends SQLiteOpenHelper {
    private final String Database_Name ="Attendance DB";
    private final String Database_ID ="Id";
    private final String Database_Col_1_Name ="Day_1";
    private final String Database_Col_2_Name ="Day_2";
    private final String Database_Col_3_Name ="Day_3";
    private final String Database_Col_4_Name ="Day_4";
    private final String Database_Col_5_Name ="Day_5";
    private int version=0;
    public AttenDB (Context context,String DB_name,Integer version){
        super(context,DB_name,null,version);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Schedule " +
                        "(Id integer primary key AUTOINCREMENT, Day_1 text,Day_2 text,Day_3 text, Day_4 text,Day_5 text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Column or Table if exists");
        onCreate(db);
    }
    public void input_Subjects(String day1,String day2,String day3,String day4,String day5){
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Day_1",day1);
        contentValues.put(Database_Col_2_Name,day2);
        contentValues.put(Database_Col_3_Name,day3);
        contentValues.put(Database_Col_4_Name,day4);
        contentValues.put(Database_Col_5_Name, day5);
        dataBase.insert("Schedule", null, contentValues);
    }
    public Cursor get_Subjects(int slot){
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * from Schedule where id = " + slot,null);
        return cursor;


    }
}
