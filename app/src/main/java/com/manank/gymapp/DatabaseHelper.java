package com.manank.gymapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class DatabaseHelper extends  SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Database.db";

    public static final String TABLE_SESSION = "session_table";
    public static final String S_COL_SESSION = "session";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_SESSION +" ("+ S_COL_SESSION +" VARCHAR(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SESSION);
        onCreate(db);
    }

    public boolean setSession(String session)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(S_COL_SESSION,session);
        long res = db.insert(TABLE_SESSION, null, cv);
        if(res == -1)
            return false;
        else
            return true;
    }
    public String getSession()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select * from "+TABLE_SESSION,null);
        return result.getString(0);
    }
    public void deleteSession()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SESSION);
    }

}
