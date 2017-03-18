package com.farisgituthok.mentorx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button bLogin;
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        bLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvRegister){
            Intent registerIntent = new Intent(Login.this,Register.class);
            Login.this.startActivity(registerIntent);
        }
        if (v == bLogin){

        }
    }
}
