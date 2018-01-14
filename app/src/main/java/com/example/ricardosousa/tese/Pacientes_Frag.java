package com.example.ricardosousa.tese;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Ricardo Sousa on 1/2/2018.
 */

public class Pacientes_Frag extends android.support.v4.app.Fragment {

    ListView lista;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pacientes,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Paciente_Info_Lista data[] = new Paciente_Info_Lista[]{
                new Paciente_Info_Lista("Ricardo", "Masculino", 10),
                new Paciente_Info_Lista("Ricard", "Masculino1", 11),
                new Paciente_Info_Lista("Ricar", "Masculino2", 12),
                new Paciente_Info_Lista("Rica", "Masculino3", 13),
                new Paciente_Info_Lista("Ric", "Masculino4", 14),
        };

        ArrayAdapter_Lista_Paciente adapter = new ArrayAdapter_Lista_Paciente(view.getContext(),R.layout.list,data);
        lista = (ListView)view.findViewById(R.id.ListaPacientes);
        lista.setAdapter(adapter);
    }
}
