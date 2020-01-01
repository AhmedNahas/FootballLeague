package com.example.footballleague.dbHelper;

import android.provider.BaseColumns;

public class LeagueContract {
    private LeagueContract() {
    }

    public static class LeagurEntry implements BaseColumns{
        public static final String TABLE_NAME = "league";
        public static final String COLUMN_SHORT_NAME = "shortName";
        public static final String COLUMN_LONG_NAME = "longName";

    }
}
