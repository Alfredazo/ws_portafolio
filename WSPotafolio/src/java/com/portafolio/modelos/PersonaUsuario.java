package com.portafolio.modelos;

public class PersonaUsuario {
    /*Clase creada a modo de listar objetos de este tipo y realizar mas facil el recorrido y almacenamiento 
    en la web*/
    private String rut;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String usuario;
    private String email;
    private int puntosAcumulados;
    private String urlImagen;
    private int nivelUsuario;
    private int idUsuarioPersona;
    private int usuarioID;

    public PersonaUsuario() {
    }

    public PersonaUsuario(String rut, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String usuario, String email, int puntosAcumulados, String urlImagen, int nivelUsuario, int idUsuarioPersona, int usuarioID) {
        this.rut = rut;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.usuario = usuario;
        this.email = email;
        this.puntosAcumulados = puntosAcumulados;
        this.urlImagen = urlImagen;
        this.nivelUsuario = nivelUsuario;
        this.idUsuarioPersona = idUsuarioPersona;
        this.usuarioID = usuarioID;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public int getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(int nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public int getIdUsuarioPersona() {
        return idUsuarioPersona;
    }

    public void setIdUsuarioPersona(int idUsuarioPersona) {
        this.idUsuarioPersona = idUsuarioPersona;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    @Override
    public String toString() {
        return "PersonaUsuario{" + "rut=" + rut + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", usuario=" + usuario + ", email=" + email + ", puntosAcumulados=" + puntosAcumulados + ", urlImagen=" + urlImagen + ", nivelUsuario=" + nivelUsuario + ", idUsuarioPersona=" + idUsuarioPersona + ", usuarioID=" + usuarioID + '}';
    }
    
    

}
