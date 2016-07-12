package com.zappers.gola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Administrator on 29-02-2016.
 */
public class Details extends AppCompatActivity implements View.OnClickListener {
    Bundle bundle = new Bundle();
    EditText et1,et2,et3,et4;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        et1= (EditText)findViewById(R.id.et1);
        et2= (EditText)findViewById(R.id.et2);
        et3= (EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

    }
    public void onClick(View view) {
        if (view.getId() == R.id.submit) {
            String s1, s2, s3, s4;
            s1 = et1.getText().toString();
            s2 = et2.getText().toString();
            s3 = et3.getText().toString();
            s4 = et4.getText().toString();
            //Radio button input to be extracted
           // Bundle bundle = new Bundle();
            Log.d("One","One");
           bundle.putString("No_of_classes", s1);
           bundle.putString("Start_time", s2);
           bundle.putString("Duration", s3);
            bundle.putString("No_of_subjects", s4);
            System.out.println("Value of s4="+s4);
            Intent intent = new Intent(this, Subjects.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
