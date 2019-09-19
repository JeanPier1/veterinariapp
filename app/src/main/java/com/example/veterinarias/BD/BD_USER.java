package com.example.veterinarias.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.veterinarias.Entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BD_USER extends SQLiteOpenHelper {

    public final static String BD = "BD_USER";
    public final static int VERSION =3 ;

    public BD_USER(Context context) {
        super(context, BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserQuery.CREARTABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UserQuery.TABLA);
        sqLiteDatabase.execSQL(UserQuery.CREARTABLE);

    }


    public void agregar(Usuario us){
        String qry=UserQuery.INSERT(us);
        SQLiteDatabase bd= getWritableDatabase();
        if(bd!=null){
            bd.execSQL(qry);
            bd.close();
        }
    }

    public Cursor listaruser(String user, String pass){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res= db.rawQuery(UserQuery.VERIFICAR(user, pass),null);
        return res;
    }

    public List<Usuario> mostrar(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery(UserQuery.SELECT_ALL(), null);
        List<Usuario> sus=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                sus.add(new Usuario(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3)));
            }while (cursor.moveToNext());
        }
        return sus;
    }



}
