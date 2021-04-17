package com.example.firstjava;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView lesson;
    TextView time;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        lesson = itemView.findViewById(R.id.lesson);
        time = itemView.findViewById(R.id.time);
    }

}
