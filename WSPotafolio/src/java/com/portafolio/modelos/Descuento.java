
package com.portafolio.modelos;

public class Descuento {
    
   private int id;
   private String nombre;
   private String descripcion;
   private int descuento;
   private String imagen;
   private String condiciones;
   private String fechainicio;
   private String fechatermino;
   private String producto;
   private String empresa;
   private int precio;

    public Descuento() {
    }

    public Descuento(int id, String nombre, String descripcion, int descuento, String imagen, String condiciones, String fechainicio, String fechatermino, String producto, String empresa, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.imagen = imagen;
        this.condiciones = condiciones;
        this.fechainicio = fechainicio;
        this.fechatermino = fechatermino;
        this.producto = producto;
        this.empresa = empresa;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechatermino() {
        return fechatermino;
    }

    public void setFechatermino(String fechatermino) {
        this.fechatermino = fechatermino;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", descuento=" + descuento + ", imagen=" + imagen + ", condiciones=" + condiciones + ", fechainicio=" + fechainicio + ", fechatermino=" + fechatermino + ", producto=" + producto + ", empresa=" + empresa + ", precio=" + precio + '}';
    }

    
}