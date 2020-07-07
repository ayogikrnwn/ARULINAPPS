package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailNangorakAct extends AppCompatActivity {


    Button btn_galerynang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nangorak);

        btn_galerynang = findViewById(R.id.btn_galerynang);
        btn_galerynang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galerynangorak = new Intent(DetailNangorakAct.this, galeri_nangorakAct.class);
                startActivity(galerynangorak);
            }
        });
    }
}