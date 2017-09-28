package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {

    Conexion conexion;

    public ProductoDao() {
        conexion = new Conexion();
    }

    public boolean registrarProducto(String nombre, int precio, String descripcionProducto, String urlFoto, String activo, int idEmpresa, int tipoProductoID, Date fechaIngreso, Date fechaCaducidad) 
        {
            boolean agregado = false;
            int idProducto = -1;
            String sql = "CALL PKG_PRODUCTO.pcd_insertar_producto(?,?,?,?,?,?,?,?,?)";
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
                cs.setDate(9, fechaIngreso);
                cs.setDate(10, fechaCaducidad);

                int numFilas = cs.executeUpdate();

                if (numFilas == 0) {
                    agregado = true;
                }            

        }catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return agregado;
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

}
