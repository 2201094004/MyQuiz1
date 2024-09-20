package com.syaviraindahmaryam.myquis.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.syaviraindahmaryam.myquis.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

    @Query("SELECT * FROM students")
    LiveData<List<Student>> getAllStudents();

    // Jika Anda ingin mengembalikan nama, nim, atau prodi sebagai String, buat querynya seperti ini:
    @Query("SELECT nama FROM students WHERE id = :studentId")
    String getNama();

    @Query("SELECT nim FROM students WHERE id = :studentId")
    String getNim();

    @Query("SELECT prodi FROM students WHERE id = :studentId")
    String getProdi();

    // Mengembalikan semua data mahasiswa sebagai List
    @Query("SELECT * FROM students")
    List<Student> getAllMahasiswa();

    // Mengembalikan id sebagai boolean mungkin tidak relevan, sesuaikan logika Anda
    @Query("SELECT id FROM students WHERE id = :studentId")
    boolean getId(int studentId);
}
