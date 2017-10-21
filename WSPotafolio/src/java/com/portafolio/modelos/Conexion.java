package com.portafolio.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    String usuario = "jaredaguilera";
    String password = "hkm";

    String host = "localhost"; // tambien puede ser una ip como "192.168.1.14"
    String puerto = "1521";
    String sid = "xe";

    String driver = "oracle.jdbc.driver.OracleDriver";

    String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;

    public Conexion() {
    }

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName(driver).newInstance();
            
            con = DriverManager.getConnection(ulrjdbc);
        } catch (Exception e) {
        }
        System.out.println(con);
        return con;
    }

}
