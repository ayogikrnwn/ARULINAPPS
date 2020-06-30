package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Checkout_PanenjoanAct extends AppCompatActivity {

    Button btngaleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout__panenjoan);

        btngaleri = findViewById(R.id.btngaleri);
        btngaleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gogaleri = new Intent(Checkout_PanenjoanAct.this, galeri_panenjoan.class);
                startActivity(gogaleri);
            }
        });
    }
}