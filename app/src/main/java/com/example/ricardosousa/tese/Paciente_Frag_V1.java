package com.example.ricardosousa.tese;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Ricardo Sousa on 1/29/2018.
 */

public class Paciente_Frag_V1  extends android.support.v4.app.Fragment {

    String name;
    float scale;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list,container,false);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView teste = (TextView)view.findViewById(R.id.Nome_Lista);
        teste.setText(name);
        if(scale!=0)  {
            view.setScaleX(scale);
            view.setScaleY(scale);
            view.setElevation(-15);
        }

    }

     public void Paciente(String Name, float i ) {
        name = Name;
        scale=i;
    }
}
