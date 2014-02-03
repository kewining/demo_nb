/*
 * controlador user
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.config.connection_db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kewining
 */
public class user {
    public static ArrayList<app.model.user> buscar_user_nombre(String nombre) {
        return buscar("like", "name", nombre + "%");
    }
    public static ArrayList<app.model.user> buscar_user_id(String id) {
        return buscar("like", "id_user", id+ "%");
    }
    public static ArrayList<app.model.user> buscar_user_email(String em) {
        return buscar("like", "email", em + "%");
    }
    private static ArrayList<app.model.user> buscar(String comparador, String campo, String parametro) {
        return consultarSQL("select id_user,name,email,username,id_status from user where "
                + campo + " " + comparador + " '" + parametro+"'");
    }

    private static ArrayList<app.model.user> consultarSQL(String sql) {
        ArrayList<app.model.user> list = new ArrayList<app.model.user>();
        Connection con = connection_db.getConnection();
        try {
            app.model.user us;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                us = new app.model.user();
                us.setid_user(rs.getInt("id_user"));
                us.setname(rs.getString("name"));
                us.setemail(rs.getString("email"));
                us.setusername(rs.getString("username"));
                us.setid_status(rs.getInt("id_status"));
                list.add(us);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
}