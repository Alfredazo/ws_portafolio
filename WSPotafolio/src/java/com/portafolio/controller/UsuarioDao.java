/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.controller;

import com.portafolio.modelos.Algo;
import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    Conexion conexion;

    public UsuarioDao() {
        conexion = new Conexion();
    }

    public boolean registrarUsuario(String nombreUsuario, String claveUsuario) {

        boolean agregado = false;
        String sql = "CALL paqueteTrabajador.ALGO(?,?)";
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

    public ArrayList<Algo> listarUsuarios() {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "Select * From Algo";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                String digito1 = rs.getString(1);
                String digito2 = rs.getString(2);              
                
                Algo usuax = new Algo(digito1,digito2);
                listaUsuarios.add(usuax);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaUsuarios;
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
