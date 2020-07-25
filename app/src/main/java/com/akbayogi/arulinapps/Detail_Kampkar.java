package com.akbayogi.arulinapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Detail_Kampkar extends AppCompatActivity {

    Button btn_galerykampkar;
    TextView txtnama_wisata, txtdesc, txtdescsingkat,txtharga_tiket,txtlokasi_wisata;
    ImageView header;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__kampkar);


        txtnama_wisata = findViewById(R.id.txtnama_wisata);
        txtdesc = findViewById(R.id.txtdesc);
        txtdescsingkat = findViewById(R.id.txtdescsingkat);
        txtharga_tiket = findViewById(R.id.txtharga_tiket);
        txtlokasi_wisata = findViewById(R.id.txtlokasi_wisata);
        header = findViewById(R.id.header);


        reference = FirebaseDatabase.getInstance().getReference()
                .child("Wisata").child("Kampung Karuhun");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtnama_wisata.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                txtdesc.setText(dataSnapshot.child("descwisata").getValue().toString());
                txtdescsingkat.setText(dataSnapshot.child("descsingkat").getValue().toString());
                txtharga_tiket.setText(dataSnapshot.child("harga_tiket").getValue().toString());
                txtlokasi_wisata.setText(dataSnapshot.child("lokasi_wisata").getValue().toString());
                Picasso.with(Detail_Kampkar.this)
                        .load(dataSnapshot.child("url_header")
                                .getValue().toString())
                        .into(header);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_galerykampkar = findViewById(R.id.btn_galerykampkar);
        btn_galerykampkar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galerykampkar = new Intent(Detail_Kampkar.this, galeri_kampkarAct.class);
                startActivity(galerykampkar);

            }
        });
    }
}