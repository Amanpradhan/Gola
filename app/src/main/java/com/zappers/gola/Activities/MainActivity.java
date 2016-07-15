package com.zappers.gola.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zappers.gola.Database.UserDB;
import com.zappers.gola.R;
import com.zappers.gola.Services.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button butn1, butn2;
    Toolbar mtoolbar;
    LinearLayout main, curr_details;
    TextView user_saltn,user_curr_att;
    ImageView exp;
    public static Context context;
    public static UserDB userDB;
    public static Cursor cursor;
    public static String name_of_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mtoolbar.setTitle("Gola");
        startService(new Intent(getBaseContext(), MyService.class));
        butn1 = (Button) findViewById(R.id.btn_check);
        butn1.setOnClickListener(this);
        butn2 = (Button) findViewById(R.id.btn_mark);
        curr_details = (LinearLayout) findViewById(R.id.curr_details);
        main = (LinearLayout) findViewById(R.id.main);
        user_saltn = (TextView)findViewById(R.id.user_saltn);
        user_curr_att = (TextView)findViewById(R.id.user_curr_att);
        exp = (ImageView)findViewById(R.id.exp);
        butn2.setOnClickListener(this);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_check:
                curr_details.setVisibility(View.VISIBLE);
                userDB = new UserDB(context,"GolaDB",null,1);
                cursor.moveToFirst();
                cursor = userDB.getFlag();
                int flag = cursor.getShort(3);
                if (flag==1){
                    cursor = userDB.getUserData();
                    name_of_user = cursor.getString(2);
                    user_saltn.setText("Hey "+name_of_user+" !");
                    user_curr_att.setText("Your current attendance is "+cursor.getDouble(4)+"%");
                    if (cursor.getDouble(4)>=75&&cursor.getDouble(4)<=85){
                        exp.setImageResource(R.drawable.ryt);
                    }
                    else if (cursor.getDouble(4)<75){
                        exp.setImageResource(R.drawable.low);
                    }
                    else{
                        exp.setImageResource(R.drawable.Wow);
                    }
                    Log.d("Gola","Display attendance");
                }
                else {
                    Snackbar snackbar = Snackbar
                            .make(main, "No Information Available!", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Validate Info", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(context,NewUser.class);
                                    startActivity(intent);

                                }
                            });

// Changing message text color
                    snackbar.setActionTextColor(Color.RED);

// Changing action button text color
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();

                }

                break;
            case R.id.btn_mark:
                Intent intent = new Intent(this,MarkAttendance.class);
                startActivity(intent);
                break;


        }
    }


}
