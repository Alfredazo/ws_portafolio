/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.controller;

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
            if (this.comprobarNombreUsuario(nombreUsuario) || this.comprobarsiExisteEmail(email)) {
                agregado = false;
            } else {
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
            if (this.comprobarsiExisteEmail(email)) {
                modificado = false;
            } else {
                Connection accesoDB = conexion.getConexion();
                CallableStatement cs = accesoDB.prepareCall(sql);
                cs.setString(1, nombreUsuario);
                cs.setString(2, clave);
                cs.setString(3, email);
                cs.setInt(4, puntosAcumulados);
                cs.setInt(5, nivelUsuario);
                cs.setString(6, urlImagen);

                int numFilas = cs.executeUpdate();
                if (this.comprobarNombreUsuario(nombreUsuario)) {
                    modificado = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return modificado;

    }

    public boolean eliminarUsuario(String nombreUsuario) {
        boolean valida = false;
        String sql = "CALL PKG_USUARIO.pcd_borrar_usuario(?)";
        try {
            if (comprobarsiUsuarioExiste(nombreUsuario).equals("No Existe Usuario")) {
                valida = false;
            } else {
                Connection accesoDB = conexion.getConexion();
                CallableStatement cs = accesoDB.prepareCall(sql);
                cs.setString(1, nombreUsuario);

                cs.executeUpdate();
                boolean validador = this.comprobarNombreUsuario(nombreUsuario);
                if (validador) {
                    valida = false;
                } else {
                    valida = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }
        return valida;
    }

    /*Comprobar si existe*/
    public String comprobarsiUsuarioExiste(String nombreUsuario) {
        String existe = "No Existe Usuario";
        String sql = "Select usuario From Usuario Where usuario=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            if (rs.next()) {
                existe = "El Usuario si Existe";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return existe;
    }

    /*Metodo auxiliar que verifica si realmente se modifico*/
    public boolean comprobarNombreUsuario(String nombreUsuario) {
        boolean valida = false;
        String sql = "Select usuario From Usuario Where usuario=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
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
    public boolean comprobarsiExisteEmail(String email) {
        boolean valida = false;
        String sql = "Select email From Usuario Where email=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, email);
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

    public ArrayList<Usuario> listarUsuariosPorNivel(int nivelUsuarioEntrada) {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "Select * From Usuario where nivelusuario=?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, nivelUsuarioEntrada);
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

    public ArrayList<Usuario> listarUsuariosPorRangoDePuntos(int rangoInicial, int rangoFinal) {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "select * from usuario where punto Between ? and ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rangoInicial);
            ps.setInt(2, rangoFinal);
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

    public boolean validarUsuarioPorNombreUsuarioUCorreo(String nombreUsuarioUCorreo, String claveUsuario) {
        boolean validado = false;
        int resultado = nombreUsuarioUCorreo.indexOf("@");
        if (resultado != -1) {
            /*Valido Metodo de Correo*/
            validado = this.validarUsuarioPorCorreo(nombreUsuarioUCorreo, claveUsuario);
        } else {
            /*Valido Metodo Usuario*/
            validado = this.validarUsuarioPorNombre(nombreUsuarioUCorreo, claveUsuario);
        }

        return validado;
    }

    public boolean validarUsuarioPorNombre(String nombreUsuario, String claveUsuario) {
        boolean validado = false;

        String sql = "select usuario, contraseña  from usuario where usuario = ?";
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

    public boolean validarUsuarioPorCorreo(String correo, String claveUsuario) {
        boolean validado = false;

        String sql = "select email, contraseña  from usuario where email = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, correo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString(1).equals(correo) && rs.getString(2).equals(claveUsuario)) {
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

    public int devolverNivelUsuario(String nombreUCorreo) {
        int idUsuario = 0;
        String sql = "";
        int resultado = nombreUCorreo.indexOf("@");
        if (resultado != -1) {
            /*Valido Metodo de Correo*/
            sql = "select nivelusuario from usuario where email=?";
        } else {
            /*Valido Metodo Usuario*/
            sql = "select nivelusuario from usuario where usuario =?";
        }

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUCorreo);
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
