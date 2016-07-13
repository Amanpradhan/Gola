package com.zappers.gola;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SemDialog extends DialogFragment implements View.OnClickListener {
    Button sem_ok;


    public SemDialog() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setCancelable(false);
        getDialog().setTitle("Invalid Details");
        View view =  inflater.inflate(R.layout.fragment_sem_dialog, container, false);
        sem_ok = (Button)view.findViewById(R.id.sem_ok);
        sem_ok.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.sem_ok){
            dismiss();
        }
    }
}
