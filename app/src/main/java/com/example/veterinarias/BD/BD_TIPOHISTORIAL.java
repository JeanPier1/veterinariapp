package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.TipoHistorial;

import java.util.ArrayList;
import java.util.List;

public class BD_TIPOHISTORIAL extends SQLiteOpenHelper {

    public final static String BD = "BD_TIPOHISTORIAL";
    public final static int VERSION =1 ;


    public BD_TIPOHISTORIAL(Context context) {
        super(context, BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TipoHistorialQRY.CREARTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TipoHistorialQRY.TABLA);
        sqLiteDatabase.execSQL(TipoHistorialQRY.CREARTABLE);

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
