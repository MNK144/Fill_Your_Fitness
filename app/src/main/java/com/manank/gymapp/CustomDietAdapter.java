package com.manank.gymapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDietAdapter extends CursorAdapter{
    public CustomDietAdapter(Context context, Cursor cursor, int flag)
    {
        super(context,cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.diet_list,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitle = view.findViewById(R.id.dltitle);
        TextView txtDesc = view.findViewById(R.id.dldesc);
        ImageView imageView = view.findViewById(R.id.dlimg);

        String title = cursor.getString(cursor.getColumnIndex("title"));
        String desc = cursor.getString(cursor.getColumnIndex("description"));
        byte[] img = cursor.getBlob(cursor.getColumnIndex("images"));

        txtTitle.setText(title);
        txtDesc.setText(desc);

        Bitmap bmp = BitmapFactory.decodeByteArray(img,0,img.length);
        imageView.setImageBitmap(bmp);
    }
}
