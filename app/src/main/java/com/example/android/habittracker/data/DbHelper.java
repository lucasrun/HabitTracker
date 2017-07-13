package com.example.android.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.android.habittracker.data.DbContract.DbEntry;

/**
 * Created by mhesah on 2017-07-13.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = DbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "habit_tracker.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_HABIT_TRACKER = "CREATE TABLE IF NOT EXISTS " + DbEntry.TABLE_NAME +
                " ( " + DbEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbEntry.COL_MONTH + " INTEGER NOT NULL, " +
                DbEntry.COL_TO_DO + " TEXT NOT NULL, " +
                DbEntry.COL_PROGRESS + " INTEGER NOT NULL DEFAULT 0);";

        Log.e(LOG_TAG, "Creating table: " + CREATE_TABLE_HABIT_TRACKER);

        db.execSQL(CREATE_TABLE_HABIT_TRACKER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + DbEntry.TABLE_NAME);
        onCreate(db);
    }

    // inserting data into the table
    public void insertData(int month, String to_do, int progress) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DbEntry.COL_MONTH, month);
        values.put(DbEntry.COL_TO_DO, to_do);
        values.put(DbEntry.COL_PROGRESS, progress);

        long newRowId = db.insert(DbEntry.TABLE_NAME, null, values);

        db.close();
    }

    // reading table data
    public Cursor readData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                DbEntry._ID,
                DbEntry.COL_MONTH,
                DbEntry.COL_TO_DO,
                DbEntry.COL_PROGRESS};

        Cursor cursor = db.query(
                DbEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }
}