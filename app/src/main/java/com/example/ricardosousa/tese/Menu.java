package com.example.ricardosousa.tese;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ContentHandlerFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private Handler handler;
    private TextView Data = null;
    private TextView Hora = null;
    SimpleDateFormat Hora_Format = new SimpleDateFormat("HH:mm");
    SimpleDateFormat Data_Format = new SimpleDateFormat("E  d  MMM");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        handler = new Handler();
        handler.post(Contador);
        Data = (TextView)findViewById(R.id.Data);
        Hora = (TextView)findViewById(R.id.Hora);
    }

     Runnable Contador = new Runnable() {
        @Override
        public void run() {
            Date currentTime = Calendar.getInstance().getTime();
            String hora = Hora_Format.format(currentTime);
            String data = Data_Format.format(currentTime);
            Data.setText(data);
            Hora.setText(hora);
            handler.postDelayed(this,1000);
            NavigationView esq = (NavigationView)findViewById(R.id.nvView);
        }
    };
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.Pacientes){

        }
        else if (id == R.id.Horario){

        }
        else if (id == R.id.Mensagens){

        }
        else if (id == R.id.Configuracoes){

        }
        return false;
    }
}
