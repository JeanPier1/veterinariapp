package com.example.veterinarias.BD;

import com.example.veterinarias.Entities.Mascotas;

public class MascotasQuery {
    public static  final String TABLA="MASCOTAS";
    public static  final String cID = "ID";
    public static  final String cNOMBRE = "NOMBRE";
    public static  final String cSEXO = "SEXO";
    public static  final String cRAZA = "RAZA";
    public static  final String cTIPO = "TIPO";
    public static final String cIDUSUARIO= "IDUSUARIO";

    public static final String CREARTABLE = " CREATE TABLE "+TABLA+" ( "+ cID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ cNOMBRE+" TEXT, "+cSEXO+" TEXT, "+
            cRAZA +" TEXT, "+cTIPO+" TEXT ,"+cIDUSUARIO+" INTEGER )";

    public static final String INSERT (Mascotas mas){
        String qry=" INSERT INTO "+TABLA+" VALUES(NULL, '"+mas.getNombre()+"','"+mas.getSexo()+"','"+mas.getRaza()+"', '"+mas.getTipo()+"','"+mas.getIdusuario()+"' )";
        return qry;
    }

    public static final String SELECT_ALL(){
        return "SELECT * FROM "+TABLA;
    }


    public static  final String findyYd(int id){
        return  "SELECT * FROM "+TABLA+" WHERE "+cID+"= "+id;
    }
}
