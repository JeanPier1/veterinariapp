package com.example.veterinarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.veterinarias.BD.BD_MASCOTAS;
import com.example.veterinarias.Entities.Mascotas;
import com.example.veterinarias.Utilidades.GridMascotas;

import java.util.ArrayList;

public class List_Mascotas extends AppCompatActivity {
    ListView idListview;
    GridMascotas gridMascotas;
    BD_MASCOTAS bd_mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__mascotas);
        idListview = findViewById(R.id.idListview);

        String id = getIntent().getStringExtra("ID");

        bd_mascotas=new BD_MASCOTAS(getApplicationContext());
        ArrayList<Mascotas> mus =bd_mascotas.Listado(Integer.parseInt(id));
        System.out.println(" :  :  "+mus.size());
        gridMascotas = new GridMascotas(mus,this);
        idListview.setAdapter(gridMascotas);

        idListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent inet = new Intent(List_Mascotas.this, Vista_User.class);
                inet.putExtra("ID",String.valueOf(((Mascotas)gridMascotas.getItem(i)).getId()));
                inet.putExtra("Nombre",((Mascotas)gridMascotas.getItem(i)).getNombre());
                startActivity(inet);
            }
        });
    }
}
