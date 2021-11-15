package com.example.hellogit;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private List<String> data;

    Adapter(Context context,List<String> data){
         this.layoutInflater = LayoutInflater.from(context);
         this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.card_provinsi, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String namaProvinsi = data.get(position);
        holder.namaProvinsi.setText(namaProvinsi);
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
