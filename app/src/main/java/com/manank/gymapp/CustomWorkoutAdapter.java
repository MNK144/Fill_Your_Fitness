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
        byte[] img = cursor.getBlob(cursor.getColumnIndex("images"));

        txtTitle.setText(title);
        txtDesc.setText(desc);

        Bitmap bmp = BitmapFactory.decodeByteArray(img,0,img.length);
        imageView.setImageBitmap(bmp);
    }
}

/*------------ARRAY ADAPTER--------------------
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomWorkoutAdapter extends ArrayAdapter<String> {
    private Cursor data;
    private Activity context;
    CustomWorkoutAdapter(@NonNull Context context, Cursor c)
    {
        super(context,R.layout.workout_list,resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            r=inflater.inflate(R.layout.workout_list,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) r.getTag();

        }

        return super.getView(position, convertView, parent);
    }

    class ViewHolder
    {
        TextView tv1;
        TextView tv2;
        ImageView iv;
        ViewHolder(View v)
        {
            tv1 = v.findViewById(R.id.wename);
            tv2 = v.findViewById(R.id.wdesc);
            iv = v.findViewById(R.id.wpic);
        }
    }
}
*/