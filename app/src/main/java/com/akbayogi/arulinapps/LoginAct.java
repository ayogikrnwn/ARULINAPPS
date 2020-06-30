package com.akbayogi.arulinapps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginAct extends AppCompatActivity {

    Button btn_masuk;
    EditText xusername, xpassword;
    TextView btn_daftar;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_daftar = findViewById(R.id.btn_daftar);
        btn_masuk = findViewById(R.id.btn_masuk);
        xusername = findViewById(R.id.xusername);
        xpassword = findViewById(R.id.xpassword);


        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent godaftar = new Intent(LoginAct.this, SignUpAct.class);
                startActivity(godaftar);
            }
        });
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ubah state menjadi loading
                btn_masuk.setEnabled(false);
                btn_masuk.setText("Loading ...");

                final String username = xusername.getText().toString();
                final String password = xpassword.getText().toString();

                reference = FirebaseDatabase.getInstance().getReference().child("Users").child(username);

                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {

                            //ambil data pass dari DB
                            String passwordFromDB = dataSnapshot.child("password").getValue().toString();


                            //validasi password dg DB
                            if (password.equals(passwordFromDB)) {

                            //simpan usernamekey  ke local

                                SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString(username_key, xusername.getText().toString());
                                editor.apply();

                                //pindah activity
                                Intent gohome = new Intent(LoginAct.this, HomeAct.class);
                                startActivity(gohome);

                            } else {

                                Toast.makeText(getApplicationContext(), "Password SALAH!", Toast.LENGTH_SHORT).show();

                            }



                        } else {
                            Toast.makeText(getApplicationContext(), "Username Tidak Ada", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });
    }
}