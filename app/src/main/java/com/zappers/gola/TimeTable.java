package com.zappers.gola;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TimeTable extends AppCompatActivity implements View.OnClickListener{
    EditText e1,e2,e3,e4,e5;
    String s1,s2,s3,s4,s5;
    Button submit;
    Cursor cursor;
    TextView display;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        display=(TextView)findViewById(R.id.display);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
       int n= Integer.parseInt(bundle.getString("No_of_classes"));
        if (v.getId()==R.id.submit){
            for(int i=0;i<n;i++)
            {
            //Validation is to be applied to avoid null input
            //Textview should be made dynamic to display slots respectivly
            s1=e1.getText().toString();
            s2=e2.getText().toString();
            s3=e3.getText().toString();
            s4=e4.getText().toString();
            s5=e5.getText().toString();
            AttenDB attenDB = new AttenDB(this,"Attendance",1);
            attenDB.input_Subjects(s1,s2,s3,s4,s5);}
            //cursor= attenDB.get_Subjects(1);
            //cursor.moveToFirst();
            //display.setText(cursor.getColumnIndex("Day_1")+cursor.getColumnIndex("Day_2")+cursor.getColumnIndex("Day_3")+cursor.getColumnIndex("Day_4")+cursor.getColumnIndex("Day_5"));




        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
