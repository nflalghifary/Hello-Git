package com.example.hellogit;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    private Calendar calendar;
    BottomNavigationView navigationView;

    public void goToAnActivity(View view) {
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

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


        navigationView = findViewById(R.id.bottom_navbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                int id = item.getItemId();
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                        break;
                    case R.id.nav_covid:
                        fragment = new COVIDFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();

                        break;
                    case R.id.nav_faq:
                        Intent i = new Intent(HomeActivity.this, Info.class);
                        startActivity(i);
                        break;
                    case R.id.nav_provinsi:
                        Intent s = new Intent(HomeActivity.this, ProvinsiActivity.class);
                        startActivity(s);
                        break;
                }
                return true;
            }
        });

    }


}