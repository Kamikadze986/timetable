package com.example.firstjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FragmentMain extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Log.i("12", "12");
        switch (v.getId()) {
            case R.id.button:
                break;
            case R.id.button2:
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                Schedule scheduleFragment = new Schedule();
                ft.add(R.id.frame_layout, scheduleFragment);
                ft.addToBackStack(null);
                ft.commit();
                break;
            case R.id.button3:
                break;
        }

    }
}