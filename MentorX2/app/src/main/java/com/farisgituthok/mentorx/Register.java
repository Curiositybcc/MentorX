package com.farisgituthok.mentorx;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private Button bRegister;
    private EditText etUsername;
    private EditText etNumber;
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPassword2;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();

        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etNumber = (EditText) findViewById(R.id.etNumber);
        etName = (EditText) findViewById(R.id.etName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPassword2 = (EditText) findViewById(R.id.etPassword2);

    }

    private void registerUser(){
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String number = etNumber.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String password2 = etPassword2.getText().toString().trim();

        if (TextUtils.equals(password,password2)){
            Toast.makeText(this,"Password Tidak Cocok",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(username)){
            Toast.makeText(this,"Username Kosong",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Email Kosong",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(number)){
            Toast.makeText(this,"Nomor HP Kosong",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"Nama Kosong",Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Registering...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this,"Register Berhasil",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(Register.this,"Register Gagal",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if (v == bRegister){
            registerUser();
        }
    }
}
