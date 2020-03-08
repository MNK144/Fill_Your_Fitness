package com.manank.gymapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends  SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Database.db";

    public static final String TABLE_SESSION = "session_table";
    public static final String S_COL_SESSION = "session";
    public static final String S_COL_EMAIL = "email";

    public static final String TABLE_WORKOUT = "workout_table";
    public static final String W_COL_TITLE = "title";
    public static final String W_COL_DESCRIPTION = "description";
    public static final String W_COL_IMAGES = "images";

    public static final String TABLE_DIET = "diet_table";
    public static final String D_COL_TITLE = "title";
    public static final String D_COL_DESCRIPTION = "description";
    public static final String D_COL_TIME = "time";
    public static final String D_COL_IMAGES = "images";
    public static final String D_COL_CALORIES = "calories";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_SESSION +" ("+S_COL_SESSION +" TEXT , "+ S_COL_EMAIL+ " TEXT)");//edit

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_SESSION +" ("+S_COL_SESSION +" TEXT , "+ S_COL_EMAIL+ " TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_WORKOUT +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+ W_COL_TITLE +" TEXT , "+ W_COL_DESCRIPTION + " TEXT , " + W_COL_IMAGES +" BLOB)");
        db.execSQL("CREATE TABLE " + TABLE_DIET +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+ D_COL_TITLE +" TEXT , "+ D_COL_DESCRIPTION + " TEXT , " + D_COL_IMAGES +" TEXT , " + D_COL_TIME + " TEXT , " + D_COL_CALORIES + " INTEGER(4))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SESSION);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_WORKOUT);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DIET);
        onCreate(db);
    }

    public String getUser(){
        String user="";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("SELECT "+S_COL_EMAIL+" FROM "+TABLE_SESSION,null);
        if (cr.moveToFirst()) {
            user = cr.getString(cr.getColumnIndex("email"));
        }
        return user;
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
    }
    public void deleteSession()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SESSION);//edit
    }
    public boolean setWorkout(String title,String desc,String img)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(W_COL_TITLE,title);
        cv.put(W_COL_DESCRIPTION,desc);
        cv.put(W_COL_IMAGES,img);
        long res = db.insert(TABLE_WORKOUT,null,cv);
        if(res==-1)
            return false;
        else
            return true;
    }
    public Cursor getWorkout()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_WORKOUT,null);
        return data;
    }
    public boolean setDiet(String title,String desc,String img,String time,int calories)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(D_COL_TITLE,title);
        cv.put(D_COL_DESCRIPTION,desc);
        cv.put(D_COL_IMAGES,img);
        cv.put(D_COL_TIME,time);
        cv.put(D_COL_CALORIES,calories);
        long res = db.insert(TABLE_DIET,null,cv);
        if(res==-1)
            return false;
        else
            return true;
    }
    public Cursor getDiet()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_DIET,null);
        return data;
    }
}
