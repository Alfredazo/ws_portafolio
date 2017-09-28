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
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PersonaDao {

    Conexion conexion;

    public PersonaDao() {
        conexion = new Conexion();
    }

    public boolean registrarPersona(String rut, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String direccion, int telefono, int idUsuario) {
        boolean registrado = false;
        String sql = "CALL PKG_PERSONA.pcd_insertar_persona(?,?,?,?,?,?,?,?,?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");            
            cs.setString(1, rut);
            cs.setString(2, primerNombre);
            cs.setString(3, segundoNombre);
            cs.setString(4, primerApellido);
            cs.setString(5, segundoApellido);
            cs.setString(6, fechaNacimiento);
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

    public boolean eliminarUsuario(int idUsuario) {
        boolean valida = false;
        String sql = "CALL PKG_PERSONA.pcd_borrar_persona(?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idUsuario);

            cs.executeUpdate();
            boolean validador = this.comprobarNombreUsuario(idUsuario);
            if (validador) {
                valida = false;
            } else {
                valida = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }
        return valida;
    }
    
    /*Metodo auxiliar que verifica si realmente se modifico*/
    public boolean comprobarNombreUsuario(int idUsuario) {
        boolean valida = false;
        String sql = "Select usuario From Usuario Where id=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                valida = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valida;
    }

    /*Metodo auxiliar que verifica si realmente se modifico*/
    public boolean comprobarsiExisteRut(String rut) {
        boolean valida = false;
        String sql = "Select rut From Persona Where rut=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");            
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                valida = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valida;
    }
    
}
