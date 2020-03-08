package com.manank.gymapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

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


        String title = cursor.getString(cursor.getColumnIndex("title"));
        String desc = cursor.getString(cursor.getColumnIndex("description"));
        String img = cursor.getString(cursor.getColumnIndex("images"));


        txtTitle.setText(title);
        txtDesc.setText(desc);

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES+ "/FillYourFitness/.Workouts");
        File imageFile = new File(path, String.valueOf(img));
        imageView.setImageDrawable(Drawable.createFromPath(imageFile.toString()));

    }
}