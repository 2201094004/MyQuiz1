package com.syaviraindahmaryam.myquis.Model;

public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;
    private String prodi;

    // Constructors
    public Mahasiswa() {}

    public Mahasiswa(int id, String nama, String nim, String prodi) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
    }

    // Getters and Setters
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
}
