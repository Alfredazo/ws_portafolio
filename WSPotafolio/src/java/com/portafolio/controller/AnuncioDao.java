/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.controller;

import com.portafolio.modelos.Anuncio;
import com.portafolio.modelos.AnuncioSistema;
import com.portafolio.modelos.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Alfredazo
 */
public class AnuncioDao {

    Conexion conexion;

    public AnuncioDao() {
        conexion = new Conexion();
    }

    public ArrayList<Anuncio> mostrarAnuncioAlimentosHOME() {

        ArrayList listaAnuncioHome = new ArrayList();
        String sql = "select p.nombre, p.precio, p.fotografia, t.nombre ";
        sql += " From producto p Join tipoproducto t ";
        sql += " on(t.id = p.tipoproducto_id) ";
        sql += " where p.TIPOPRODUCTO_ID = 1 and p.activo = 1 ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString(1);
                int precio = rs.getInt(2);
                String urlImagen = rs.getString(3);
                String tipoProducto = rs.getString(4);

                Anuncio anuncio = new Anuncio(nombreProducto, precio, urlImagen, tipoProducto);
                listaAnuncioHome.add(anuncio);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaAnuncioHome;
    }
    
    public ArrayList<Anuncio> mostrarAnuncioElectronicaHOME() {

        ArrayList listaAnuncioHome = new ArrayList();
        String sql = "select p.nombre, p.precio, p.fotografia, t.nombre ";
        sql += " From producto p Join tipoproducto t ";
        sql += " on(t.id = p.tipoproducto_id) ";
        sql += " where p.TIPOPRODUCTO_ID = 2 and p.activo = 1 ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString(1);
                int precio = rs.getInt(2);
                String urlImagen = rs.getString(3);
                String tipoProducto = rs.getString(4);

                Anuncio anuncio = new Anuncio(nombreProducto, precio, urlImagen, tipoProducto);
                listaAnuncioHome.add(anuncio);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaAnuncioHome;
    }
    
    public ArrayList<Anuncio> mostrarAnuncioROPAHOME() {

        ArrayList listaAnuncioHome = new ArrayList();
        String sql = "select p.nombre, p.precio, p.fotografia, t.nombre ";
        sql += " From producto p Join tipoproducto t ";
        sql += " on(t.id = p.tipoproducto_id) ";
        sql += " where p.TIPOPRODUCTO_ID = 3 and p.activo = 1 ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString(1);
                int precio = rs.getInt(2);
                String urlImagen = rs.getString(3);
                String tipoProducto = rs.getString(4);

                Anuncio anuncio = new Anuncio(nombreProducto, precio, urlImagen, tipoProducto);
                listaAnuncioHome.add(anuncio);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaAnuncioHome;
    }
    
    public ArrayList<Anuncio> mostrarAnuncioLineaBlancaHOME() {

        ArrayList listaAnuncioHome = new ArrayList();
        String sql = "select p.nombre, p.precio, p.fotografia, t.nombre ";
        sql += " From producto p Join tipoproducto t ";
        sql += " on(t.id = p.tipoproducto_id) ";
        sql += " where p.TIPOPRODUCTO_ID = 4 and p.activo = 1 ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreProducto = rs.getString(1);
                int precio = rs.getInt(2);
                String urlImagen = rs.getString(3);
                String tipoProducto = rs.getString(4);

                Anuncio anuncio = new Anuncio(nombreProducto, precio, urlImagen, tipoProducto);
                listaAnuncioHome.add(anuncio);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaAnuncioHome;
    }
    
     public ArrayList<AnuncioSistema> listaRecomendacionSistema() {

        ArrayList listaRecomendacionSistema = new ArrayList();
        String sql = "select id,  nombre, fechaingreso, fechacaducidad,TO_CHAR(TO_DATE(fechacaducidad,'DD/MM/YYYY') - TRUNC(SYSDATE)), activo";
               sql+= " from producto ";
               sql+= " Order by fechacaducidad,TO_DATE(fechacaducidad,'DD/MM/YYYY') - TO_DATE(SYSDATE,'DD/MM/YYYY') ";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);                
                String nombreProducto = rs.getString(2);
                String fechaIngreso = rs.getString(3);
                String fechaCaducidad = rs.getString(4);
                String tiempoPerecible  = rs.getString(5);
                String activo = rs.getString(6);
                
                AnuncioSistema anuncio = new AnuncioSistema(id, nombreProducto, fechaIngreso, fechaCaducidad, tiempoPerecible, activo);
                listaRecomendacionSistema.add(anuncio);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaRecomendacionSistema;
    }
    

}
