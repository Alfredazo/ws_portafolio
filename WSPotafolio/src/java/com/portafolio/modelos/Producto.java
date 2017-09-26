
package com.portafolio.modelos;

import java.sql.Date;


public class Producto {
    
    private int idProducto;
    private String nombre;
    private int precio;
    private int descripcionProducto;
    private String urlFoto;
    private char activo;
    private int idEmpresa;
    private int tipoProductoID;
    private Date fechaIngreso;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, int precio, int descripcionProducto, String urlFoto, char activo, int idEmpresa, int tipoProductoID, Date fechaIngreso) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcionProducto = descripcionProducto;
        this.urlFoto = urlFoto;
        this.activo = activo;
        this.idEmpresa = idEmpresa;
        this.tipoProductoID = tipoProductoID;
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(int descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public char getActivo() {
        return activo;
    }

    public void setActivo(char activo) {
        this.activo = activo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getTipoProductoID() {
        return tipoProductoID;
    }

    public void setTipoProductoID(int tipoProductoID) {
        this.tipoProductoID = tipoProductoID;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", descripcionProducto=" + descripcionProducto + ", urlFoto=" + urlFoto + ", activo=" + activo + ", idEmpresa=" + idEmpresa + ", tipoProductoID=" + tipoProductoID + ", fechaIngreso=" + fechaIngreso + '}';
    }
    
    
    
}
