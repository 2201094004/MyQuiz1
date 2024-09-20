package com.syaviraindahmaryam.myquis;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "students")
public class Student implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nama;
    private String nim;
    private String prodi;

    // Constructor
    public Student(String nama, String nim, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
    }

    // Getter dan Setter
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

    public int getName() {
        return 0;
    }

    public String getStudyProgram() {
        return null;
    }

    public void setName(String name) {
    }

    public void setStudyProgram(String program) {
    }
}
