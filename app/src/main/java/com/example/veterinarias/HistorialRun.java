package com.example.veterinarias;

import android.os.Bundle;

import com.example.veterinarias.BD.BD_HISTORIAL;
import com.example.veterinarias.BD.BD_TIPOHISTORIAL;
import com.example.veterinarias.Entities.Historial;
import com.example.veterinarias.Entities.TipoHistorial;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

public class HistorialRun extends AppCompatActivity {
    ListView viewid;
    BD_HISTORIAL  bd_historial;
    BD_TIPOHISTORIAL bd_tipohistorial;
    Historial historialas,historialas1,historialas2;
    TipoHistorial tipoHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        viewid = findViewById(R.id.viewid);
        String idmascotas = getIntent().getStringExtra("idmascotas");

        bd_tipohistorial= new BD_TIPOHISTORIAL(getApplicationContext());
        bd_historial = new BD_HISTORIAL(getApplicationContext());

        System.out.println("Verificar tablas :  " + bd_tipohistorial.mostrar().size());
       System.out.println(" : "+ bd_historial.listarHistorial(Integer.parseInt(idmascotas)));



        /*tipoHistorial = new TipoHistorial("ESPERA");
        bd_tipohistorial.agregar(tipoHistorial);
        historialas= new Historial("24/09/19","",Integer.parseInt(idmascotas),1);
        historialas1= new Historial("01/09/19","",Integer.parseInt(idmascotas),2);
        historialas2= new Historial("18/09/19","",Integer.parseInt(idmascotas),3);

        bd_historial.agregar(historialas);
        bd_historial.agregar(historialas1);
        bd_historial.agregar(historialas2);*/


    }

}
