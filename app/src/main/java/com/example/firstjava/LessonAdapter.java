package com.example.firstjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<DataBD> data;
    int pos;
    LessonAdapter(ArrayList<DataBD> data){
        this.data=data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lesson.setText(data.get(position).lesson_name);
        holder.time.setText(String.valueOf(data.get(position).number_lesson));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
