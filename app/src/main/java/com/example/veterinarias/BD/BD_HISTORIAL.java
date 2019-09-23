package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.Historial;

import java.util.ArrayList;
import java.util.List;

public class BD_HISTORIAL  extends BD_CENTER {


    public BD_HISTORIAL(Context context) {
        super(context);
    }

    public void agregar(Historial us){
        String qry=Historialqry.INSERT(us);
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!=null){
            bd.execSQL(qry);
            bd.close();
        }
    }



    public Cursor listarHistorial(int IDMASCOTAS){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res =db.rawQuery("SELECT HIS.FECHA,HIS.MOTIVO,TIH.ESTADO FROM HISTORIAL HIS INNER JOIN TIPOHISTORIAL TIH ON HIS.IDTIPOHISTORIAL = TIH.ID WHERE HIS.IDMASCOTAS = ?",new String[]{String.valueOf(IDMASCOTAS)});
        System.out.println("Pedido :  "+ res.getCount());
        return res;
    }




}
