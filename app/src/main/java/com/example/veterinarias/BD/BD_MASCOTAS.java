package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.Mascotas;

import java.util.ArrayList;

public class BD_MASCOTAS extends BD_CENTER {

    public BD_MASCOTAS(Context context) {
        super(context);
    }

    public void agregar(Mascotas us){
        String qry=MascotasQuery.INSERT(us);
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!=null){
            bd.execSQL(qry);
            bd.close();
        }
    }

    public Cursor listaranimal(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery(MascotasQuery.findyYd(id),null);
        return res;
    }

    public ArrayList<Mascotas>Listado(int idmascotas){
        ArrayList<Mascotas> arrayList = new ArrayList<>();
        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor cursomascotas;
        if(bd!=null){
            cursomascotas = bd.rawQuery(MascotasQuery.SELECT_ALL(idmascotas),null);
            if(cursomascotas.moveToFirst()){
                do{
                    int id= cursomascotas.getInt(0);
                    String nombre  = cursomascotas.getString(1);
                    String sexo = cursomascotas.getString(2);
                    String raza = cursomascotas.getString(3);
                    String tipo = cursomascotas.getString(4);
                    int idusuario=cursomascotas.getInt(5);

                    Mascotas nu=new Mascotas(id,nombre,sexo,raza,tipo,idusuario);

                    arrayList.add(nu);
                }while (cursomascotas.moveToNext());
            }
        }
        return arrayList;
    }

}
