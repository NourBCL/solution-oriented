/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class MyBD {
    private final String url = "jdbc:mysql://localhost:3306/gocamp";
    private final String username = "root";
    private final String password = "";
    private Connection connection;
    private static MyBD instance;
    
    
     private MyBD() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
     }
            
    public static MyBD getInstance(){
        if(instance == null)
            instance = new MyBD();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    }
     
//      public static MyBD getInstance(){
//        if(instance == null)
//            instance = new MyBD();
//        return instance;
//    }
//     public Connection getConnection() {
//        return connection;
//    }

