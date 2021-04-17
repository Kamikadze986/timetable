package com.example.firstjava;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class Day extends Fragment implements View.OnClickListener {
    private RecyclerView lessonList;
    private LessonAdapter lessonAdapter;
    int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        ImageButton button = (ImageButton) view.findViewById(R.id.add_lesson);
        button.setOnClickListener(this);
        lessonList = view.findViewById(R.id.recyclerView);
        lessonList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        MyDatabaseHelper helper = new MyDatabaseHelper(getContext());
        ArrayList<ArrayList<DataBD>> data = helper.getData();
        lessonList.setAdapter(new LessonAdapter(data.get(position)));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        position=bundle.getInt("position");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putInt("positionOnDay",position);
        AddLesson add_lesson = new AddLesson();
        add_lesson.setArguments(bundle);
        ft.add(R.id.frame_layout, add_lesson);
        ft.commit();
    }
}