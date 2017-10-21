package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDao {

    Conexion conexion;

    public ProductoDao() {
        conexion = new Conexion();
    }

    public boolean registrarProducto(String nombre, int precio, String descripcionProducto, String urlFoto, String activo, int idEmpresa, int tipoProductoID, String fechaIngreso, String fechaCaducidad) 
        {
            boolean agregado = false;
            int idProducto = -1;
            String sql = "CALL PKG_PRODUCTO.pcd_insertar_producto(?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection accesoDB = conexion.getConexion();
                CallableStatement cs = accesoDB.prepareCall(sql);
                //Invoco al metodo consultar ultima persona que me devuelve el id ingresado
                idProducto = this.retornarUltimoIdProducto() + 1;
                cs.setInt(1, idProducto);
                cs.setString(2, nombre);
                cs.setInt(3, precio);
                cs.setString(4, descripcionProducto);
                cs.setString(5, urlFoto);
                cs.setString(6, activo);
                cs.setInt(7, idEmpresa);
                cs.setInt(8, tipoProductoID);
                cs.setString(9, fechaIngreso);
                cs.setString(10, fechaCaducidad);

                int numFilas = cs.executeUpdate();

                if (numFilas == 0) {
                    agregado = true;
                }            

        }catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return agregado;
    }
    
        public boolean borrarProductoPorID(int idProducto) {
        boolean actualizado = false;
        String sql = "CALL PKG_PRODUCTO.pcd_borrar_producto(?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);

            cs.setInt(1, idProducto);

            cs.executeUpdate();
            if (comprobarSiExisteProductoID(idProducto)) {
                actualizado = false;
            } else {
                actualizado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return actualizado;
    }

    public ArrayList<Producto> listarProducto() {

        ArrayList listaProductos = new ArrayList();

        String sql = "Select * From Producto order by id";
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
                int idEmpresa = rs.getInt(7);
                int tipoProductoID = rs.getInt(8);
                String fechaIngreso = rs.getString(9);
                String fechaCaducidad = rs.getString(10);

                Producto producto = new Producto(idProducto, nombre, precio, descripcionProducto, urlFoto, activo, idEmpresa, tipoProductoID, fechaIngreso, fechaCaducidad);
                listaProductos.add(producto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaProductos;
    }


    public int retornarUltimoIdProducto() {
        int idProducto = 0;
        String sql = "select id from producto where rownum <= 1 order by id desc";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idProducto = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idProducto;
    }
    
    public boolean actualizarProducto(int idProducto, String nombre, int precio, String descripcionProducto, String urlFoto, String activo, int idEmpresa, int tipoProductoID, String fechaIngreso, String fechaCaducidad) {
        boolean actualizado = false;
        String sql = "CALL PKG_PRODUCTO.pcd_update_producto(?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idProducto);
            cs.setString(2, nombre);
            cs.setInt(3, precio);
            cs.setString(4, descripcionProducto);
            cs.setString(5, urlFoto);
            cs.setString(6, activo);
            cs.setInt(7, idEmpresa);
            cs.setInt(8, tipoProductoID);
            cs.setString(9, fechaIngreso);
            cs.setString(10, fechaIngreso);

            cs.executeUpdate();
            if (comprobarSiExisteProductoID(idProducto)) {
                actualizado = true;
            } else {
                actualizado = false;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return actualizado;
    }
    
    public boolean comprobarSiExisteProductoID(int idProducto) {
        boolean existe = false;
        String sql = "select id from proucto where id = ?"; 
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            } else {
                existe = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return existe;
    }

}
