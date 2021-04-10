package com.example.firstjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Schedule extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPager adapter = new FragmentPager(getFragmentManager());
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ViewPager viewPager=view.findViewById(R.id.schedule);
        viewPager.setAdapter(adapter);
        return view;
    }
}