/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.UsuarioDao;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarUsuario")
public class WSGestionarUsuario {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ingresarUsuario")
    public boolean ingresarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario,@WebParam(name = "claveUsuario") String claveUsuario) {
        boolean agregado = false;
        UsuarioDao usuariox = new UsuarioDao();
//        agregado = usuariox.registrarUsuario(nombreUsuario, claveUsuario);
        return agregado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "usuario") long usuario, @WebParam(name = "parameter1") String parameter1) {
        //TODO write your implementation code here:
        return false;
    }
}
