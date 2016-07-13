package com.zappers.gola;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by akriti on 13/7/16.
 */
public class NewUser extends AppCompatActivity implements View.OnClickListener {
    static String user_name;
    static int user_sem;
    EditText name, sem;
    Button new_ok;
    public static int flag1=0,flag2=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);
        name = (EditText) findViewById(R.id.name);
        sem = (EditText) findViewById(R.id.sem);
        new_ok = (Button) findViewById(R.id.new_ok);
        new_ok.setOnClickListener(this);
        new_ok.setEnabled(false);
        //init();
        new_ok.setEnabled(true);
    }

    public void init() {
        user_name = name.getText().toString();
        if (user_name.length() <= 3) {
            SemDialog semDialog = new SemDialog();
            semDialog.show(getSupportFragmentManager(), "Invalid Name");
        } else {
            user_name = name.getText().toString();
            flag1 =1;
        }

        Log.d("Gola", user_name + " name inside init");
        if (sem.getText().length()==0){
            SemDialog semDialog = new SemDialog();
            semDialog.show(getSupportFragmentManager(), "Invalid Sem");

        }
        else if (Integer.parseInt(sem.getText().toString()) > 8 || Integer.parseInt(sem.getText().toString()) < 1) {
            SemDialog semDialog = new SemDialog();
            semDialog.show(getSupportFragmentManager(), "Invalid Sem");
        } else {
            user_sem = Integer.parseInt(sem.getText().toString());
            Log.d("Gola", user_sem + " name inside init");
            flag2=1;
        }
        Log.d("Gola", " initialized name and semester");
        if (flag1==1&&flag2==1)
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.new_ok)
            init();

    }
}
