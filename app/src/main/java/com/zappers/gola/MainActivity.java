package com.zappers.gola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button butn1,butn2,butn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(getBaseContext(),MyService.class));
        butn1=(Button)findViewById(R.id.butn1);
        butn1.setOnClickListener(this);
        butn2=(Button)findViewById(R.id.butn2);
        butn2.setOnClickListener(this);
        butn3=(Button)findViewById(R.id.butn3);
        butn3.setOnClickListener(this);

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
