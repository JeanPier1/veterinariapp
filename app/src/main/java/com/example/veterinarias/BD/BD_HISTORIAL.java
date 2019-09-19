package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.Historial;

import java.util.ArrayList;
import java.util.List;

public class BD_HISTORIAL  extends SQLiteOpenHelper {

    public final static String BD = "BD_HISTORIAL";
    public final static int VERSION =1 ;

    public BD_HISTORIAL(Context context) {
        super(context, BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Historialqry.CREARTABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Historialqry.TABLA);
        sqLiteDatabase.execSQL(Historialqry.CREARTABLE);

    }


    public void agregar(Historial us){
        String qry=Historialqry.INSERT(us);
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!=null){
            bd.execSQL(qry);
            bd.close();
        }
    }



    public List<Historial> listarHistorial(int IDMASCOTAS){
        SQLiteDatabase db=this.getWritableDatabase();
        final String query = "SELECT * FROM HISTORIAL HIS INNER JOIN TIPOHISTORIAL TIH ON HIS.IDTIPOHISTORIAL = TIH.ID WHERE HIS.IDMASCOTAS = ?";
        Cursor asaasa =db.rawQuery("SELECT * FROM HISTORIAL HIS INNER JOIN TIPOHISTORIAL TIH ON HIS.IDTIPOHISTORIAL = TIH.ID WHERE HIS.IDMASCOTAS = ?",new String[]{String.valueOf(IDMASCOTAS)});
        System.out.println("Pedido :  "+ asaasa.getCount());

        /*List<Historial> usu= new ArrayList<>();
        if(res.moveToFirst()){
            do{
                usu.add(new Historial(res.getString(0),res.getString(1),res.getString(2)));
            }while (res.moveToNext());
        }
            */

        return null;
    }




}
