package org.techtown.word;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.fragment.app.Fragment;

public class DAO {
    private SQLiteDatabase db;
    private Context context;

    private DAO dao;

    public DAO(Context context) {
        this.context = context;
        this.db = this.context.openOrCreateDatabase("ptk_db",Context.MODE_PRIVATE, null);
    }

    public SQLiteDatabase getDb() {
        return this.db;
    }
}
