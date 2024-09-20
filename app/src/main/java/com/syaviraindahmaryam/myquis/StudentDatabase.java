package com.syaviraindahmaryam.myquis;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.syaviraindahmaryam.myquis.Dao.StudentDao;
import com.syaviraindahmaryam.myquis.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase instance;

    public abstract StudentDao studentDao();

    // Synchronized method to prevent multiple instances of the database being created
    public static synchronized StudentDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            StudentDatabase.class, "student_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
