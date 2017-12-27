package com.example.ricardosousa.tese;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button BLogin  = (Button)findViewById(R.id.login);

        BLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AMenu = new Intent(Login.this,Menu.class);
                startActivity(AMenu);
            }
        });
    }
}
