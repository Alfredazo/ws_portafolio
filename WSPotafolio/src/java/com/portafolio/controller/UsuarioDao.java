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

    public boolean registrarUsuario(String nombreUsuario, String clave, String email, int puntosAcumulados, int nivelUsuario, String urlImagen) {
        boolean agregado = false;
        int idUsuario = -1;
        String sql = "CALL PKG_USUARIO.pcd_insertar_usuario(?,?,?,?,?,?,?)";
        try {

            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            //Invoco al metodo consultar ultima persona que me devuelve el id ingresado
            idUsuario = this.retornarUltimoIdPersonaAgregadaUsuario() + 1;
            cs.setInt(1, idUsuario);
            cs.setString(2, nombreUsuario);
            cs.setString(3, clave);
            cs.setString(4, email);
            cs.setInt(5, puntosAcumulados);
            cs.setInt(6, nivelUsuario);
            cs.setString(7, urlImagen);

            int numFilas = cs.executeUpdate();

            if (numFilas == 0) {
                agregado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return agregado;

    }

    public boolean modificarUsuario(String nombreUsuario, String clave, String email, int puntosAcumulados, int nivelUsuario, String urlImagen) {
        boolean modificado = false;
        String sql = "CALL PKG_USUARIO.pcd_update_usuario(?,?,?,?,?,?)";
        try {

            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, nombreUsuario);
            cs.setString(2, clave);
            cs.setString(3, email);
            cs.setInt(4, puntosAcumulados);
            cs.setInt(5, nivelUsuario);
            cs.setString(6, urlImagen);

            int numFilas = cs.executeUpdate();            
            if (this.comprobarModificacionUsuario(nombreUsuario)) {
                modificado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return modificado;

    }

    /*Metodo auxiliar que verifica si realmente se modifico*/
    public boolean comprobarModificacionUsuario(String nombreUsuario) {
        boolean valida = false;
        String sql = "Select usuario From Usuario Where usuario=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                valida = true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return valida;
    }

       private int idUsuario;
    private String usuario;
    private String clave;
    private String email;
    private int puntosAcumulados;
    private int nivelUsuario;
    private String urlImagen;
    
    public ArrayList<Usuario> listarUsuarios() {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "Select * From Usuario";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()) {
                int idUsuario = rs.getInt(1);
                String usuario = rs.getString(2);
                String clave = rs.getString(3);
                String email = rs.getString(4);
                int puntosAcumulados = rs.getInt(5);
                int nivelUsuario = rs.getInt(6);
                String urlImagen = rs.getString(7);

                Usuario usuax = new Usuario(idUsuario, usuario, clave, email, puntosAcumulados, nivelUsuario, urlImagen);
                listaUsuarios.add(usuax);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaUsuarios;
    }
// /*Modificar este metodo*/ 
//    public boolean validarClaveUsuario(String nombreUsuario, String claveUsuario) {
//
//        boolean validado = false;
//
//        String sql = "Select nombreUsuario, password from usuario Where nombreUsuario= ?";
//        try {
//            Connection accesoDB = conexion.getConexion();
//            PreparedStatement ps = accesoDB.prepareStatement(sql);
//            ps.setString(1, nombreUsuario);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                if (rs.getString(1).equals(nombreUsuario) && rs.getString(2).equals(claveUsuario)) {
//                    validado = true;
//                } else {
//                    validado = false;
//                }
//            }
//
//        } catch (Exception e) {
//            System.out.println("algo" + e.getMessage());
//        }
//        return validado;
//    }

    public int retornarUltimoIdPersonaAgregadaUsuario() {
        int idUsuario = 0;
        String sql = "select id from usuario where rownum <= 1 order by id desc";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idUsuario;
    }

}
