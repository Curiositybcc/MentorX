package com.farisgituthok.mentorx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {

    private Button bRegister;
    private Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bRegister = (Button) findViewById(R.id.bRegister);
        bLogin = (Button) findViewById(R.id.bLogin);

        bRegister.setOnClickListener(this);
        bLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == bRegister){
            Intent registerIntent = new Intent(Main.this,Register.class);
            Main.this.startActivity(registerIntent);
        }
        if (v == bLogin){
            Intent loginIntent = new Intent(Main.this,Login.class);
            Main.this.startActivity(loginIntent);
        }
    }
}
