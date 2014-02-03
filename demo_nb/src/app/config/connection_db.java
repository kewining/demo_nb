/*
 * archivo conexion a mysql connection_db
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kewining
 */
public class connection_db {
    public static Connection getConnection() {
        
        Connection cn = null;
        try {
            Class.forName(database.driver);
            String url = database.server+database.data_base;
            String user = database.user;
            String password = database.password;
            cn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error no se puede cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error no se establecer la conexion: " + e.getMessage());
        }
        
//        if(cn!=null)
//        {
//            System.out.println("Conexion exitosa!");
//        }
//        else
//        {
//            System.out.println("Conexion fallida!");
//        }
        
        return cn;
    }
//    public static void main(String args[])
//    {
//        getConnection();
//    }
}