package com.example.hellogit;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private List<String> data;
    private List<String> data2;
    private List<String> data3;
    private List<String> data4;
    private List<String> data5;
    private List<String> data6;
    private List<String> data7;

    Adapter(Context context, List<String> data, ArrayList<String> data2, ArrayList<String> data3, ArrayList<String> data4, ArrayList<String> data5, ArrayList<String> data6, ArrayList<String> data7 ){
         this.layoutInflater = LayoutInflater.from(context);
         this.data = data;
         this.data2 = data2;
         this.data3 = data3;
         this.data4 = data4;
         this.data5 = data5;
         this.data6 = data6;
         this.data7 = data7;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_provinsi, viewGroup, false);
        return new ViewHolder(view);
    }

    public Object convertDecimal(String a){
        String number = a;
        double amount = Double.parseDouble(number);
        DecimalFormat formatter = new DecimalFormat("#,###");
// the zeroes after the point are the number of digits shown after the period
// you can also switch point and commas and get for example 1.002,45
        String res = String.valueOf(formatter.format(amount));

        return res;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,  int position) {
//        Log.e("ini bind", String.format("%,d", data2.get(position) ));
        String nameProvinsi = data.get(position);
        String totalKasus = (String) convertDecimal(data2.get(position));
        String sembuh = (String) convertDecimal(data3.get(position));
        String meninggal = (String) convertDecimal(data4.get(position));
        String positif = (String) convertDecimal(data5.get(position));
        String penambahanKasus = (String) convertDecimal(data6.get(position));
        String penambahanSembuh = (String) convertDecimal(data7.get(position));

        holder.namaProvinsi.setText(nameProvinsi);
        holder.totalKasus.setText(totalKasus);
        holder.sembuh.setText(sembuh);
        holder.meninggal.setText(meninggal);
        holder.positif.setText(positif);
        holder.penambahanKasus.setText(penambahanKasus);
        holder.penambahanSembuh.setText(penambahanSembuh);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView namaProvinsi, totalKasus, positif, sembuh,
                 meninggal, penambahanKasus, penambahanSembuh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            namaProvinsi = itemView.findViewById(R.id.card_namaprovinsi);
            totalKasus = itemView.findViewById(R.id.card_TotalKasusAngka);
            positif = itemView.findViewById(R.id.card_TotalPositifAngka);
            sembuh = itemView.findViewById(R.id.card_TotalSembuhAngka);
            meninggal = itemView.findViewById(R.id.card_TotalMeninggalAngka);
            penambahanKasus = itemView.findViewById(R.id.card_tambahkasus);
            penambahanSembuh = itemView.findViewById(R.id.card_tambahsembuh);
        }
    }
}
