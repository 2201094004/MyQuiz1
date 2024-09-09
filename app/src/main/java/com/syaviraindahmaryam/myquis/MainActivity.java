package com.syaviraindahmaryam.myquis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.syaviraindahmaryam.myquis.Adapter.MahasiswaAdapter;
import com.syaviraindahmaryam.myquis.Dao.MahasiswaDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MahasiswaDao mahasiswaDao;
    private MahasiswaAdapter mahasiswaAdapter;
    private Button fabTambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_produk);
        fabTambah = findViewById(R.id.fab_Tambah);

        mahasiswaDao = new MahasiswaDao(this);

        // Load data from the database
        List<MahasiswaDao> mahasiswaList = mahasiswaDao.getAllMahasiswa();
        Context context = null;
        mahasiswaAdapter = new MahasiswaAdapter(this, mahasiswaList, context, mahasiswaList);
        listView.setAdapter(mahasiswaAdapter);

        // Handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MahasiswaDao selectedMahasiswa = (MahasiswaDao) mahasiswaAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("id", selectedMahasiswa.getId());
                startActivity(intent);
            }
        });

        // Handle FAB click to open TambahActivity
        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TambahActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the list when returning to MainActivity
        List<MahasiswaDao> mahasiswaList = mahasiswaDao.getAllMahasiswa();
        mahasiswaAdapter.notifyDataSetChanged();
    }
}
