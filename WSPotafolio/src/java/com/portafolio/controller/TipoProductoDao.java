
package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.TipoProducto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TipoProductoDao {
    
        Conexion conexion;

    public TipoProductoDao() {
        conexion = new Conexion();
    }
    
    
    public ArrayList<TipoProducto> listarTipoProducto() {

        ArrayList listaTipoProducto = new ArrayList();

        String sql = "Select * From tipoproducto order by id";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTipoProducto = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                
                TipoProducto tipoProducto = new TipoProducto(idTipoProducto, nombre, descripcion);
                listaTipoProducto.add(tipoProducto);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaTipoProducto;
    }
}
