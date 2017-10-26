/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.service;

import com.portafolio.controller.AnuncioDao;
import com.portafolio.controller.DescuentoDao;
import com.portafolio.controller.EmpresaDao;
import com.portafolio.controller.ProductoEmpresaDao;
import com.portafolio.controller.PersonaDao;
import com.portafolio.controller.PersonaUsuarioDao;
import com.portafolio.controller.ProductoDao;
import com.portafolio.controller.TipoProductoDao;
import com.portafolio.controller.UsuarioDao;
import com.portafolio.modelos.Conexion;
import com.portafolio.modelos.TipoProducto;
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

//        ProductoEmpresaDao productoEmpresa = new ProductoEmpresaDao();
//        System.out.println(productoEmpresa.listarProductoEmpresa());
        /* EmpresaDao empresa = new EmpresaDao();
        System.out.println(empresa.listarUsuarios());
        PersonaUsuarioDao personauser = new PersonaUsuarioDao();
        PersonaDao persona = new PersonaDao();
        TipoProductoDao tipo= new TipoProductoDao();
        ProductoDao producto = new ProductoDao();
        System.out.println(tipo.listarTipoProducto());
        System.out.println("productos:" + producto.listarProducto());
        System.out.println("listar personas : "+personauser.listarInformacionCompletaTodosLosUsuarios());*/
//              
//        UsuarioDao prueba = new UsuarioDao();
//        
//        System.out.println(prueba.registrarUsuario("test", "test1"));
//        System.out.println(prueba.listarUsuarios());
        //Testeo a prueba viendo el valor que retorna
//        PersonaDao persona = new PersonaDao();
//        UsuarioDao usuario = new UsuarioDao();
//        /*Fecha*/
//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        String fecha = "17/06/2017";
//        java.util.Date fechaParseada = formato.parse(fecha);
//        java.sql.Date fechaLista = new java.sql.Date(fechaParseada.getTime());
////        int idUsuario = usuario.retornarUltimoIdPersonaAgregadaUsuario();
//        System.out.println("Usuario: "+usuario.registrarUsuario("OTROusuario", "123TESTING", "testing@testing.cl", 0, 0, "N/A"));
//        System.out.println("Ultimo Registro BD: " + usuario.retornarUltimoIdPersonaAgregadaUsuario());
////
//        System.out.println("PERSONA: "+persona.registrarPersona("123-4", "Prueba2", "Prueba", "ApellidoPrueba", "Apellido2Prueba", "17/06/2017", "Testing", 1234567, 16) );
//
////        //Testing para rescatar el ultimo usuario agregado a la BD
////        System.out.println("Ultimo Registro BD: " + usuario.retornarUltimoIdPersonaAgregadaUsuario());
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
//            //Testing Validar Autentificación Usuario por correo 
//            String variable = "jaredaguilera@gmail.com";
//            String variable2 = "jar.aguilera";
//            String variable3 = "contr";
//            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable, variable3));
//            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable2, variable3));
//            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable, "asdasdasdasd"));
//            System.out.println("Autentificación: "+usuario.validarUsuarioPorNombreUsuarioUCorreo(variable2, "asdasdasdasd"));
        //Testing PersonaUsuarioDao Rescate de información
//             PersonaUsuarioDao personaUsuario = new PersonaUsuarioDao();
//             System.out.println("Listado Completo de Todas las Personas "+personaUsuario.listarInformacionCompletaTodosLosUsuarios());
//             System.out.println("Listado Por Filtro:(Rescato de Datos Despues de Autentificar");
//             System.out.println("Listado: "+ personaUsuario.listarInformacionCompletaDelUsuariosPorUsuarioClave("jar.aguilera", "contr"));
////           //Testing devolver idUsuario
//                UsuarioDao user = new UsuarioDao();
//                System.out.println("Nivel usuario: "+user.devolverNivelUsuario("jaredaguilera@gmail.com"));
//        EmpresaDao empresa = new EmpresaDao();
        //     System.out.println("Ultimo ID REGISTRADO:"+ empresa.retornarUltimoIdEmpresa());
//        System.out.println("Empresa Agregada = "+ empresa.registrarEmpresa("Los Meneces", "Venta Zapatos", 2, "1", "Venta", "131.21-3"));
//        System.out.println("Modificado:"+ empresa.actualizarEmpresa(14,"Los Menxs", "Act Zapatos", 2, "1", "Venta", "131.21-3"));
//        System.out.println("BORRAR: "+empresa.borrarEmpresaPorID(14)); 
        //      System.out.println("LISTADO EMPRESAS: "+ empresa.listarUsuarios());
//        /*Testeo a Lita productos por rango fechas*/
//        ProductoDao producto = new ProductoDao();
//        System.out.println("Lista Productos: "+ producto.listarProductoPorRangosFechaCaducidad("12/10/2014", "12/12/2020"));
//
//        /*Testeo anuncio HOME*/
//        AnuncioDao anuncio = new AnuncioDao();
//        System.out.println("Lista Productos HOME: "+ anuncio.mostrarAnuncioAlimentosHOME());
//        
//        /*Testeo Recomendacion Sistema*/
//        System.out.println("Recomendacion sistema: "+anuncio.listaRecomendacionSistema());
//        
//        /*Testeo Verificar Activo y update EN PRODUCTO*/
//        ProductoDao producto = new ProductoDao();
//        System.out.println("Activo: "+ producto.verificarActivoProducto(1));
//        System.out.println("Actualizar activo= "+producto.actualizarActivoProducto(1));

       /*Descuento*/
       DescuentoDao descuento = new DescuentoDao();
        System.out.println("Descuento filtrado \n"+descuento.listarPorFiltroNombreOfertaUProducto("De"));
    }

}
