package com.zappers.gola;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button butn1,butn2,butn3;
    Toolbar mtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mtoolbar.setTitle("Gola");
        startService(new Intent(getBaseContext(),MyService.class));
        butn1=(Button)findViewById(R.id.butn1);
        butn1.setOnClickListener(this);
        butn2=(Button)findViewById(R.id.butn2);
        butn2.setOnClickListener(this);
        butn3=(Button)findViewById(R.id.butn3);
        butn3.setOnClickListener(this);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Initialize SharedPreferences
                SharedPreferences getPrefs = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                //  If the activity has never started before...
                if (isFirstStart) {

                    //  Launch app intro
                    Intent i = new Intent(MainActivity.this, NewUser.class);
                    startActivity(i);
                    //finish();

                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefs.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStart", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });
        // Start the thread
        t.start();

    }
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.butn3:
                Intent i3=new Intent(this,Details.class);
                startActivity(i3);
                break;
        }
    }







    }
