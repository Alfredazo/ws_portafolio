/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.ProductoDao;
import java.sql.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarProducto")
public class WSGestionarProducto {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "registrarProducto")
    public boolean registrarProducto(@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "urlFoto") String urlFoto, @WebParam(name = "activo") String activo, @WebParam(name = "idEmpresa") int idEmpresa,
            @WebParam(name = "tipoProductoID") int tipoProductoID, @WebParam(name = "fechaIngreso") Date fechaIngreso, @WebParam(name = "fechaCaducidad") Date fechaCaducidad) {
        boolean agregado = false;
        ProductoDao producto = new ProductoDao();
        agregado = producto.registrarProducto(nombre, precio, descripcion, urlFoto, activo, idEmpresa, tipoProductoID, fechaIngreso, fechaCaducidad);
        return agregado;
    }

}
