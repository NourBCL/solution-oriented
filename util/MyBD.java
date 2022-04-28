/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class MyBD {
      private final String url = "jdbc:mysql://localhost:3306/gocamp";
    private final String username = "root";
    private final String password = "";
    private Connection connection; 
    private static MyBD instance;
    
    public MyBD() {
        try {
            connection =DriverManager.getConnection(url, username, password);
            System.out.println("connexion établie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static MyBD getInstance(){
        if (instance== null)
            instance =new MyBD();
        return instance; 
            
    }
    public Connection getConnection(){
        return connection;
    }
}
