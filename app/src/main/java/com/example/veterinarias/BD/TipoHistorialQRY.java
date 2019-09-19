package com.example.veterinarias.BD;

import com.example.veterinarias.Entities.TipoHistorial;

public class TipoHistorialQRY {
    public static  final String TABLA="TIPOHISTORIAL";
    public static  final String cID = "ID";
    public static  final String cESTADO = "ESTADO";


    public static final String CREARTABLE = " CREATE TABLE "+TABLA+" ( "+ cID+" INTEGER PRIMARY KEY AUTOINCREMENT," +cESTADO +" TEXT  )";


    public static final String INSERT (TipoHistorial histo){
        String qry=" INSERT INTO "+TABLA+" VALUES(NULL, '"+histo.getEstado()+"' )";
        return qry;
    }

    public static final String SELECT_ALL(){
        return "SELECT * FROM "+TABLA;
    }
}
