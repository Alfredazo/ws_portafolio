package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.PersonaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*Clase usada solo de referencia para rescatar datos completos del usuario y convertirlo en un return de un objeto compuesto
para mejorar el manejo de la informacion a traves del WS*/
public class PersonaUsuarioDao {

    Conexion conexion;

    public PersonaUsuarioDao() {
        conexion = new Conexion();
    }

    public ArrayList<PersonaUsuario> listarInformacionCompletaTodosLosUsuarios() {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "Select p.rut, p.primernombre, p.segundonombre, p.primerapellido, p.segundoapellido,u.usuario, u.email, u.punto, u.imagen, u.nivelusuario, p.usuario_id ,u.id "
                + " From Persona p Join Usuario u "
                + " on(u.id = p.usuario_id)";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String rut = rs.getString(1);
                String primerNombre = rs.getString(2);
                String segundoNombre = rs.getString(3);
                String primerApellido = rs.getString(4);
                String segundoApellido = rs.getString(5);
                String usuario = rs.getString(6);
                String email = rs.getString(7);
                int puntosAcumulados = rs.getInt(8);
                String urlImagen = rs.getString(9);
                int nivelUsuario = rs.getInt(10);
                int idUsuarioPersona = rs.getInt(11);
                int usuarioID = rs.getInt(12);

                PersonaUsuario usuax = new PersonaUsuario(rut, primerNombre, segundoNombre, primerApellido, segundoApellido, usuario, email,
                        puntosAcumulados, urlImagen, nivelUsuario, idUsuarioPersona, usuarioID);

                listaUsuarios.add(usuax);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaUsuarios;
    }

    public ArrayList<PersonaUsuario> listarInformacionCompletaDelUsuariosPorUsuarioClave(String nombreUsuario, String claveUsuario) {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "Select p.rut, p.primernombre, p.segundonombre, p.primerapellido, p.segundoapellido,u.usuario, u.email, u.punto, u.imagen, u.nivelusuario, p.usuario_id ,u.id "
                + " From Persona p Join Usuario u "
                + " on(u.id = p.usuario_id) "
                + " where u.usuario = ? and u.contraseña = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, claveUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                   String rut = rs.getString(1);
                String primerNombre = rs.getString(2);
                String segundoNombre = rs.getString(3);
                String primerApellido = rs.getString(4);
                String segundoApellido = rs.getString(5);
                String usuario = rs.getString(6);
                String email = rs.getString(7);
                int puntosAcumulados = rs.getInt(8);
                String urlImagen = rs.getString(9);
                int nivelUsuario = rs.getInt(10);
                int idUsuarioPersona = rs.getInt(11);
                int usuarioID = rs.getInt(12);

                PersonaUsuario usuax = new PersonaUsuario(rut, primerNombre, segundoNombre, primerApellido, segundoApellido, usuario, email,
                        puntosAcumulados, urlImagen, nivelUsuario, idUsuarioPersona, usuarioID);

                listaUsuarios.add(usuax);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaUsuarios;
    }

    public ArrayList<PersonaUsuario> listarInformacionCompletaDelUsuariosPorCorreoClave(String correoUsuario, String claveUsuario) {

        ArrayList listaUsuarios = new ArrayList();

        String sql = "Select p.rut, p.primernombre, p.segundonombre, p.primerapellido, p.segundoapellido,u.usuario, u.email, u.punto, u.imagen, u.nivelusuario, p.usuario_id ,u.id "
                + " From Persona p Join Usuario u "
                + " on(u.id = p.usuario_id) "
                + " where u.usuario = ? and u.contraseña = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, correoUsuario);
            ps.setString(2, claveUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                  String rut = rs.getString(1);
                String primerNombre = rs.getString(2);
                String segundoNombre = rs.getString(3);
                String primerApellido = rs.getString(4);
                String segundoApellido = rs.getString(5);
                String usuario = rs.getString(6);
                String email = rs.getString(7);
                int puntosAcumulados = rs.getInt(8);
                String urlImagen = rs.getString(9);
                int nivelUsuario = rs.getInt(10);
                int idUsuarioPersona = rs.getInt(11);
                int usuarioID = rs.getInt(12);

                PersonaUsuario usuax = new PersonaUsuario(rut, primerNombre, segundoNombre, primerApellido, segundoApellido, usuario, email,
                        puntosAcumulados, urlImagen, nivelUsuario, idUsuarioPersona, usuarioID);

                listaUsuarios.add(usuax);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaUsuarios;
    }

}
