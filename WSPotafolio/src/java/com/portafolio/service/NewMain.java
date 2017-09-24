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
        
              
        UsuarioDao prueba = new UsuarioDao();
        
//        System.out.println(prueba.registrarUsuario("pe1", "juegos"));
        System.out.println(prueba.listarUsuarios());
        
        
    }
    
}
