/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.ProductoDao;
import com.portafolio.controller.ProductoEmpresaDao;
import com.portafolio.controller.TipoProductoDao;
import com.portafolio.modelos.Producto;
import com.portafolio.modelos.ProductoEmpresa;
import com.portafolio.modelos.TipoProducto;
import java.sql.Date;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarProducto")
public class WSGestionarProducto {


    @WebMethod(operationName = "registrarProducto")
    public boolean registrarProducto(@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "urlFoto") String urlFoto, @WebParam(name = "activo") String activo, @WebParam(name = "idEmpresa") int idEmpresa,
            @WebParam(name = "tipoProductoID") int tipoProductoID, @WebParam(name = "fechaIngreso") String fechaIngreso, @WebParam(name = "fechaCaducidad") String fechaCaducidad) {
        boolean agregado = false;
        ProductoDao producto = new ProductoDao();
        agregado = producto.registrarProducto(nombre, precio, descripcion, urlFoto, activo, idEmpresa, tipoProductoID, fechaIngreso, fechaCaducidad);
        return agregado;
    }
    
     @WebMethod(operationName = "actualizarProducto")
    public boolean actualizarProducto(@WebParam(name = "idProducto")int idProducto,@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") int precio,
            @WebParam(name = "descripcionProducto") String descripcionProducto, @WebParam(name = "urlFoto") String urlFoto,
            @WebParam(name = "activo") String activo, @WebParam(name = "idEmpresa") int idEmpresa, @WebParam(name = "tipoProductoID") int tipoProductoID, @WebParam(name = "fechaIngreso") String fechaIngreso,
            @WebParam(name = "fechaCaducidad") String fechaCaducidad) {
        boolean actualizado = false;
        ProductoDao producto = new ProductoDao();
        producto.actualizarProducto(idProducto, nombre, precio, descripcionProducto, urlFoto, activo, idEmpresa, tipoProductoID, fechaIngreso, fechaCaducidad);
        return actualizado;
    }
    
    @WebMethod(operationName = "borrarProductoPorID")
    public boolean borrarProductoPorID(@WebParam(name = "idProducto")int idProducto) {
        boolean borrar = false;
        ProductoDao producto = new ProductoDao();
        producto.borrarProductoPorID(idProducto);
        return borrar;
    }
    
    @WebMethod(operationName = "listarProducto")
    public ArrayList<Producto> listarProducto() {
        ArrayList listarProducto = new ArrayList();        
        ProductoDao producto = new ProductoDao();
        listarProducto = producto.listarProducto();
        return listarProducto;
    }
    
    @WebMethod(operationName = "listarTipoProducto")
    public ArrayList<TipoProducto> listarTipoProducto() {
        ArrayList listaTipoProducto = new ArrayList();        
        TipoProductoDao tipoProducto = new TipoProductoDao();
        listaTipoProducto = tipoProducto.listarTipoProducto();
        return listaTipoProducto;
    }
    
    @WebMethod(operationName = "listarProductoEmpresa")
    public ArrayList<ProductoEmpresa> listarProductoEmpresa() {
        ArrayList listaProductoEmpresas = new ArrayList();        
        ProductoEmpresaDao productoEmpresa = new ProductoEmpresaDao();
        listaProductoEmpresas = productoEmpresa.listarProductoEmpresa();
        return listaProductoEmpresas;
    }
}
