package com.syaviraindahmaryam.myquis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.syaviraindahmaryam.myquis.Dao.MahasiswaDao;
import com.syaviraindahmaryam.myquis.Model.Mahasiswa;

public class TambahActivity extends AppCompatActivity {

    private EditText namaEditText;
    private EditText nimEditText;
    private EditText prodiEditText;
    private Button simpanButton;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        // Inisialisasi EditText dan Button
        namaEditText = findViewById(R.id.nama);
        nimEditText = findViewById(R.id.nim);
        prodiEditText = findViewById(R.id.prodi);
        simpanButton = findViewById(R.id.button_tambah);

        // Inisialisasi AppDatabase
        appDatabase = AppDatabase.getInstance(this);

        // Set OnClickListener untuk tombol simpan
        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = namaEditText.getText().toString();
                String nim = nimEditText.getText().toString();
                String prodi = prodiEditText.getText().toString();
                MahasiswaDao mahasiswa = new MahasiswaDao(0, nama, nim, prodi);

                // Menyimpan data mahasiswa ke database
                appDatabase.mahasiswaDao().insert(mahasiswa);

                // Menutup aktivitas setelah data disimpan
                finish();
            }
        });
    }
}
