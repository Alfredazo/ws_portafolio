/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.UsuarioDao;
import com.portafolio.modelos.Conexion;

/**
 *
 * @author Alfredazo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion conex = new Conexion();
        System.out.println(conex.getConexion());
        
        UsuarioDao prueba = new UsuarioDao();
        
        prueba.registrarUsuario("asdasdasd", "juegos");
        
        
        
    }
    
}
