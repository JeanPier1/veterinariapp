package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.Mascotas;

public class BD_MASCOTAS extends SQLiteOpenHelper {

    public final static String BD = "BD_MASCOTAS";
    public final static int VERSION =2;

    public BD_MASCOTAS(Context context) {
        super(context, BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MascotasQuery.CREARTABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+MascotasQuery.TABLA);
        sqLiteDatabase.execSQL(MascotasQuery.CREARTABLE);
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
