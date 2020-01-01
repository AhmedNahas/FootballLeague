package com.example.footballleague.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LeagueHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "my_league.db";
    public static final int DATABASE_VERSION = 1;

    public LeagueHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES = "CREATE TABLE " + LeagueContract.LeagurEntry.TABLE_NAME
                + " ("
                + LeagueContract.LeagurEntry._ID + " INTEGER PRIMARY KEY,"
                + LeagueContract.LeagurEntry.COLUMN_LONG_NAME + " TEXT,"
                + LeagueContract.LeagurEntry.COLUMN_SHORT_NAME + " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + LeagueContract.LeagurEntry.TABLE_NAME);
        onCreate(db);
    }
}
