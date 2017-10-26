/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.DescuentoDao;
import com.portafolio.modelos.Descuento;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarDescuento")
public class WSGestionarDescuento {

      @WebMethod(operationName = "registrarDescuento")
    public boolean registrarDescuento(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "descuento") int descuento,
            @WebParam(name = "imagen") String imagen, @WebParam(name = "condiciones") String condiciones, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaTermino") String fechaTermino, @WebParam(name = "idProducto") int idProducto) {
        boolean agregado = false;
        DescuentoDao oferta = new DescuentoDao();
        agregado = oferta.registrarDescuento(nombre, descripcion, descuento, imagen, condiciones, fechaInicio, fechaTermino, idProducto);
        return agregado;
    }
    
     @WebMethod(operationName = "actualizarDescuento")
    public boolean actualizarDescuento(@WebParam(name = "id") int id,@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "descuento") int descuento,
            @WebParam(name = "imagen") String imagen, @WebParam(name = "condiciones") String condiciones, @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaTermino") String fechaTermino,@WebParam(name = "activo") String activo, @WebParam(name = "idProducto") int idProducto) {
        boolean actualizado = false;
        DescuentoDao oferta = new DescuentoDao();
        oferta.actualizarDescuento(id, nombre, descripcion, descuento, imagen, condiciones, fechaInicio, fechaTermino,activo,idProducto);
        return actualizado;
    }
    
    @WebMethod(operationName = "borrarDescuentoPorID")
    public boolean borrarDescuentoPorID(@WebParam(name = "idOferta")int idOferta) {
        boolean borrar = false;
        DescuentoDao oferta = new DescuentoDao();
        oferta.borrarDescuentoPorID(idOferta);
        return borrar;
    }
    
    @WebMethod(operationName = "listarDescuentoProductoEmpresa")
    public ArrayList<Descuento> listarDescuentoProductoEmpresa() {
        ArrayList listaOfertaProductoEmpresa = new ArrayList();        
        DescuentoDao oferta = new DescuentoDao();
        listaOfertaProductoEmpresa = oferta.listarDescuentoProductoEmpresa();
        return listaOfertaProductoEmpresa;
    }
    
    @WebMethod(operationName = "listarPorFiltroNombreOfertaUProducto")
    public ArrayList<Descuento> listarPorFiltroNombreOfertaUProducto(@WebParam(name = "textoFiltrado")String textoFiltrado) {
        ArrayList listaOfertaProductoEmpresa = new ArrayList();        
        DescuentoDao oferta = new DescuentoDao();
        listaOfertaProductoEmpresa = oferta.listarPorFiltroNombreOfertaUProducto(textoFiltrado);
        return listaOfertaProductoEmpresa;
    }
}
