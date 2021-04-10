package com.example.firstjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class AddLesson extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_lesson, container, false);
        ImageButton button_add = (ImageButton) view.findViewById(R.id.imageButton);
        button_add.setOnClickListener(this);
        ImageButton button_back = (ImageButton) view.findViewById(R.id.back);
        button_back.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(this);
                ft.commit();
                break;
            case R.id.imageButton:
                MyDatabaseHelper helper = new MyDatabaseHelper(getContext());
                EditText lesson_name = (EditText) getView().findViewById(R.id.lasson_name);
                EditText number_lesson = (EditText) getView().findViewById(R.id.number_lesson);
                EditText day = (EditText) getView().findViewById(R.id.day);
                helper.addLesson(day.getText().toString(),lesson_name.getText().toString(),number_lesson.getText().toString());
                lesson_name.setText("");
                number_lesson.setText("");
                day.setText("");
                break;
            case R.id.button3:
                break;
        }
    }
}