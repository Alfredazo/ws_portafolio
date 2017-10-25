/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.AnuncioDao;
import com.portafolio.modelos.Anuncio;
import com.portafolio.modelos.AnuncioSistema;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarAnuncio")
public class WSGestionarAnuncio {

    @WebMethod(operationName = "mostrarAnuncioAlimentosHOME")
    public ArrayList<Anuncio> mostrarAnuncioAlimentosHOME() {
        ArrayList listaAnuncio = new ArrayList();
        AnuncioDao anuncio = new AnuncioDao();
        listaAnuncio = anuncio.mostrarAnuncioAlimentosHOME();
        return listaAnuncio;
    }

    @WebMethod(operationName = "mostrarAnuncioElectronicaHOME")
    public ArrayList<Anuncio> mostrarAnuncioElectronicaHOME() {
        ArrayList listaAnuncio = new ArrayList();
        AnuncioDao anuncio = new AnuncioDao();
        listaAnuncio = anuncio.mostrarAnuncioElectronicaHOME();
        return listaAnuncio;
    }

    @WebMethod(operationName = "mostrarAnuncioLineaBlancaHOME")
    public ArrayList<Anuncio> mostrarAnuncioLineaBlancaHOME() {
        ArrayList listaAnuncio = new ArrayList();
        AnuncioDao anuncio = new AnuncioDao();
        listaAnuncio = anuncio.mostrarAnuncioLineaBlancaHOME();
        return listaAnuncio;
    }

    @WebMethod(operationName = "mostrarAnuncioROPAHOME")
    public ArrayList<Anuncio> mostrarAnuncioROPAHOME() {
        ArrayList listaAnuncio = new ArrayList();
        AnuncioDao anuncio = new AnuncioDao();
        listaAnuncio = anuncio.mostrarAnuncioROPAHOME();
        return listaAnuncio;
    }

    @WebMethod(operationName = "listaRecomendacionSistema")
    public ArrayList<AnuncioSistema> listaRecomendacionSistema() {
        ArrayList listaAnuncioSistema = new ArrayList();
        AnuncioDao anuncio = new AnuncioDao();
        listaAnuncioSistema = anuncio.listaRecomendacionSistema();
        return listaAnuncioSistema;
    }

}
