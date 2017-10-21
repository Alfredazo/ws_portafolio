/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.modelos;

/**
 *
 * @author jared
 */
public class ProductoEmpresa {
    
    private int idProducto;
    private String nombre;
    private int precio;
    private String descripcionProducto;
    private String urlFoto;
    private String activo;
    private String empresa;
    private String tipoProducto;
    private String fechaIngreso;
    private String fechaCaducidad;

    public ProductoEmpresa() {
    }

    public ProductoEmpresa(int idProducto, String nombre, int precio, String descripcionProducto, String urlFoto, String activo, String empresa, String tipoProducto, String fechaIngreso, String fechaCaducidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcionProducto = descripcionProducto;
        this.urlFoto = urlFoto;
        this.activo = activo;
        this.empresa = empresa;
        this.tipoProducto = tipoProducto;
        this.fechaIngreso = fechaIngreso;
        this.fechaCaducidad = fechaCaducidad;
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

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "ProductoEmpresa{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + ", descripcionProducto=" + descripcionProducto + ", urlFoto=" + urlFoto + ", activo=" + activo + ", empresa=" + empresa + ", tipoProducto=" + tipoProducto + ", fechaIngreso=" + fechaIngreso + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

    
}
