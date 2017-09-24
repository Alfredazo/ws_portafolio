/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    Conexion conexion;

    public UsuarioDao() {
        conexion = new Conexion();
    }

    public boolean registrarUsuario(String nombreUsuario, String claveUsuario) {

        boolean agregado = false;
        String sql = "CALL PRACTICA1.ALGO(?,?)";
        try {
            
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            
            cs.setString(1, nombreUsuario);
            cs.setString(2, claveUsuario);

            int numFilas = cs.executeUpdate();
            
            if (numFilas == 0) {
                agregado = true;
            }            
        } catch (SQLException e) {
            System.out.println("Excep:"+e.getMessage());
        }

        return agregado;

    }

    public boolean validarClaveUsuario(String nombreUsuario, String claveUsuario) {

        boolean validado = false;

        String sql = "Select nombreUsuario, password from usuario Where nombreUsuario= ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals(nombreUsuario) && rs.getString(2).equals(claveUsuario)) {
                    validado = true;
                } else {
                    validado = false;
                }
            }

        } catch (Exception e) {
            System.out.println("algo" + e.getMessage());
        }
        return validado;
    }
}
