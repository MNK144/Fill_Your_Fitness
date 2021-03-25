package com.manank.gymapp;

import android.content.Context;
import android.database.Cursor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDietAdapter extends CursorAdapter {

    public CustomDietAdapter(Context context, Cursor cursor, int flag) {
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.diet_list, viewGroup, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitle = view.findViewById(R.id.dltitle);
        TextView txtTime = view.findViewById(R.id.dltime);
        ImageView imageView = view.findViewById(R.id.dlimg);

        int index = cursor.getInt(0)-1;
        String time;
        if(index<5)
            time="Breakfast";
        else if(index<10)
            time="Brunch";
        else if(index<15)
            time="Lunch";
        else if(index<20)
            time="PreWorkout";
        else if(index<25)
            time="PostWorkout";
        else
            time="Dinner";

        txtTitle.setText(DietData.name[index]);
        txtTime.setText(time);
        imageView.setImageResource(DietData.image[index]);
    }
}