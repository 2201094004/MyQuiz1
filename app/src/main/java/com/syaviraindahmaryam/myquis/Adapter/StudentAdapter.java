package com.syaviraindahmaryam.myquis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syaviraindahmaryam.myquis.Dao.StudentDao;
import com.syaviraindahmaryam.myquis.MainActivity;
import com.syaviraindahmaryam.myquis.R;
import com.syaviraindahmaryam.myquis.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private final Context context;
    private final List<StudentDao> mahasiswaList;

    public StudentAdapter(Context context, List<StudentDao> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    public StudentAdapter(MainActivity context, List<Student> students, Context context1, List<StudentDao> mahasiswaList) {
        this.context = context1;

        this.mahasiswaList = mahasiswaList;
    }

    @Override
    public int getCount() {
        return mahasiswaList.size();
    }

    @Override
    public Object getItem(int position) {
        return mahasiswaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false);
        }

        TextView namaTextView = convertView.findViewById(R.id.nama);
        TextView nimTextView = convertView.findViewById(R.id.nim);
        TextView prodiTextView = convertView.findViewById(R.id.prodi);

        StudentDao mahasiswa = mahasiswaList.get(position);

        namaTextView.setText(mahasiswa.getNama());
        nimTextView.setText(mahasiswa.getNim());
        prodiTextView.setText(mahasiswa.getProdi());

        return convertView;
    }
}
