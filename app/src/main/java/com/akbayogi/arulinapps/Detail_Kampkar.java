package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Detail_Kampkar extends AppCompatActivity {

    Button btn_galerykampkar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__kampkar);

        btn_galerykampkar = findViewById(R.id.btn_galerykampkar);

        btn_galerykampkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galerykampkar = new Intent(Detail_Kampkar.this, galeri_kampkarAct.class);
                startActivity(galerykampkar);

            }
        });
    }
}