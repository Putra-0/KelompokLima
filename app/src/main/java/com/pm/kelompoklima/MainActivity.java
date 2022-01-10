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

public class MainActivity extends AppCompatActivity {

    EditText edusername, edpassword;
    TextView edDaftar;
    Button btnLogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edusername = findViewById(R.id.edUsername);
        edpassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnSubmit);
        edDaftar = findViewById(R.id.txDaftar);

        firebaseAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HalamanUtama.class);
                startActivity(intent);
            }
        });

        edDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftar = new Intent(MainActivity.this,SignUp.class);
                startActivity(daftar);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edusername.getText().toString().trim();
                String password = edpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    edusername.setError("Masukan Email Anda");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    edpassword.setError("Masukan Password Anda");
                    return;
                }
                if (password.length() < 8) {
                    edpassword.setError("Password tidak boleh kurang dari 8 karakter");
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Anda telah berhasil LogIn", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HalamanUtama.class));
                        } else {
                            Toast.makeText(MainActivity.this,"Gagal login"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}