package com.zappers.gola.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.zappers.gola.Database.UserDB;
import com.zappers.gola.Fragments.SemDialog;
import com.zappers.gola.R;

/**
 * Created by akriti on 13/7/16.
 */
public class NewUser extends AppCompatActivity implements View.OnClickListener {
    public static String user_name;
    public static int user_sem;
    public static int no_classes_daily;
    public static int duration_each_class;
    public static int no_working_weekly;
    public static int start_hrs, start_min;
    public static int meredian;
    public static int flag1 = 0, flag2 = 0, flag3 = 0, flag4 = 0, flag5 = 0, flag6 = 0;
    public static Context context;
    public static Bundle bundle;
    public static UserDB userDB;
    //UI elements
    Spinner no_classes, hrs, min,merdn,no_min;
    EditText name, sem;
    Button new_ok;
    Toolbar mtoolbar;
    RadioGroup work_days;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);
        context = getApplicationContext();
        mtoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        name = (EditText) findViewById(R.id.name);
        sem = (EditText) findViewById(R.id.sem);
        new_ok = (Button) findViewById(R.id.new_ok);
        new_ok.setOnClickListener(this);
        work_days = (RadioGroup) findViewById(R.id.work_days);
        no_classes = (Spinner) findViewById(R.id.no_classes);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.number_classes, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        no_classes.setAdapter(adapter1);
        no_classes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                no_classes_daily = position + 3;
                flag3 = 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                no_classes_daily = 8;
                Toast.makeText(context,"Select number of classes daily",Toast.LENGTH_SHORT).show();
            }
        });
        hrs = (Spinner) findViewById(R.id.hrs);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.time_hrs, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hrs.setAdapter(adapter2);
        hrs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                start_hrs = position + 1;
                flag4 = 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                start_hrs =8;
                Toast.makeText(context,"Select start time",Toast.LENGTH_SHORT).show();

            }
        });
        min = (Spinner) findViewById(R.id.min);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.time_mins, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        min.setAdapter(adapter3);
        min.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                start_min = position * 5;
                flag5 = 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                start_min = 30;
                Toast.makeText(context,"Select start time",Toast.LENGTH_SHORT).show();

            }
        });
        no_min = (Spinner) findViewById(R.id.no_min);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.duration_class, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        no_min.setAdapter(adapter4);
        no_min.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                flag6 = 1;
                duration_each_class = ((position * 10) + 30);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                duration_each_class = 50;
                Toast.makeText(context,"Select duration of each class",Toast.LENGTH_SHORT).show();
            }
        });
        merdn = (Spinner)findViewById(R.id.merdn);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,R.array.time_meredian,android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        merdn.setAdapter(adapter5);
        merdn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                meredian = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                meredian = 1;

            }
        });
    }

    public void init() {
        user_name = name.getText().toString();
        if (user_name.length() <= 3) {
            Toast.makeText(this, "Invalid name", Toast.LENGTH_SHORT).show();
        } else {
            user_name = name.getText().toString();
            flag1 = 1;
        }

        Log.d("Gola", user_name + " name inside init");
        if (sem.getText().length() == 0) {
            Toast.makeText(this, "Invalid semester", Toast.LENGTH_SHORT).show();

        } else if (Integer.parseInt(sem.getText().toString()) > 8 || Integer.parseInt(sem.getText().toString()) < 1) {
            Toast.makeText(this, "Invalid semester", Toast.LENGTH_SHORT).show();
        } else {
            user_sem = Integer.parseInt(sem.getText().toString());
            Log.d("Gola", user_sem + " name inside init");
            flag2 = 1;
        }
        Log.d("Gola", " initialized name and semester");
        no_working_weekly = work_days.getCheckedRadioButtonId() + 5;
        if (flag1 == 1 && flag2 == 1 && flag3 == 1 && flag4 == 1 && flag5 == 1 && flag6 == 1){
            bundle.putString("USERNAME",user_name);
            bundle.putInt("USERSEM",user_sem);
            bundle.putInt("NOOFCLASSES",no_classes_daily);
            bundle.putInt("DURATION",duration_each_class);
            bundle.putInt("WEEKLYWORKDAYS",no_working_weekly);
            bundle.putInt("TIMEHRS",start_hrs);
            bundle.putInt("TIMEMIN",start_min);
            bundle.putInt("MEREDIAN",meredian);
            userDB = new UserDB(context,"GolaDB",null,1);
            userDB.setFlag(1);
            userDB.InsertUserData(user_name,user_sem,duration_each_class,no_classes_daily);
            finish();

        }

        else {
            SemDialog semDialog = new SemDialog();
            semDialog.show(getSupportFragmentManager(), "Invalid account");

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.new_ok)
            init();

    }
}
