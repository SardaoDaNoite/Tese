package com.example.ricardosousa.tese;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ricardo Sousa on 1/11/2018.
 */

public class ArrayAdapter_Lista_Paciente extends ArrayAdapter<Paciente_Info_Lista> {
    Context context;
    int layoutResourceId;
    Paciente_Info_Lista data[] = null;

    public ArrayAdapter_Lista_Paciente(Context context, int layoutResourceId, Paciente_Info_Lista[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new Holder();
            holder.Nome = (TextView)row.findViewById(R.id.Nome_Lista);
            holder.sexo = (TextView)row.findViewById(R.id.Idade_Lista);

            row.setTag(holder);
        }
        else
        {
            holder = (Holder)row.getTag();
        }

        Paciente_Info_Lista paciente = data[position];
        holder.Nome.setText(paciente.Nome);
        holder.sexo.setText("Idade: " + paciente.idade + " Sexo: " + paciente.sexo);

        return row;
    }

    static class Holder{
        public TextView idade;
        public TextView Nome;
        public TextView sexo;
    }
}
