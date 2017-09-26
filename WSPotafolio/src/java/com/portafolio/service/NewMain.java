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
       
//        /*Fecha*/
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String fecha = "17/06/2017";
//        java.util.Date fechaParseada = formato.parse(fecha);
//        java.sql.Date fechaLista = new java.sql.Date(fechaParseada.getTime());
////        int idUsuario = usuario.retornarUltimoIdPersonaAgregadaUsuario();
//        System.out.println("Usuario: "+usuario.registrarUsuario("OTROusuario", "123TESTING", "testing@testing.cl", 0, 0, "N/A"));
//        System.out.println("Ultimo Registro BD: " + usuario.retornarUltimoIdPersonaAgregadaUsuario());
////
////        System.out.println("PERSONA: "+persona.registrarPersona("123-4", "Prueba2", "Prueba", "ApellidoPrueba", "Apellido2Prueba", fechaLista, "Testing", 1234567, 16) );
//
//        //Testing para rescatar el ultimo usuario agregado a la BD
//        System.out.println("Ultimo Registro BD: " + usuario.retornarUltimoIdPersonaAgregadaUsuario());
//        //Testing para modificar
//        System.out.println("Modificado: "+usuario.modificarUsuario("pedritoaa","12345678", "pedro@aaka.com",23, 1, "N/A"));
//        System.out.println("Modificado: "+usuario.modificarUsuario("pedritoaazzzzzz","12345678", "pedro@aaka.com",23, 1, "N/A"));
//        //TEsting para rescatar la lista de usuarios
//        System.out.println("Lista: "+usuario.listarUsuarios());
//          //Testing para eliminar usuario
//          System.out.println("METODO: " + usuario.comprobarNombreUsuario("TesteoUser2"));
//          System.out.println("Eliminado: "+usuario.eliminarUsuario("TesteoUser2"));
           //Testing listar por filtros(Niveles)
//           System.out.println("Listar por Nivel: "+ usuario.listarUsuariosPorNivel(2));
//           //Testing listar por Puntos(Rangos)
//           int rangoInicial = 100;
//           int rangoFinal = 1600;
//           System.out.println("Listar Por niveles Rango 1:" + rangoInicial + " Rango 2:"+ rangoFinal);
//           System.out.println(usuario.listarUsuariosPorRangoDePuntos(rangoInicial, rangoFinal));
            //Testing Validar Autentificación Usuario por correo 
            String variable = "jaredaguilera@gmail.com";
            String variable2 = "jar.aguilera";
            String variable3 = "contr";
            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable, variable3));
            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable2, variable3));
            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable, "asdasdasdasd"));
            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable2, "asdasdasdasd"));
            
            
                    

    }

}
