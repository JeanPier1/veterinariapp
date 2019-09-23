package com.example.veterinarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.veterinarias.BD.BD_USER;
import com.example.veterinarias.BD.UserQuery;
import com.example.veterinarias.Entities.Usuario;

public class MainActivity extends AppCompatActivity {
    Button btningresar;
    EditText txtuser;
    EditText txtpass;
    Usuario us;
    BD_USER bd_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btningresar = findViewById(R.id.btningresar);
        txtuser = findViewById(R.id.txtuser);
        txtpass = findViewById(R.id.txtpass);
        bd_user = new BD_USER(getApplicationContext());
        /*us=new Usuario("abdiel","123","abdiel");
        bd_user.agregar(us);
        System.out.println(" : "+ bd_user.mostrar().size());
        */


        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txtusuario = txtuser.getText().toString();
                String txtpasswoord = txtpass.getText().toString();

                Cursor rs= bd_user.listaruser(txtusuario, txtpasswoord);
                if(rs.moveToFirst()!=false){
                    rs.moveToFirst();
                    int id= rs.getInt(rs.getColumnIndex(UserQuery.cID));
                    String user = rs.getString(rs.getColumnIndex(UserQuery.cNombre));
                    String pass= rs.getString(rs.getColumnIndex(UserQuery.cUser));
                    String nombre= rs.getString(rs.getColumnIndex(UserQuery.cNombre));
                    us= new Usuario(id,user,pass,nombre);
                    System.out.println("  asas : "+us.getId());
                    rs.close();
                    Intent as= new Intent(MainActivity.this, List_Mascotas.class);
                    as.putExtra("ID",String.valueOf(us.getId()));
                    as.putExtra("Nombre",us.getNombre());
                    startActivity(as);
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario No Existe", Toast.LENGTH_SHORT).show();
                    txtuser.setText("");
                    txtpass.setText("");
                }

            }
        });



    }

}
