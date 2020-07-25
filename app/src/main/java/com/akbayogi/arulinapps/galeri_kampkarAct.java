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

public class galeri_kampkarAct extends AppCompatActivity {
    ImageView joan1,joan2,joan3,joan4;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeri_kampkar);



        joan1 = findViewById(R.id.joan1);
        joan2 = findViewById(R.id.joan2);
        joan3 = findViewById(R.id.joan3);
        joan4  = findViewById(R.id.joan4);


        reference = FirebaseDatabase.getInstance().getReference()
                .child("Wisata").child("Kampung Karuhun");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Picasso.with(galeri_kampkarAct.this)
                        .load(dataSnapshot.child("url_galeri1")
                                .getValue().toString())
                        .into(joan1);

                Picasso.with(galeri_kampkarAct.this)
                        .load(dataSnapshot.child("url_galeri2")
                                .getValue().toString())
                        .into(joan2);

                Picasso.with(galeri_kampkarAct.this)
                        .load(dataSnapshot.child("url_galeri3")
                                .getValue().toString())
                        .into(joan3);

                Picasso.with(galeri_kampkarAct.this)
                        .load(dataSnapshot.child("url_galeri4")
                                .getValue().toString())
                        .into(joan4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
