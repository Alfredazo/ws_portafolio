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
    
    private int idUsuario;
    private String usuario;
    private String clave;
    private String email;
    private int puntosAcumulados;
    private int nivelUsuario;
    private String urlImagen;

    public Usuario() {
    }
  
    
    public Usuario(int idUsuario, String usuario, String clave, String email, int puntosAcumulados, int nivelUsuario, String urlImagen) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.email = email;
        this.puntosAcumulados = puntosAcumulados;
        this.nivelUsuario = nivelUsuario;
        this.urlImagen = urlImagen;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", clave=" + clave + ", email=" + email + ", puntosAcumulados=" + puntosAcumulados + ", nivelUsuario=" + nivelUsuario + ", urlImagen=" + urlImagen + '}';
    }

    
}
