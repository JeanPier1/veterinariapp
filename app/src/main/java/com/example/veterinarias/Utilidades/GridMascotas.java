package com.example.veterinarias.Utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.veterinarias.Entities.Mascotas;
import com.example.veterinarias.R;

import java.util.ArrayList;

public class GridMascotas extends BaseAdapter {

    ArrayList<Mascotas> misMascotas;
    Context context;


    public GridMascotas(ArrayList<Mascotas> misMascotas, Context context) {
        this.misMascotas = misMascotas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return misMascotas.size();
    }

    @Override
    public Object getItem(int i) {
        return misMascotas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_mascotas,null);
            TextView txtItemNombre= view.findViewById(R.id.txtItemNombre);

            txtItemNombre.setText(misMascotas.get(i).getNombre());

        }

        return view;
    }
}
