
package com.portafolio.modelos;


public class Empresa {
    private int idEmpresa;
    private String nombre;
    private String descripcion;
    private int idTipoEmpresa;
    private String activo;   
    private String rol;
    private String rutEmpresa;

    public Empresa() {
    }

    public Empresa(int idEmpresa, String nombre,String descripcion,int idTipoEmpresa, String activo, String rol, String rutEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTipoEmpresa = idTipoEmpresa;
        this.activo = activo;
        this.rol = rol;
        this.rutEmpresa = rutEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(int idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

   
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nombre=" + nombre + ", idTipoEmpresa=" + idTipoEmpresa + ", activo=" + activo + ", rol=" + rol + ", rutEmpresa=" + rutEmpresa + '}';
    }

  
    
    
}
