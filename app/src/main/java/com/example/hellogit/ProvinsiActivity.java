package com.example.hellogit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProvinsiActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> namaProvinsi;
    ArrayList<String> totalKasus;
    ArrayList<String> sembuh;
    ArrayList<String> meninggal;
    ArrayList<String> positif;
    ArrayList<String> penambahanKasus;
    ArrayList<String> penambahanSembuh;

    String[] tmp =  new String[10];
    String URL = "https://data.covid19.go.id/public/api/prov.json";
    String[] jsonResponses = new String[10];
    String[] key;
    String[] jumlah_kasus;
    String[] jumlah_sembuh;
    String[] jumlah_meninggal;
    String[] jumlah_dirawat;
    String[] penambahanpositif;
    String[] penambahannegatif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provinsi);
//        String[] provinsi =  new String[10];
//
//        namaProvinsi = new ArrayList<>();
//        for(int i = 0; i < jsonResponses.length; i++){
//            namaProvinsi.add(String.valueOf(jsonResponses[i]));
//        }
//
//        recyclerView = findViewById(R.id.recyclerProvinsi);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new Adapter(this, namaProvinsi);
//        recyclerView.setAdapter(adapter);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] tes = {"tes","tes2"};
        Log.e("hasil provinsi", Arrays.toString(tes));

        String url = "https://data.covid19.go.id/public/api/prov.json";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("list_data");
                    key = new String[jsonArray.length()];;
                    jumlah_kasus = new String[jsonArray.length()];;
                    jumlah_sembuh = new String[jsonArray.length()];;
                    jumlah_meninggal = new String[jsonArray.length()];;
                    jumlah_dirawat = new String[jsonArray.length()];;
                    penambahanpositif = new String[jsonArray.length()];;
                    penambahannegatif = new String[jsonArray.length()];;
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        key[i] = jsonObject.getString("key");
                        jumlah_kasus[i] = jsonObject.getString("jumlah_kasus");
                        jumlah_sembuh[i] = jsonObject.getString("jumlah_sembuh");
                        jumlah_meninggal[i] = jsonObject.getString("jumlah_meninggal");
                        jumlah_dirawat[i] = jsonObject.getString("jumlah_dirawat");

                        JSONObject penambahan = jsonObject.getJSONObject("penambahan");
                        Log.e("penambahan object", String.valueOf(penambahan));

                        penambahanpositif[i] = penambahan.getString("positif");
                        penambahannegatif[i] = penambahan.getString("sembuh");

                        Log.e("penambahan positif", String.valueOf(penambahanpositif));
                        Log.e("penambahan negatif", String.valueOf(penambahannegatif));

                    }

                    namaProvinsi = new ArrayList<>();
                    totalKasus = new ArrayList<>();
                    sembuh = new ArrayList<>();
                    meninggal = new ArrayList<>();
                    positif = new ArrayList<>();
                    penambahanKasus = new ArrayList<>();
                    penambahanSembuh = new ArrayList<>();

                    for(int i = 0; i < key.length; i++){
                        namaProvinsi.add(String.valueOf(key[i]));
                    }

                    for(int i = 0; i < jumlah_kasus.length; i++){
                        totalKasus.add(String.valueOf(jumlah_kasus[i]));
                    }
                    for(int i = 0; i < jumlah_sembuh.length; i++){
                        sembuh.add(String.valueOf(jumlah_sembuh[i]));
                    }
                    for(int i = 0; i < jumlah_meninggal.length; i++){
                        meninggal.add(String.valueOf(jumlah_meninggal[i]));
                    }
                    for(int i = 0; i < jumlah_dirawat.length; i++){
                        positif.add(String.valueOf(jumlah_dirawat[i]));
                    }
                    for(int i = 0; i < penambahanpositif.length; i++){
                        penambahanKasus.add(String.valueOf(penambahanpositif[i]));
                    }
                    for(int i = 0; i < penambahannegatif.length; i++){
                        penambahanSembuh.add(String.valueOf(penambahannegatif[i]));
                    }

                    recyclerView = findViewById(R.id.recyclerProvinsi);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ProvinsiActivity.this));

//                    ArrayList<String>[] mapping = new ArrayList[]{namaProvinsi, totalKasus};

                    adapter = new Adapter(ProvinsiActivity.this, namaProvinsi, totalKasus, sembuh, meninggal, positif, penambahanKasus, penambahanSembuh);

//                    adapter = new Adapter(ProvinsiActivity.this, totalKasus);
                    recyclerView.setAdapter(adapter);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    Log.e("hasil provinsi", Arrays.toString(key));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);




    }




}