package com.manank.gymapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class DatabaseHelper extends  SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Database.db";

    public static final String TABLE_SESSION = "session_table";
    public static final String S_COL_SESSION = "session";
    public static final String S_COL_EMAIL = "email";

    public static final String TABLE_WORKOUT = "workout_table";
    public static final String S_COL_TITLE = "title";
    public static final String S_COL_DESCRIPTION = "description";
    public static final String S_COL_IMAGES = "images";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_SESSION +" ("+S_COL_SESSION +" TEXT , "+ S_COL_EMAIL+ " TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_WORKOUT +" ("+ S_COL_TITLE  +" TEXT , "+ S_COL_DESCRIPTION + " TEXT , " + S_COL_IMAGES+" BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SESSION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORKOUT);
        onCreate(db);
    }

    public boolean setSession(String session, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(S_COL_SESSION,session);
        cv.put(S_COL_EMAIL,email);
        long res = db.insert(TABLE_SESSION, null, cv);
        if(res == -1)
            return false;
        else
            return true;
    }
    public Cursor getSession()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_SESSION,null);
        return data;
        //Cursor result;
        /*
        try {
            Cursor result = db.rawQuery("select * from " + TABLE_SESSION, null);
            switch (d)
            {
                case 2:
                    return result.getString(1);
                default:
                    return result.getString(0);
            }
        }
        catch (Exception e)
        {
            Log.d("DB ERROR:","DATABASE HELPER->"+e);
            return "ERROR";
        }*/
    }
    public void deleteSession()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE " + TABLE_SESSION);
    }
    public void setWorkout(String title,String desc,byte[] img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(S_COL_TITLE,title);
        cv.put(S_COL_DESCRIPTION,desc);
        cv.put(S_COL_IMAGES,img);
    }
    public Cursor getWorkout()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_WORKOUT,null);
        return data;
    }
}
