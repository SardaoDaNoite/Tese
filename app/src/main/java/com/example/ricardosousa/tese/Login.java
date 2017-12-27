package com.example.ricardosousa.tese;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        TextView simbol = (TextView) findViewById(R.id.textView);
        Typeface font = Typeface.createFromAsset(getAssets(),"Fonts/fontawesome-webfont.ttf");
        simbol.setTypeface(font);
        simbol.setText("\uf023");
    }
}
