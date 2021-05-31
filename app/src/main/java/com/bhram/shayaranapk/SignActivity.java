package com.bhram.shayaranapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignActivity extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseFirestore database;
    EditText emailBox,psswdBox,nameBox;
    Button loginBtn , signBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();

        emailBox = findViewById(R.id.emailBtn);
        psswdBox = findViewById(R.id.psswdBtn);
        nameBox = findViewById(R.id.namebox);

        loginBtn = findViewById(R.id.loginBtn);
        signBtn = findViewById(R.id.createBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignActivity.this,LoginActivity.class));
            }
        });

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass,name;
                email =emailBox.getText().toString();
                pass = psswdBox.getText().toString();
                name = nameBox.getText().toString();

                final User user = new User();
                user.setEmail(email);
                user.setPass(pass);
                user.setName(name);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            database.collection("Users")
                                    .document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    startActivity(new Intent(SignActivity.this,LoginActivity.class));
                                }
                            });
                            Toast.makeText(SignActivity.this,"Account is Created",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SignActivity.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}