package com.example.veterinarias.BD;

import com.example.veterinarias.Entities.Historial;

public class Historialqry {
    public static  final String TABLA="HISTORIAL";
    public static  final String cID = "ID";
    public static  final String cFECHA = "FECHA";
    public static  final String cMOTIVO = "MOTIVO";
    public static final String cIDMASCOTAS = "IDMASCOTAS";
    public static final String cTIPO = "IDTIPOHISTORIAL";


    public static final String CREARTABLE = " CREATE TABLE "+TABLA+" ( "+ cID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ cFECHA+" TEXT, "+cMOTIVO+" TEXT, "+cIDMASCOTAS+" INTEGER," +
            ""+ cTIPO+" INTEGER  )";


    public static final String INSERT (Historial histo){
        String qry=" INSERT INTO "+TABLA+" VALUES(NULL, '"+histo.getFecha()+"','"+histo.getMotivo()+"' ,'"+histo.getIdmascotas()+"','"+histo.getIdtipohistorial()+"' )";
        return qry;
    }

    public static final String SELECT_ALL(){
        return "SELECT * FROM "+TABLA;
    }


    public static final String SELECT_TODO(){
        return "SELECT * FROM HISTORIAL AS HIS, TIPOHISTORIAL AS TIH WHERE HIS.IDTIPOHISTORIAL = TIH.ID AND HIS.IDMASCOTAS = ?";
    }

}
