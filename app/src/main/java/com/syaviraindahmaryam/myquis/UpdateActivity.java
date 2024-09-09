package com.syaviraindahmaryam.myquis;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.syaviraindahmaryam.myquis.Dao.MahasiswaDao;
import com.syaviraindahmaryam.myquis.Model.Mahasiswa;

import java.awt.peer.TextAreaPeer;

public class UpdateActivity extends AppCompatActivity {

    private EditText namaEditText;
    private EditText nimEditText;
    private EditText prodiEditText;
    private Button updateButton;
    private Button deleteButton;
    private AppDatabase appDatabase;
    private TextAreaPeer mahasiswaDao;
    private int mahasiswaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // Inisialisasi EditText dan Button
        namaEditText = findViewById(R.id.nama);
        nimEditText = findViewById(R.id.nim);
        prodiEditText = findViewById(R.id.prodi);
        updateButton = findViewById(R.id.button_update);
        deleteButton = findViewById(R.id.button_delete); // Tombol hapus

        // Inisialisasi AppDatabase dan MahasiswaDao
        appDatabase = AppDatabase.getInstance(this);
        mahasiswaDao = appDatabase.mahasiswaDao();

        // Ambil data dari intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mahasiswaId = extras.getInt("id");
            String nama = extras.getString("nama");
            String nim = extras.getString("nim");
            String prodi = extras.getString("prodi");

            namaEditText.setText(nama);
            nimEditText.setText(nim);
            prodiEditText.setText(prodi);
        }

        // Set OnClickListener untuk tombol update
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = namaEditText.getText().toString();
                String nim = nimEditText.getText().toString();
                String prodi = prodiEditText.getText().toString();
                Mahasiswa mahasiswa = new Mahasiswa(mahasiswaId, nama, nim, prodi);

                // Update data mahasiswa di database
                mahasiswaDao.update(mahasiswaDao);

                // Menutup aktivitas setelah data diupdate
                finish();
            }
        });

        // Set OnClickListener untuk tombol delete
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hapus data mahasiswa dari database
                mahasiswaDao.deleteById();

                // Menutup aktivitas setelah data dihapus
                finish();
            }
        });
    }
}
