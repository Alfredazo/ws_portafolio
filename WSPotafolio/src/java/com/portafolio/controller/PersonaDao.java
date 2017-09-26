/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDao {

    Conexion conexion;

    public PersonaDao() {
        conexion = new Conexion();
    }

    public boolean registrarPersona(String rut, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, Date fechaNacimiento, String direccion, int telefono, int idUsuario) {
        boolean registrado = false;        
        String sql = "CALL PKG_PERSONA.pcd_insertar_persona(?,?,?,?,?,?,?,?,?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, rut);
            cs.setString(2, primerNombre);
            cs.setString(3, segundoNombre);
            cs.setString(4, primerApellido);
            cs.setString(5, segundoApellido);
            cs.setDate(6, fechaNacimiento);
            cs.setString(7, direccion);
            cs.setInt(8, telefono);                  
            cs.setInt(9, idUsuario); 

            int numFilas = cs.executeUpdate();

            if (numFilas == 0) {
                registrado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return registrado;
    }
    
   

   
}
