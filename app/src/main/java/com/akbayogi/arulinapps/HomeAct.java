package com.akbayogi.arulinapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeAct extends AppCompatActivity {

    LinearLayout LLpanenjoan, LLkampkar, LLbatudua, LLnangorak, LLsejarah, LLmakanan, LLhotel ;
    ImageView about;
    TextView txtnama;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key ="";
    String username_key_new ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getUsernamelocal();

        LLsejarah = findViewById(R.id.LLsejarah);
        LLmakanan = findViewById(R.id.LLmakanan);
        LLhotel = findViewById(R.id.LLhotel);
        about = findViewById(R.id.about);
        LLpanenjoan = findViewById(R.id.LLpanenjoan);
        LLkampkar = findViewById(R.id.LLkampkar);
        LLbatudua = findViewById(R.id.LLbatudua);
        LLnangorak = findViewById(R.id.LLnangorak);
        txtnama = findViewById(R.id.txtnama);

        reference = FirebaseDatabase.getInstance().getReference()
                .child("Users").child(username_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtnama.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        LLnangorak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gocamp = new Intent(HomeAct.this, DetailNangorakAct.class);
                startActivity(gocamp);
            }
        });
        LLbatudua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gobatdu = new Intent(HomeAct.this, DetailBatuduaAct.class);
                startActivity(gobatdu);
            }
        });

        LLkampkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gokampkar = new Intent(HomeAct.this, Detail_Kampkar.class);
                startActivity(gokampkar);
            }
        });
        LLpanenjoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gocheckpanenjoan = new Intent(HomeAct.this, Checkout_PanenjoanAct.class);
                startActivity(gocheckpanenjoan);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ab = new Intent(HomeAct.this, About.class);
                startActivity(ab);
            }
        });
        LLsejarah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(HomeAct.this, Sejarah.class);
                startActivity(s);
            }
        });
        LLmakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m = new Intent(HomeAct.this, Makanan_Khas.class);
                startActivity(m);
            }
        });
        LLhotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent h = new Intent(HomeAct.this, Info_Penginapan.class);
                startActivity(h);
            }
        });
    }

    public void getUsernamelocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");

    }
}