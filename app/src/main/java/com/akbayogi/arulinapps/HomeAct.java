package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeAct extends AppCompatActivity {

    LinearLayout btn_panenjoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_panenjoan = findViewById(R.id.btn_panenjoan);
        btn_panenjoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gocheckpanenjoan = new Intent(HomeAct.this, Checkout_PanenjoanAct.class);
                startActivity(gocheckpanenjoan);
            }
        });
    }
}