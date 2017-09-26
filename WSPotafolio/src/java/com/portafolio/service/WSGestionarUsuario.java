/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.PersonaUsuarioDao;
import com.portafolio.controller.UsuarioDao;
import com.portafolio.modelos.PersonaUsuario;
import com.portafolio.modelos.Usuario;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarUsuario")
public class WSGestionarUsuario {

    @WebMethod(operationName = "ingresarUsuario")
    public boolean ingresarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "claveUsuario") String claveUsuario,
            @WebParam(name = "emailUsuario") String emailUsuario, @WebParam(name = "puntosAcumulados") int puntosAcumulados,
            @WebParam(name = "nivelUsuario") int nivelUsuario, @WebParam(name = "urlImagenUsuario") String urlImagenUsuario) {
        boolean agregado = false;
        UsuarioDao usuariox = new UsuarioDao();
        agregado = usuariox.registrarUsuario(nombreUsuario, claveUsuario, emailUsuario, puntosAcumulados, nivelUsuario, urlImagenUsuario);
        return agregado;
    }

    @WebMethod(operationName = "modificarUsuario")
    public boolean modificarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "claveUsuario") String claveUsuario,
            @WebParam(name = "emailUsuario") String emailUsuario, @WebParam(name = "puntosAcumulados") int puntosAcumulados,
            @WebParam(name = "nivelUsuario") int nivelUsuario, @WebParam(name = "urlImagenUsuario") String urlImagenUsuario) {
        boolean modificado = false;
        UsuarioDao usuariox = new UsuarioDao();
        modificado = usuariox.modificarUsuario(nombreUsuario, claveUsuario, emailUsuario, puntosAcumulados, nivelUsuario, urlImagenUsuario);
        return modificado;
    }

    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario) {
        boolean eliminado = false;
        UsuarioDao usuariox = new UsuarioDao();
        eliminado = usuariox.eliminarUsuario(nombreUsuario);
        return eliminado;
    }

    @WebMethod(operationName = "comprobarNombreUsuario")
    public boolean comprobarNombreUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario) {
        boolean existe = false;
        UsuarioDao usuariox = new UsuarioDao();
        existe = usuariox.comprobarNombreUsuario(nombreUsuario);
        return existe;
    }

    @WebMethod(operationName = "comprobarsiExisteEmail")
    public boolean comprobarsiExisteEmail(@WebParam(name = "emailUsuario") String emailUsuario) {
        boolean existe = false;
        UsuarioDao usuariox = new UsuarioDao();
        existe = usuariox.comprobarsiExisteEmail(emailUsuario);
        return existe;
    }

    @WebMethod(operationName = "listarUsuarios")
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList listaUsuarios = new ArrayList();
        UsuarioDao usuariox = new UsuarioDao();
        listaUsuarios = usuariox.listarUsuarios();
        return listaUsuarios;
    }

    @WebMethod(operationName = "listarUsuariosPorNivel")
    public ArrayList<Usuario> listarUsuariosPorNivel(@WebParam(name = "nivelUsuario") int nivelUsuario) {
        ArrayList listaUsuarios = new ArrayList();
        UsuarioDao usuariox = new UsuarioDao();
        listaUsuarios = usuariox.listarUsuariosPorNivel(nivelUsuario);
        return listaUsuarios;
    }

    @WebMethod(operationName = "listarUsuariosPorNivel")
    public ArrayList<Usuario> listarUsuariosPorRangoDePuntos(@WebParam(name = "rangoInicial") int rangoInicial, @WebParam(name = "rangoFinal") int rangoFinal) {
        ArrayList listaUsuarios = new ArrayList();
        UsuarioDao usuariox = new UsuarioDao();
        listaUsuarios = usuariox.listarUsuariosPorRangoDePuntos(rangoInicial, rangoFinal);
        return listaUsuarios;
    }

    @WebMethod(operationName = "validarUsuarioPorNombreUsuarioUCorreo")
    public boolean validarUsuarioPorNombreUsuarioUCorreo(@WebParam(name = "usuarioUCorreo") String usuarioUCorreo, @WebParam(name = "claveUsuario") String claveUsuario) {
        boolean validado = false;
        UsuarioDao usuariox = new UsuarioDao();
        validado = usuariox.validarUsuarioPorNombreUsuarioUCorreo(usuarioUCorreo, claveUsuario);
        return validado;
    }

    @WebMethod(operationName = "listarInformacionCompletaTodosLosUsuarios")
    public ArrayList<PersonaUsuario> listarInformacionCompletaTodosLosUsuarios() {
        ArrayList listaUsuarios = new ArrayList();
        PersonaUsuarioDao personaUsuario = new PersonaUsuarioDao();
        listaUsuarios = personaUsuario.listarInformacionCompletaTodosLosUsuarios();
        return listaUsuarios;
    }

    @WebMethod(operationName = "listarInformacionCompletaDelUsuariosPorUsuarioClave")
    public ArrayList<PersonaUsuario> listarInformacionCompletaDelUsuariosPorUsuarioClave(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "claveUsuario") String claveUsuario) {
        ArrayList listaUsuarios = new ArrayList();
        PersonaUsuarioDao personaUsuario = new PersonaUsuarioDao();
        listaUsuarios = personaUsuario.listarInformacionCompletaDelUsuariosPorUsuarioClave(nombreUsuario, claveUsuario);
        return listaUsuarios;
    }

    @WebMethod(operationName = "listarInformacionCompletaDelUsuariosPorCorreoClave")
    public ArrayList<PersonaUsuario> listarInformacionCompletaDelUsuariosPorCorreoClave(@WebParam(name = "correoUsuario") String correoUsuario, @WebParam(name = "claveUsuario") String claveUsuario) {
        ArrayList listaUsuarios = new ArrayList();
        PersonaUsuarioDao personaUsuario = new PersonaUsuarioDao();
        listaUsuarios = personaUsuario.listarInformacionCompletaDelUsuariosPorCorreoClave(correoUsuario, claveUsuario);
        return listaUsuarios;
    }

}
