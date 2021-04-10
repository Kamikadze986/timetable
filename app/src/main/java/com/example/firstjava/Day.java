package com.example.firstjava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;


public class Day extends Fragment implements View.OnClickListener {
    private RecyclerView lessonList;
    private LessonAdapter lessonAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.add_lesson);
        button.setOnClickListener(this);
        lessonList=view.findViewById(R.id.recyclerView);
        lessonList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MyDatabaseHelper helper = new MyDatabaseHelper(getContext());
        List<DataBD> data = helper.getData();
        lessonList.setAdapter(new LessonAdapter());
        return view;
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AddLesson add_lesson = new AddLesson();
        ft.add(R.id.frame_layout,add_lesson);
        ft.commit();
    }
}