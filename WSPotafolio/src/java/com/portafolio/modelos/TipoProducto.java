package com.portafolio.modelos;


public class TipoProducto {
    private int idProducto;
    private String nombre;
    private String descripción;

    public TipoProducto() {
    }

    public TipoProducto(int idProducto, String nombre, String descripción) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripción = descripción;
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

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    @Override
    public String toString() {
        return "TipoProducto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", descripci\u00f3n=" + descripción + '}';
    }
    
    
}
