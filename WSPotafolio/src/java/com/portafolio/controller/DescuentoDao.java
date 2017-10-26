package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.Descuento;
import com.portafolio.modelos.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DescuentoDao {
   
   Conexion conexion;

    public DescuentoDao() {
        conexion = new Conexion();
    }
    
    public boolean registrarDescuento(String nombre, String descripcion, int descuento, String imagen, String condiciones, 
            String fechaInicio, String fechaTermino, int idProducto) 
        {
            boolean agregado = false;
            int idOferta = -1;
            String sql = "CALL PKG_OFERTA.pcd_insertar_oferta(?,?,?,?,?,?,?,?,?,?)";
            try {
                Connection accesoDB = conexion.getConexion();
                CallableStatement cs = accesoDB.prepareCall(sql);
                //Invoco al metodo consultar ultima persona que me devuelve el id ingresado
                idOferta = this.retornarUltimoIdDescuento() + 1;
                cs.setInt(1, idOferta);
                cs.setString(2, nombre);
                cs.setString(3, descripcion);
                cs.setInt(4, descuento);
                cs.setString(5, imagen);
                cs.setString(6, condiciones);
                cs.setString(7, fechaInicio);
                cs.setString(8, fechaTermino);
                cs.setString(9,"1");
                cs.setInt(10, idProducto);
                int numFilas = cs.executeUpdate();
                if (numFilas == 0) {
                    agregado = true;
                }            
        }catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }
        return agregado;
    }
    
    public int retornarUltimoIdDescuento() {
        int idProducto = 0;
        String sql = "select id from oferta where rownum <= 1 order by id desc";
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
    
    public ArrayList<DescuentoDao> listarDescuentoProductoEmpresa() {

        ArrayList listaOfertaProductoEmpresa = new ArrayList();

        String sql = "select a.id, a.nombre, a.descripcion, a.descuento, a.imagen, a.condiciones, a.fechainicio, a.fechatermino, s.nombre ,d.nombre , s.precio from oferta a inner join producto s on(a.producto_id = s.id)left join empresa d on(d.id = s.idempresa) order by a.id asc"; 

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                int descuento = rs.getInt(4);
                String imagen = rs.getString(5);
                String condiciones = rs.getString(6);
                String fechainicio = rs.getString(7);
                String fechatermino = rs.getString(8);
                String producto = rs.getString(9);
                String empresa = rs.getString(10);
                int precio = rs.getInt(11);

                Descuento ofertaProductoEmpresa = new Descuento(id, nombre, descripcion, descuento, imagen, condiciones, fechainicio, fechatermino, producto, empresa, precio);
                listaOfertaProductoEmpresa.add(ofertaProductoEmpresa);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaOfertaProductoEmpresa;
    }
    
    public ArrayList<DescuentoDao> listarPorFiltroNombreOfertaUProducto(String textoFiltro) {

        ArrayList listaOfertaProductoEmpresa = new ArrayList();

        String sql = "select a.id, a.nombre, a.descripcion, a.descuento, a.imagen, a.condiciones, a.fechainicio, a.fechatermino, s.nombre ,d.nombre , s.precio ";
               sql+= " from oferta a inner join producto s ";
               sql+= " on(a.producto_id = s.id)left join empresa d on(d.id = s.idempresa) ";
               sql+= " where UPPER(a.nombre) like '%'||?||'%' or UPPER(s.nombre) like '%'||?||'%' ";
               sql+= " order by s.precio asc";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, textoFiltro);
            ps.setString(2, textoFiltro);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                int descuento = rs.getInt(4);
                String imagen = rs.getString(5);
                String condiciones = rs.getString(6);
                String fechainicio = rs.getString(7);
                String fechatermino = rs.getString(8);
                String producto = rs.getString(9);
                String empresa = rs.getString(10);
                int precio = rs.getInt(11);

                Descuento ofertaProductoEmpresa = new Descuento(id, nombre, descripcion, descuento, imagen, condiciones, fechainicio, fechatermino, producto, empresa, precio);
                listaOfertaProductoEmpresa.add(ofertaProductoEmpresa);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaOfertaProductoEmpresa;
    }
    
    
    public boolean borrarDescuentoPorID(int idOferta) {
        boolean borrado = false;
        String sql = "CALL PKG_OFERTA.pcd_borrar_oferta(?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);

            cs.setInt(1, idOferta);

            cs.executeUpdate();
            if (comprobarSiExisteDescuentoID(idOferta)) {
                borrado = false;
            } else {
                borrado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return borrado;
    }
    
        public boolean comprobarSiExisteDescuentoID(int idOferta) {
        boolean existe = false;
        String sql = "select id from oferta where id = ?"; 
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, idOferta);
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
        
    public boolean actualizarDescuento(int idOferta, String nombre, String descripcion, int descuento, String imagen, String condiciones, String fechainicio, String fechatermino,String activo, int idProducto) {
        boolean actualizado = false;
        String sql = "CALL PKG_OFERTA.pcd_update_oferta(?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, idOferta);
            cs.setString(2, nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, descuento);
            cs.setString(5, imagen);
            cs.setString(6, condiciones);
            cs.setString(7, fechainicio);
            cs.setString(8, fechatermino);
            cs.setString(9, activo);
            cs.setInt(10, idProducto);

            cs.executeUpdate();
            if (comprobarSiExisteDescuentoID(idOferta)) {
                actualizado = true;
            } else {
                actualizado = false;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return actualizado;
    }

}
