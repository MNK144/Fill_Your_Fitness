package com.manank.gymapp;

import android.content.Context;
import android.database.Cursor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public  class CustomWorkoutAdapter extends CursorAdapter{

    public CustomWorkoutAdapter(Context context, Cursor cursor, int flag)
    {
        super(context,cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.workout_list,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitle = view.findViewById(R.id.wltitle);
        TextView txtDesc = view.findViewById(R.id.wldesc);
        ImageView imageView = view.findViewById(R.id.wlimg);

        int index = cursor.getInt(0)-1;
        txtTitle.setText(WorkoutData.name[index]);
        txtDesc.setText(WorkoutData.desc[index]);
        imageView.setImageResource(WorkoutData.image[index]);
    }
}