package com.manank.gymapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.contentcapture.ContentCaptureCondition;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomDietAdapter extends CursorAdapter{
    AlphaAnimation inAnimation;
    AlphaAnimation outAnimation;
    FrameLayout progressBarHolder;
    View root;
    public CustomDietAdapter(Context context, Cursor cursor, int flag)
    {
        super(context,cursor, 0);
    }
    public void setRoot(View root)
    {
        this.root = root;
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
        progressBarHolder = (FrameLayout) root.findViewById(R.id.progressBarHolder);

        //CODE FOR LOADING IMAGES AND WAITING FOR THREAD BEFORE FRAGMENT IS LOADED
/*
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/

        String title = cursor.getString(cursor.getColumnIndex("title"));
        String desc = cursor.getString(cursor.getColumnIndex("description"));
        //String sUrl = cursor.getString(cursor.getColumnIndex("images"));

        //byte[] img = cursor.getBlob(cursor.getColumnIndex("images"));

        txtTitle.setText(title);
        txtDesc.setText(desc);

        /*
        try {
            url = new URL(sUrl);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
            imageView.setImageResource(context.getResources().getIdentifier("google_play_logo","drawable",context.getPackageName()));
        }
        */
        //downloadImages dl = new downloadImages(context,imageView,sUrl);
        Log.d("TEST",desc);
        //dl.execute();
        //new downloadImages(context,imageView,sUrl).execute();


        //Bitmap bmp = BitmapFactory.decodeByteArray(img,0,img.length);
        //imageView.setImageBitmap(bmp);
    }
/*
    class downloadImages extends AsyncTask<Void,Void,Void>
    {
        Context c;
        ImageView iv;
        String su;
        URL url;
        Bitmap bmp;
        downloadImages(Context c,ImageView iv,String su)
        {
            this.c=c;
            this.iv=iv;
            this.su=su;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Log.d("TEST","Executing once");
            try {
                url = new URL(su);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                //this.cancel(true);
            } catch (Exception e) {
                e.printStackTrace();
                //iv.setImageResource(c.getResources().getIdentifier("google_play_logo","drawable",c.getPackageName()));
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //button.setEnabled(false);
            inAnimation = new AlphaAnimation(0f, 1f);
            inAnimation.setDuration(200);
            progressBarHolder.setAnimation(inAnimation);
            progressBarHolder.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            iv.setImageBitmap(bmp);

            outAnimation = new AlphaAnimation(1f, 0f);
            outAnimation.setDuration(200);
            progressBarHolder.setAnimation(outAnimation);
            progressBarHolder.setVisibility(View.GONE);
            //button.setEnabled(true);
            //this.cancel(true);
        }
    }*/
}
