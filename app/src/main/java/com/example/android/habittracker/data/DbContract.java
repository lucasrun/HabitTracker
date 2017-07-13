package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by mhesah on 2017-07-13.
 */

public class DbContract {

    // prevention for instantiating DbContract class
    public DbContract() {
    }

    // inner class for table#1 database entry
    public class DbEntry implements BaseColumns {

        // table name
        public final static String TABLE_NAME = "habit_tracker";

        // columns
        public final static String _ID = BaseColumns._ID;
        public final static String COL_MONTH = "Month";
        public final static String COL_TO_DO = "ToDo";
        public final static String COL_PROGRESS = "Progress";

        // month options
        public final static int MONTH_JANUARY = 1;
        public final static int MONTH_FEBRUARY = 2;
        public final static int MONTH_MARCH = 3;
        public final static int MONTH_APRIL = 4;
        public final static int MONTH_MAY = 5;
        public final static int MONTH_JUNE = 6;
        public final static int MONTH_JULY = 7;
        public final static int MONTH_AUGUST = 8;
        public final static int MONTH_SEPTEMBER = 9;
        public final static int MONTH_OCTOBER = 10;
        public final static int MONTH_NOVEMBER = 11;
        public final static int MONTH_DECEMBER = 12;

        // progress options
        public final static int PROG_DONE = 1;
        public final static int PROG_NOT_DONE = 0;
    }
}