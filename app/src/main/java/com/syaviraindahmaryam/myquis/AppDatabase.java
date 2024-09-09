package com.syaviraindahmaryam.myquis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "app_database.db";
    private static final int DATABASE_VERSION = 1;

    public AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static AppDatabase getInstance(TambahActivity tambahActivity) {
        return null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE mahasiswa (id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, nim TEXT, prodi TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS mahasiswa");
        onCreate(db);
    }

    public java.awt.peer.TextAreaPeer mahasiswaDao() {
        return null;
    }
}
