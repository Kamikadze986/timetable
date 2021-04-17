package com.example.firstjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.firstjava.Day;

import java.lang.reflect.Array;
import java.time.MonthDay;
import java.util.ArrayList;

public class FragmentPager extends FragmentPagerAdapter {
    private ArrayList<Fragment> week = new ArrayList<Fragment>();

    public FragmentPager(@NonNull FragmentManager fm) {
        super(fm);
        for (int i = 0; i < 5; i++) {
            week.add(new Day());
            Bundle bundle =new Bundle();
            bundle.putInt("position",i);
            week.get(i).setArguments(bundle);
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return week.get(position);
    }

    @Override
    public int getCount() {
        return week.size();
    }
}
