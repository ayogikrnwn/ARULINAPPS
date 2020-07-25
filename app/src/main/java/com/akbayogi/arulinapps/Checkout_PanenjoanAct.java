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

public class Checkout_PanenjoanAct extends AppCompatActivity {

    Button btngaleri;
    TextView txtnama_wisata, txtdesc, txtdescsingkat,txtharga_tiket,txtlokasi_wisata;
    ImageView header;

    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout__panenjoan);


        txtnama_wisata = findViewById(R.id.txtnama_wisata);
        txtdesc = findViewById(R.id.txtdesc);
        txtdescsingkat = findViewById(R.id.txtdescsingkat);
        txtharga_tiket = findViewById(R.id.txtharga_tiket);
        txtlokasi_wisata = findViewById(R.id.txtlokasi_wisata);
        header = findViewById(R.id.header);

        reference = FirebaseDatabase.getInstance().getReference()
                .child("Wisata").child("Panenjoan");




        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtnama_wisata.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                txtdesc.setText(dataSnapshot.child("descwisata").getValue().toString());
                txtdescsingkat.setText(dataSnapshot.child("descsingkat").getValue().toString());
                txtharga_tiket.setText(dataSnapshot.child("harga_tiket").getValue().toString());
                txtlokasi_wisata.setText(dataSnapshot.child("lokasi_wisata").getValue().toString());

                Picasso.with(Checkout_PanenjoanAct.this)
                        .load(dataSnapshot.child("url_header")
                                .getValue().toString())
                        .into(header);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

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