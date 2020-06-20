package com.akbayogi.arulinapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpAct extends AppCompatActivity {

    Button btn_daftar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn_daftar1 = findViewById(R.id.btn_daftar1);
        btn_daftar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godaft = new Intent(SignUpAct.this, VerifDataAct.class);
                startActivity(godaft);
            }
        });
    }
}