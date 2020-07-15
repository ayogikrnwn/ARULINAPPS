package com.akbayogi.arulinapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailNangorakAct extends AppCompatActivity {


    Button btn_galerynang;
    TextView txtnama_wisata, txtdesc, txtdescsingkat,txtharga_tiket,txtlokasi_wisata;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nangorak);
        txtnama_wisata = findViewById(R.id.txtnama_wisata);
        txtdesc = findViewById(R.id.txtdesc);
        txtdescsingkat = findViewById(R.id.txtdescsingkat);
        txtharga_tiket = findViewById(R.id.txtharga_tiket);
        txtlokasi_wisata = findViewById(R.id.txtlokasi_wisata);

        reference = FirebaseDatabase.getInstance().getReference()
                .child("Wisata").child("Nangorak");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtnama_wisata.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                txtdesc.setText(dataSnapshot.child("descwisata").getValue().toString());
                txtdescsingkat.setText(dataSnapshot.child("descsingkat").getValue().toString());
                txtharga_tiket.setText(dataSnapshot.child("harga_tiket").getValue().toString());
                txtlokasi_wisata.setText(dataSnapshot.child("lokasi_wisata").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
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