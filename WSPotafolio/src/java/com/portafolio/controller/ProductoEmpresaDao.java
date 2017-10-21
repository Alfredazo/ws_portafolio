/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.Producto;
import com.portafolio.modelos.ProductoEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jared
 */
public class ProductoEmpresaDao {
    
      Conexion conexion;

    public ProductoEmpresaDao() {
        conexion = new Conexion();
    }
    
    public ArrayList<ProductoEmpresa> listarProductoEmpresa() {

        ArrayList listaProductoEmpresas = new ArrayList();

        String sql= "Select p.id, p.nombre, p.precio, p.descripcion, p.fotografia, p.activo, u.nombre as empresa, q.nombre as tipo, p.fechaingreso, p.fechacaducidad From producto p Join empresa u on(u.id = p.idempresa) join tipoproducto q on(q.id = p.tipoproducto_id)";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt(1);
                String nombre = rs.getString(2);
                int precio = rs.getInt(3);
                String descripcionProducto = rs.getString(4);
                String urlFoto = rs.getString(5);
                String activo = rs.getString(6);
                String empresa = rs.getString(7);
                String tipoProducto = rs.getString(8);
                String fechaIngreso = rs.getString(9);
                String fechaCaducidad = rs.getString(10);

                ProductoEmpresa productoEmpresa = new ProductoEmpresa(idProducto, nombre, precio, descripcionProducto, urlFoto, activo, empresa, tipoProducto, fechaIngreso, fechaCaducidad);
                listaProductoEmpresas.add(productoEmpresa);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaProductoEmpresas;
    }

    
}
