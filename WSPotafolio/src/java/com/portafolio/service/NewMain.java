/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.PersonaDao;
import com.portafolio.controller.UsuarioDao;
import com.portafolio.modelos.Conexion;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alfredazo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

//              
//        UsuarioDao prueba = new UsuarioDao();
//        
//        System.out.println(prueba.registrarUsuario("test", "test1"));
//        System.out.println(prueba.listarUsuarios());
        //Testeo a prueba viendo el valor que retorna
        PersonaDao persona = new PersonaDao();
        UsuarioDao usuario = new UsuarioDao();
       
        /*Fecha*/
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = "17/06/2017";
        java.util.Date fechaParseada = formato.parse(fecha);
        java.sql.Date fechaLista = new java.sql.Date(fechaParseada.getTime());
        int idUsuario = usuario.retornarUltimoIdPersonaAgregadaUsuario();
//        System.out.println("Usuario: "+usuario.registrarUsuario("TesteoUser2", "123TESTING", "testing@testing.cl", 0, 0, "N/A"));
//        System.out.println("Ultimo Registro BD: " + usuario.retornarUltimoIdPersonaAgregadaUsuario());
//
//        System.out.println("PERSONA: "+persona.registrarPersona("123-4", "Prueba2", "Prueba", "ApellidoPrueba", "Apellido2Prueba", fechaLista, "Testing", 1234567, 16) );

        System.out.println("Ultimo Registro BD: " + usuario.retornarUltimoIdPersonaAgregadaUsuario());
        
        System.out.println("Modificado: "+usuario.modificarUsuario("pedritoaa","12345678", "pedro@aaka.com",23, 1, "N/A"));
        System.out.println("Modificado: "+usuario.modificarUsuario("pedritoaazzzzzz","12345678", "pedro@aaka.com",23, 1, "N/A"));

    }

}
