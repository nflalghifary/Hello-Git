package com.example.hellogit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ProvinsiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> namaProvinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);
        String[] provinsi = getResources().getStringArray(R.array.Provinsi);
        namaProvinsi = new ArrayList<>();
        for(int i = 0; i < provinsi.length; i++){
            namaProvinsi.add(String.valueOf(provinsi[i]));
        }

        recyclerView = findViewById(R.id.recyclerProvinsi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, namaProvinsi);
        recyclerView.setAdapter(adapter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}