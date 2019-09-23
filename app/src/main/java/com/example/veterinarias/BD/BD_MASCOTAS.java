package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.Mascotas;

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

}
