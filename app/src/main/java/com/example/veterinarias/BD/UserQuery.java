package com.example.veterinarias.BD;

import com.example.veterinarias.Entities.Usuario;

public class UserQuery {
    public static  final String TABLA="USUARIO";
    public static  final String cID = "ID";
    public static  final String cUser = "USER";
    public static  final String cContraseña = "PASSWOORD";
    public static  final String cNombre = "NOMBRE";

    public static final String CREARTABLE = " CREATE TABLE "+TABLA+" ( "+ cID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+ cUser+" TEXT, "+cContraseña+" TEXT, "+cNombre +" TEXT  )";


    public static final String INSERT (Usuario usuario){
        String qry=" INSERT INTO "+TABLA+" VALUES(NULL, '"+usuario.getUser()+"','"+usuario.getPasswoord()+"','"+usuario.getNombre()+"' )";
        return qry;
    }

    public static final String SELECT_ALL(){
        return "SELECT * FROM "+TABLA;
    }

    public static final String VERIFICAR(String user, String pass){
        return "SELECT * FROM "+TABLA + " WHERE  "+cUser+" = '"+user+"' AND "+cContraseña+" = '"+pass+"' ";
    }



}
