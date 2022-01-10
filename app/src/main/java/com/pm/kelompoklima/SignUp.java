package com.pm.kelompoklima;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    TextView masuk;
    EditText email, fullname, username, password;
    Button daftar,loginFb;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        masuk = findViewById(R.id.tvMasuk);
        email = findViewById(R.id.EdEmail);
        fullname = findViewById(R.id.edFullname);
        username = findViewById(R.id.edUsername);
        password = findViewById(R.id.edPasswordSU);
        daftar = findViewById(R.id.btnDaftar);
        loginFb = findViewById(R.id.btnFB);

        firebaseAuth = FirebaseAuth.getInstance();



        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();

                if (TextUtils.isEmpty(Email)){
                    email.setError("Masukan Email Anda");
                    return;
                }
                if (TextUtils.isEmpty(Password)){
                    password.setError("Masukan Password Anda");
                    return;
                }
                if (Password.length() < 8) {
                    password.setError("Password tidak boleh kurang dari 8 karakter");
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Anda telah berhasil mendaftar", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        } else {
                            Toast.makeText(SignUp.this,"Gagal mendaftar"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}