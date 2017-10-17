package com.portafolio.controller;

import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.Empresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDao {

    Conexion conexion;

    public EmpresaDao() {
        conexion = new Conexion();
    }

    public boolean registrarEmpresa(String nombre, String descripcion, int idTipoEmpresa, String activo, String rol, String rutEmpresa) {
        boolean registrado = false;
        String sql = "CALL PKG_EMPRESA.pcd_insertar_empresa(?,?,?,?,?,?,?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            rutEmpresa = rutEmpresa.toUpperCase();
            rutEmpresa = rutEmpresa.replace(".", "");
            int idEmpresa = this.retornarUltimoIdEmpresa() + 1;
            cs.setInt(1, idEmpresa);
            cs.setString(2, nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, idTipoEmpresa);
            cs.setString(5, activo);
            cs.setString(6, rol);
            cs.setString(7, rutEmpresa);
            int numFilas = cs.executeUpdate();

            if (numFilas == 0) {
                registrado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return registrado;
    }

    public boolean actualizarEmpresa(int idEmpresa, String nombre, String descripcion, int idTipoEmpresa, String activo, String rol, String rutEmpresa) {
        boolean actualizado = false;
        String sql = "CALL PKG_EMPRESA.pcd_update_empresa(?,?,?,?,?,?,?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            rutEmpresa = rutEmpresa.toUpperCase();
            rutEmpresa = rutEmpresa.replace(".", "");
            cs.setInt(1, idEmpresa);
            cs.setString(2, nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, idTipoEmpresa);
            cs.setString(5, activo);
            cs.setString(6, rol);
            cs.setString(7, rutEmpresa);

            cs.executeUpdate();
            if (comprobarSiExisteEmpresaID(idEmpresa)) {
                actualizado = true;
            } else {
                actualizado = false;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return actualizado;
    }

    public boolean borrarEmpresaPorID(int idEmpresa) {
        boolean actualizado = false;
        String sql = "CALL PKG_EMPRESA.pcd_borrar_empresa(?)";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);

            cs.setInt(1, idEmpresa);

            cs.executeUpdate();
            if (comprobarSiExisteEmpresaID(idEmpresa)) {
                actualizado = false;
            } else {
                actualizado = true;
            }
        } catch (SQLException e) {
            System.out.println("Excep:" + e.getMessage());
        }

        return actualizado;
    }

    public ArrayList<Empresa> listarUsuarios() {

        ArrayList listaEmpresas = new ArrayList();

        String sql = "Select * From Empresa order by id";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idEmpresa = rs.getInt(1);
                String nombre = rs.getString(2);
                String descripcion = rs.getString(3);
                int tipoEmpresa = rs.getInt(4);
                String activo = rs.getString(5);
                String rol = rs.getString(6);
                String rutEmpresa = rs.getString(7);

                Empresa empresa = new Empresa(idEmpresa, nombre, descripcion, tipoEmpresa, activo, rol, rutEmpresa);
                listaEmpresas.add(empresa);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaEmpresas;
    }

    public int retornarUltimoIdEmpresa() {
        int idEmpresa = 0;
        String sql = "select id from empresa where rownum <= 1 order by id desc";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idEmpresa = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idEmpresa;
    }

    public boolean comprobarSiExisteEmpresaID(int id) {
        boolean existe = false;
        String sql = "select id from empresa where id = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, id);
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
