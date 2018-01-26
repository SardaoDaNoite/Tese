package com.example.ricardosousa.tese;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Ricardo Sousa on 1/26/2018.
 */

public class StacKAdapter extends BaseAdapter {

    ArrayList list;
    LayoutInflater inflater;
    ViewHolder holder = null;


    public StacKAdapter(Context context, ArrayList arrayList){
        this.list = arrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i).toString();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder();
            holder.text = (EditText) view.findViewById(R.id.edittext_stack);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.text.setText(getItem(i));
        return view;
    }

    public class ViewHolder{
        EditText text;
    }
}
