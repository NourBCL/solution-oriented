/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author omaro
 */
public class MyDB {
 private final String url = "jdbc:mysql://localhost:3306/gocamp";
 private final String username = "root";
 private final String password = "";
 private  Connection connection ;
private static MyDB instance;
    private  MyDB() {
        try{
 connection= (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("jawek fesfes ");
    }catch(SQLException ex)
    {System.err.println(ex.getMessage());}
}
    //single temps 
    //1consstructeur prive 
    //2/declarer une variable statique de type class 
    //3/cree une  methode getter de cette variable statique 

    public static MyDB getInstance() {
       if (instance== null )
           instance =new MyDB();
               
       return instance;
    }
   public Connection getConnection(){

       return connection;
   }
}

