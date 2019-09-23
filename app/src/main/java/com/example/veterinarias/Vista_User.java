package com.example.veterinarias;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.veterinarias.BD.BD_MASCOTAS;
import com.example.veterinarias.BD.MascotasQuery;
import com.example.veterinarias.Entities.Mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Vista_User extends AppCompatActivity {
    Button btnHistorial;
    TextView txtraza;
    TextView txtnombre;
    TextView txtsexo;
    Mascotas mascotas;
    BD_MASCOTAS bd_mascotas;
    int idmascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista__user);
        btnHistorial = findViewById(R.id.btnHistorial);
        txtraza = findViewById(R.id.txtraza);
        txtnombre = findViewById(R.id.txtnombre);
        txtsexo = findViewById(R.id.txtsexo);
        bd_mascotas = new BD_MASCOTAS(getApplicationContext());


        String id = getIntent().getStringExtra("ID");
        String nombre = getIntent().getStringExtra("Nombre");

        //AGREGAR MASCOTAS

 /*       mascotas=new Mascotas("Marquitos","M","PITBULL","null",Integer.parseInt(id));
        bd_mascotas = new BD_MASCOTAS(getApplicationContext());
        bd_mascotas.agregar(mascotas);
*/
        Cursor rs=bd_mascotas.listaranimal(Integer.parseInt(id));

        if(rs.moveToFirst()!=false){
            rs.moveToFirst();
            idmascotas=rs.getInt(rs.getColumnIndex(MascotasQuery.cID));
            String nombremascota= rs.getString(rs.getColumnIndex(MascotasQuery.cNOMBRE));
            String raza= rs.getString(rs.getColumnIndex(MascotasQuery.cRAZA));
            String sexo = rs.getString(rs.getColumnIndex(MascotasQuery.cSEXO));
            mascotas = new Mascotas(idmascotas,nombremascota,sexo,raza);
            txtnombre.setText("Nombre: "+nombremascota);
            txtraza.setText("Raza: "+raza);
            txtsexo.setText("Sexo: "+sexo);
            rs.close();
        }





        btnHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent os= new Intent(Vista_User.this, HistorialRun.class);
                os.putExtra("idmascotas", String.valueOf(idmascotas));
                startActivity(os);
            }
        });

    }

}
