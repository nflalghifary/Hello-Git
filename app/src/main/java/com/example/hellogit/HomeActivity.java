package com.example.hellogit;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    private Calendar calendar;
    String positif = "";
    String sembuh = "";
    String meninggal = "";
    String rawat = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("EEEE, dd LLLL y");
        String formattedDate = df.format(c.getTime());
        TextView tanggalHariIni = (TextView)findViewById(R.id.homepage_date);
        tanggalHariIni.setText(formattedDate);

        String URL = "https://api.kawalcorona.com/indonesia/";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        TextView Total_positif = (TextView)findViewById(R.id.Total_Kasus_NumberPlaceholder);
        TextView Total_sembuh = (TextView)findViewById(R.id.homepage_isi_negatif);
        TextView Total_meninggal = (TextView)findViewById(R.id.homepage_isi_meninggal);
        TextView Total_rawat = (TextView)findViewById(R.id.homepage_isi_rawat);


        StringRequest objectRequest = new StringRequest (
                Request.Method.GET,
                URL,
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try {
                            JSONArray jsonarray = new JSONArray(response);

                            for(int i = 0; i < jsonarray.length(); i++){
                                JSONObject jsonobject = jsonarray.getJSONObject(i);
                                positif = jsonobject.getString("positif");
                                sembuh = jsonobject.getString("sembuh");
                                meninggal = jsonobject.getString("meninggal");
                                rawat = jsonobject.getString("dirawat");
                                Log.e("response 1", jsonobject.toString());
                                Log.e("response 2", positif);

                                Total_positif.setText(positif);
                                Total_sembuh.setText(sembuh);
                                Total_meninggal.setText(meninggal);
                                Total_rawat.setText(rawat);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.e("rest response", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);

    }
}