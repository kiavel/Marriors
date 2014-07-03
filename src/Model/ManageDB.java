/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;


/**
 *
 * @author loren_000
 */
public class ManageDB {

    public static Connection conn;
    public static Statement state;

    public static Connection manageDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://localhost";
            String user = "root";
            String passwd = "";

            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion ok !");
            
            state = conn.createStatement();
            state.executeQuery("USE ici;");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ManageDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ManageDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }


}
