package com.zappers.gola;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by akriti on 17/3/16.
 */
public class NewClass extends AppCompatActivity {
    Toolbar mtoolbar;
    Spinner new_spin;
    SubDatabase subdb;
    Cursor cursor;
    ArrayAdapter<String>SpinnerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newclasslayout);
        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        new_spin=(Spinner)findViewById(R.id.new_spin);
        subdb= new SubDatabase(this,"Subjects",1);
        cursor = subdb.get_Subjects();
        cursor.moveToFirst();
        SpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cursor.getColumnIndex("Subject"));
        SpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        new_spin.setAdapter(SpinnerAdapter);
        //for each time the value or the number o subjects change.. SpinnerAdapter.notifyDataSetChanged()

    }
}
