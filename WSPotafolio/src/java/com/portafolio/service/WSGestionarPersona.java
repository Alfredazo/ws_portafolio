/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.PersonaDao;
import java.sql.Date;
import java.text.ParseException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarPersona")
public class WSGestionarPersona {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "ingresarPersona")
    public boolean ingresarPersona(@WebParam(name = "rut") String rut, @WebParam(name = "primerNombre") String primerNombre,
            @WebParam(name = "segundoNombre") String segundoNombre, @WebParam(name = "primerApellido") String primerApellido,
            @WebParam(name = "segundoApellido") String segundoApellido, @WebParam(name = "fechaNacimiento") String fechaNacimiento,
            @WebParam(name = "direccion") String direccion, @WebParam(name = "telefono") int telefono,
            @WebParam(name = "idUsuario") int idUsuario){
        boolean agregado = false;
        PersonaDao persona = new PersonaDao();
        agregado = persona.registrarPersona(rut, primerNombre, segundoNombre, primerApellido, segundoApellido, fechaNacimiento, direccion, telefono, idUsuario);
        return agregado;
    }
    
    @WebMethod(operationName = "eliminarPersona")
    public boolean eliminarPersona(@WebParam(name = "idUsuario") int idUsuario){
        boolean agregado = false;
        PersonaDao persona = new PersonaDao();
        agregado = persona.eliminarUsuario(idUsuario);
        return agregado;
    }

}
