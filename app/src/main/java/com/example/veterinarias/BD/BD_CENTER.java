package com.example.veterinarias.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD_CENTER extends SQLiteOpenHelper {

    public final static String BD = "BD_VETERINARIA";
    public final static int VERSION =1 ;

    public BD_CENTER( Context context) {
        super(context, BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Historialqry.CREARTABLE);
        sqLiteDatabase.execSQL(MascotasQuery.CREARTABLE);
        sqLiteDatabase.execSQL(UserQuery.CREARTABLE);
        sqLiteDatabase.execSQL(TipoHistorialQRY.CREARTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Historialqry.TABLA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+MascotasQuery.TABLA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UserQuery.TABLA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TipoHistorialQRY.TABLA);

        onCreate(sqLiteDatabase);
    }


}
