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
public class Usuario {
    
    private int id;
    private String nombre;
    private String password;
    private String email;
    private int puntosAcumulados;
    private int nivelUsuario;
    private int id1;
    
    public Usuario() {        
    }

    public Usuario(String nombre, String password, String email, int puntosAcumulados, int nivelUsuario) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.puntosAcumulados = puntosAcumulados;
        this.nivelUsuario = nivelUsuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(int nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    
    
    
    
}
