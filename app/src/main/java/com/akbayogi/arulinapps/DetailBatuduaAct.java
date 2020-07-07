package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailBatuduaAct extends AppCompatActivity {

    Button btn_galerybatdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_batudua);

        btn_galerybatdu = findViewById(R.id.btn_galerybatdu);
        btn_galerybatdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galerybatdu = new Intent(DetailBatuduaAct.this, galeri_batudua.class);
                startActivity(galerybatdu);
            }
        });
    }
}