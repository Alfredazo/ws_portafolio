/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.modelos;


public class AnuncioSistema {
    private int id;
    private String nombre;
    private String fechaIngreso;
    private String fechaCaducidad;
    private String diasRestantesCaducidad;
    private String activo;

    public AnuncioSistema() {
    }

    public AnuncioSistema(int id, String nombre, String fechaIngreso, String fechaCaducidad, String diasRestantesCaducidad, String activo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaCaducidad = fechaCaducidad;
        this.diasRestantesCaducidad = diasRestantesCaducidad;
        this.activo =  activo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
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

    public String getDiasRestantesCaducidad() {
        return diasRestantesCaducidad;
    }

    public void setDiasRestantesCaducidad(String diasRestantesCaducidad) {
        this.diasRestantesCaducidad = diasRestantesCaducidad;
    }

    @Override
    public String toString() {
        return "AnuncioSistema{" + "id=" + id + ", nombre=" + nombre + ", fechaIngreso=" + fechaIngreso + ", fechaCaducidad=" + fechaCaducidad + ", diasRestantesCaducidad=" + diasRestantesCaducidad + '}';
    }
    
    
    
}
