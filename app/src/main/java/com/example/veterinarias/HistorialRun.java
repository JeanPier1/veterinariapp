package com.example.veterinarias;

import android.database.Cursor;
import android.os.Bundle;

import com.example.veterinarias.BD.BD_HISTORIAL;
import com.example.veterinarias.BD.BD_TIPOHISTORIAL;
import com.example.veterinarias.Entities.Historial;
import com.example.veterinarias.Entities.TipoHistorial;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HistorialRun extends AppCompatActivity {
    ListView viewid;
    BD_HISTORIAL  bd_historial;
    BD_TIPOHISTORIAL bd_tipohistorial;
    Historial historialas,historialas1,historialas2;
    TipoHistorial tipoHistorial,tipoHistorial2,tipoHistorial3;
    String[] Arreglo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        viewid = findViewById(R.id.viewid);
        String idmascotas = getIntent().getStringExtra("idmascotas");

        bd_tipohistorial= new BD_TIPOHISTORIAL(getApplicationContext());
        bd_historial = new BD_HISTORIAL(getApplicationContext());

        System.out.println("Verificar tablas :  " + bd_tipohistorial.mostrar().size());

        Cursor res = bd_historial.listarHistorial(Integer.parseInt(idmascotas));

        int cantidad = res.getCount();
        int  i=0;
        Arreglo = new String[cantidad];
        if(res.moveToFirst()){
            do{
                String linea= "Fecha: " +res.getString(0)+" Motivo: "+res.getString(1)+" Estado: "+res.getString(2) +" ";
                Arreglo[i] =linea;
                i++;
            }while (res.moveToNext());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(HistorialRun.this,android.R.layout.simple_list_item_1,Arreglo);
        viewid.setAdapter(adapter);



/*        tipoHistorial = new TipoHistorial("ACTIVO");
        tipoHistorial2 = new TipoHistorial("INACTIVO");
        tipoHistorial3 = new TipoHistorial("ESPERA");
        bd_tipohistorial.agregar(tipoHistorial);
        bd_tipohistorial.agregar(tipoHistorial2);
        bd_tipohistorial.agregar(tipoHistorial3);
        historialas= new Historial("24/09/19","",Integer.parseInt(idmascotas),1);
        historialas1= new Historial("01/09/19","",Integer.parseInt(idmascotas),2);
        historialas2= new Historial("18/09/19","",Integer.parseInt(idmascotas),3);

        bd_historial.agregar(historialas);
        bd_historial.agregar(historialas1);
        bd_historial.agregar(historialas2);*/


    }

}
