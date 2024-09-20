package com.syaviraindahmaryam.myquis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.syaviraindahmaryam.myquis.Adapter.StudentAdapter;
import com.syaviraindahmaryam.myquis.Dao.StudentDao;
import com.syaviraindahmaryam.myquis.Database.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private StudentDao studentDao;
    private StudentAdapter studentAdapter;
    private Button fabTambah;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_produk);
        fabTambah = findViewById(R.id.fab_Tambah);

        // Initialize the database
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "student-database")
                .allowMainThreadQueries() // This should be avoided in production, better to use async queries.
                .build();

        studentDao = db.studentDao();

        // Load data from the database
        loadData();

        // Handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student selectedStudent = (Student) studentAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, UpdateStudentActivity.class);
                intent.putExtra("id", selectedStudent.getId());
                startActivity(intent);
            }
        });

        // Handle FAB click to open TambahActivity
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        LiveData<List<Student>> allStudents = studentDao.getAllStudents();
        allStudents.observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                // Set up adapter when data changes
                Context context1 = null;
                List<StudentDao> mahasiswaList = null;
                studentAdapter = new StudentAdapter(MainActivity.this, students, context1, mahasiswaList);
                listView.setAdapter(studentAdapter);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list when returning to MainActivity
        loadData();
    }
}
