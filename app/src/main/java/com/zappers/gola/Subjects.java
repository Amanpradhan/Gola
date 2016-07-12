package com.zappers.gola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 29-02-2016.
 */
public class Subjects extends AppCompatActivity implements View.OnClickListener{
    //SubDatabase obj=new SubDatabase();
    static int i;
    Bundle bundle;
    EditText sub;
    String input_sub="";
    Bundle b ;
    SubDatabase subDatabase;

    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String s;
        i=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjects);
        sub=(EditText)findViewById(R.id.sub);
        Log.d("sachin", "sachin");
        subDatabase= new SubDatabase(this,"Subjects",1);
        b=getIntent().getExtras();
        s=b.getString("No_of_subjects");
        n=Integer.parseInt(s);
        System.out.println("Value of n="+n);
        System.out.println("Value of n="+n);
        Log.d("sachin", "sachin");
  }

    public void onClick(View view)
    {

       // Bundle bundl=new Bundle();
       // Details obj=new Details();
        Log.d("Two", "Two");
        //Intent intent = new Intent(this,Details.class);
        //intent.getBundleExtra("bundle");

        Log.d("Two", "Two");

        Log.d("Two", "Two");
        System.out.println("Value of i=" + i);
        System.out.println("Value of n="+n);
        if(i<n)
       {

           // sub.setHint("Enter subject number : " + "i+1");
           input_sub=sub.getText().toString();
           subDatabase.input_Subject(input_sub);
           Log.d("Two", "Subject entered");
            Toast.makeText(this,"Subject entered",Toast.LENGTH_SHORT).show();
           i++;

        }
        else
        {
            Toast.makeText(this,"Subject not entered",Toast.LENGTH_SHORT).show();
        }

    }
}
