package com.syaviraindahmaryam.myquis.Dao;

import com.syaviraindahmaryam.myquis.MainActivity;
import com.syaviraindahmaryam.myquis.Model.Mahasiswa;

import java.util.List;

@Entity(tableName = "mahasiswa")
public class MahasiswaDao {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nama;
    private String nim;
    private String prodi;

    // Constructor, getter, and setter methods
    public MahasiswaDao(int id, String nama, String nim, String prodi) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
    }

    public MahasiswaDao(MainActivity mainActivity) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public List<MahasiswaDao> getAllMahasiswa() {
        return null;
    }

    public void update(Mahasiswa mahasiswa) {
    }

    public void deleteById() {
    }
}
