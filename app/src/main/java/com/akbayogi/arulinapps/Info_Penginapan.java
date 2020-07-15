package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info_Penginapan extends AppCompatActivity {


    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sejarah);

        btnback = findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backhome = new Intent(Info_Penginapan.this, HomeAct.class);
                startActivity(backhome);
            }
        });
    }
}