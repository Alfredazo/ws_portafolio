/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.modelos;

/**
 *
 * @author Alfredazo
 */
public class Anuncio {
    private String nombreProducto;
    private int precio;
    private String urlImagen;
    private String tipoProducto;

    public Anuncio() {
    }

    
    public Anuncio(String nombreProducto, int precio, String urlImagen, String tipoProducto) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.urlImagen = urlImagen;
        this.tipoProducto = tipoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "Anuncio{" + "nombreProducto=" + nombreProducto + ", precio=" + precio + ", urlImagen=" + urlImagen + ", tipoProducto=" + tipoProducto + '}';
    }
    
    
}
