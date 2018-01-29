package com.example.ricardosousa.tese;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Paciente_v1 extends AppCompatActivity {
    private static int currentPage = 0;
    private static int NUM_PAGES = 199;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_v1);

        final ViewPager teste = (ViewPager)findViewById(R.id.pagevierpaciente);
        teste.setPageMargin(-60);
        final PageAdapter a = new PageAdapter(getSupportFragmentManager());
        for(int q = 0; q< 200;q++){
            Paciente_Frag_V1 paciente = new Paciente_Frag_V1();
            if (q==1) paciente.Paciente("Paciente " + q,0);
            else paciente.Paciente("Paciente " + q,0.8f);
            a.AddFragment(paciente,getResources().getString(R.string.pacientes));
        }
        teste.setAdapter(a);

        final EditText procurar = (EditText)findViewById(R.id.Procurar);

        procurar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (procurar.getRight() - procurar.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        final Timer swipeTimer = new Timer();
                        final Handler handler = new Handler();
                        final Runnable Update = new Runnable() {
                            public void run() {
                                if (currentPage == NUM_PAGES) {
                                    currentPage = 0;
                                }
                                android.support.v4.app.Fragment current = a.getItem(currentPage);
                                TextView qe = (TextView)current.getActivity().findViewById(R.id.Nome_Lista);
                                if(qe.getText().toString().trim().equalsIgnoreCase(procurar.getText().toString().trim())){
                                    Toast.makeText(Paciente_v1.this, "IGUAL", Toast.LENGTH_SHORT).show();
                                    swipeTimer.cancel();
                                    swipeTimer.purge();
                                }
                                else{
                                    Toast.makeText(Paciente_v1.this, "Nao IGUAL", Toast.LENGTH_SHORT).show();
                                }
                                teste.setCurrentItem(currentPage++, true);
                            }
                        };
                        swipeTimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                handler.post(Update);
                            }
                        }, 1, 10000);
                    }
                }
                return false;
            }
        });


    }
}
