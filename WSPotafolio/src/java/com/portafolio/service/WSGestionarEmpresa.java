/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.EmpresaDao;
import com.portafolio.modelos.Empresa;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarEmpresa")
public class WSGestionarEmpresa {

  @WebMethod(operationName = "ingresarEmpresa")
    public boolean ingresarEmpresa(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "idTipoEmpresa") int idTipoEmpresa, @WebParam(name = "activo") String activo,
            @WebParam(name = "rol") String rol, @WebParam(name = "rutEmpresa") String rutEmpresa) {
        boolean agregado = false;
        EmpresaDao empresa = new EmpresaDao();
        empresa.registrarEmpresa(nombre, descripcion, idTipoEmpresa, activo, rol, rutEmpresa);
        return agregado;
    }
    
    @WebMethod(operationName = "actualizarEmpresa")
    public boolean actualizarEmpresa(@WebParam(name = "idEmpresa")int idEmpresa,@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion,
            @WebParam(name = "idTipoEmpresa") int idTipoEmpresa, @WebParam(name = "activo") String activo,
            @WebParam(name = "rol") String rol, @WebParam(name = "rutEmpresa") String rutEmpresa) {
        boolean agregado = false;
        EmpresaDao empresa = new EmpresaDao();
        empresa.actualizarEmpresa(idEmpresa, nombre, descripcion, idTipoEmpresa, activo, rol, rutEmpresa);
        return agregado;
    }
    
    @WebMethod(operationName = "borrarEmpresa")
    public boolean borrarEmpresa(@WebParam(name = "idEmpresa")int idEmpresa) {
        boolean borrar = false;
        EmpresaDao empresa = new EmpresaDao();
        empresa.borrarEmpresaPorID(idEmpresa);
        return borrar;
    }
    
    @WebMethod(operationName = "listarEmpresas")
    public ArrayList<Empresa> listarEmpresas() {
        ArrayList listaEmpresas = new ArrayList();        
        EmpresaDao empresa = new EmpresaDao();
        listaEmpresas = empresa.listarUsuarios();
        return listaEmpresas;
    }
    
}

