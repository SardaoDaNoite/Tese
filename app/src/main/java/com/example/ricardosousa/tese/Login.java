package com.example.ricardosousa.tese;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    String url ="http://2.82.7.186/Tese_Servico/Service_Implement.svc/ValidateUser";
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        queue = Volley.newRequestQueue(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Button BLogin  = (Button)findViewById(R.id.login);
        final EditText name = (EditText)findViewById(R.id.Name);
        final EditText pass = (EditText)findViewById(R.id.Password);

        BLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressBar icon = (ProgressBar)findViewById(R.id.progressBar);
                icon.setVisibility(View.VISIBLE);
                BLogin.setEnabled(false);
                name.setEnabled(false);
                pass.setEnabled(false);
                final StringRequest stringRequest = new StringRequest(Request.Method.GET, url+"/"+name.getText()+"/"+pass.getText(),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject reader = new JSONObject(response);
                                    boolean validate = reader.getBoolean("Valid");
                                    if(validate){
                                        icon.setVisibility(View.INVISIBLE);
                                        Intent AMenu = new Intent(Login.this,Menu.class);
                                        startActivity(AMenu);
                                    }
                                    else {
                                        icon.setVisibility(View.INVISIBLE);
                                        BLogin.setEnabled(true);
                                        name.setEnabled(true);
                                        pass.setEnabled(true);
                                       Toast erro = Toast.makeText(Login.this,getResources().getString(R.string.passworderrada),Toast.LENGTH_LONG);
                                       erro.show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        BLogin.setEnabled(true);
                        name.setEnabled(true);
                        pass.setEnabled(true);
                        icon.setVisibility(View.INVISIBLE);
                        Toast erro = Toast.makeText(Login.this,getResources().getString(R.string.loginerro),Toast.LENGTH_LONG);
                        erro.show();
                    }
                });
                queue.add(stringRequest);
            }
        });

        TextView simbol = (TextView) findViewById(R.id.textView);
        Typeface font = Typeface.createFromAsset(getAssets(),"Fonts/fontawesome-webfont.ttf");
        simbol.setTypeface(font);
        simbol.setText("\uf023");
    }
}

