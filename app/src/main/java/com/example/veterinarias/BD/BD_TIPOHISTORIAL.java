package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.TipoHistorial;

import java.util.ArrayList;
import java.util.List;

public class BD_TIPOHISTORIAL extends BD_CENTER {


    public BD_TIPOHISTORIAL(Context context) {
        super(context);
    }

    public void agregar(TipoHistorial tipoHistorial){
        String qry=TipoHistorialQRY.INSERT(tipoHistorial);
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!=null){
            bd.execSQL(qry);
            bd.close();
        }
    }

    public List<TipoHistorial> mostrar(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cur=bd.rawQuery(TipoHistorialQRY.SELECT_ALL(),null);
        List<TipoHistorial> nu=new ArrayList<>();
        if(cur.moveToFirst()){
            do{
                nu.add(new TipoHistorial(cur.getInt(0),cur.getString(1)));
            }while (cur.moveToNext());
        }
        return nu;
    }

}
