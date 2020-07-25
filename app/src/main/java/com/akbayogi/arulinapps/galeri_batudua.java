package com.akbayogi.arulinapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class galeri_batudua extends AppCompatActivity {
    ImageView joan1,joan2;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri_batudua);

        joan1 = findViewById(R.id.joan1);
        joan2 = findViewById(R.id.joan2);

        reference = FirebaseDatabase.getInstance().getReference()
                .child("Wisata").child("Batudua");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Picasso.with(galeri_batudua.this)
                        .load(dataSnapshot.child("url_galeri1")
                                .getValue().toString())
                        .into(joan1);

                Picasso.with(galeri_batudua.this)
                        .load(dataSnapshot.child("url_galeri2")
                                .getValue().toString())
                        .into(joan2);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

