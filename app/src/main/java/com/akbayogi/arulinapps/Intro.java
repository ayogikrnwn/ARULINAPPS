package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro extends AppCompatActivity {

    Button btn_masuk, btn_daftar22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btn_masuk = findViewById(R.id.btn_masuk);
        btn_daftar22 = findViewById(R.id.btn_daftar22);

        btn_daftar22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent godaftar = new Intent(Intro.this, SignUpAct.class);
                startActivity(godaftar);
            }
        });
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(Intro.this, LoginAct.class);
                startActivity(gologin);
            }


        });
    }
}