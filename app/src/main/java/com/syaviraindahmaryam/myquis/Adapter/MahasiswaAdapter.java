package com.syaviraindahmaryam.myquis.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.syaviraindahmaryam.myquis.Dao.MahasiswaDao;
import com.syaviraindahmaryam.myquis.MainActivity;
import com.syaviraindahmaryam.myquis.Model.Mahasiswa;
import com.syaviraindahmaryam.myquis.R;

import java.util.List;

public class MahasiswaAdapter extends BaseAdapter {

    private final Context context;
    private final List<MahasiswaDao> mahasiswaList;

    public MahasiswaAdapter(Context context, List<MahasiswaDao> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    public MahasiswaAdapter(MainActivity context, List<MahasiswaDao> mahasiswaList, Context context1, List<MahasiswaDao> mahasiswaList1) {
        this.context = context1;
        this.mahasiswaList = mahasiswaList1;
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

        MahasiswaDao mahasiswa = mahasiswaList.get(position);

        namaTextView.setText(mahasiswa.getNama());
        nimTextView.setText(mahasiswa.getNim());
        prodiTextView.setText(mahasiswa.getProdi());

        return convertView;
    }
}
