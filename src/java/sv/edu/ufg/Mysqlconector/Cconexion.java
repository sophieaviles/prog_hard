/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ufg.Mysqlconector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Cconexion {

    private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/dbbd";
    private static final String MYSQL_USER = "root";
    private static final String MYSQL_PASSWD = "12345";

    public static Connection conectar_ds() {
        Connection cnn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            cnn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWD);
            System.out.println("Conectado a " + MYSQL_URL);
        } catch (SQLException ex) {
            System.out.println("Error al conectarse a la base de datos: " + ex.getMessage());
        } finally {
            return cnn;
        }
    }

    public static Connection conectar() {
        Connection cnn = null;
        try {
            Context init = new InitialContext();
            Context ctx = (Context) init.lookup("java:comp/env");
            DataSource ds = null;

            ds = (DataSource) ctx.lookup("jdbc/test");

            cnn = ds.getConnection();
        } catch (Exception e) {
        }
        return cnn;
    }
}