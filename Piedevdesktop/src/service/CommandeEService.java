/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entite.CommandeE;
import java.sql.Connection;
import util.MyDB;

/**
 *
 * @author omaro
 */
public class CommandeEService implements IService<CommandeE>{
    Connection cnx ;

    public CommandeEService(Connection cnx) {
        this.cnx = cnx;
    }
 @Override
    public void ajouter(CommandeE t) {
        try {
            String req = "insert into commande_e (adresse_destination,date_commande)"+"values('"+t.getAddress_destination()+"','"+t.getDate_creation()+"')" ;
            Statement st = cnx.createStatement() ;
            st.executeUpdate(req);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }

    @Override
    public void modifier(CommandeE t) {

String req = "update commande_e set date_commande =? ,adresse_destination =? where id = ? ";
        try {
            PreparedStatement ps =cnx.prepareStatement(req);
            ps.setString(2, t.getAddress_destination());
            ps.setString(1, t.getDate_creation());
      

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        
//executer requet jdbc 
//1/analyse
//2/optimisation
//3/compilation 
//4/execution 
    }

    @Override
    public void supprimer(int id) {
       try {
            Connection cnx = MyDB.getInstance().getConnection();
            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM commande_e WHERE ID = ? ");
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            System.out.println("commande_e "
                    + "+ number " + id + " has been deleted !");
//            return true;
        } 
       catch (SQLException ex) {
            System.err.println("Ga3ga3 ma5edmetich!");
            System.out.println(ex.getMessage());
//            return false;
        }
    }

    @Override
    public List<CommandeE> recuperer() {
       List<CommandeE> pers = new ArrayList<>();
        try {
            String req = "select * from Commande_e ";

            Statement st = cnx.createStatement();
            ResultSet rs =  st.executeQuery(req);
            while (rs.next()){
            CommandeE p =new CommandeE();
            p.setId(rs.getInt(1));
            p.setAddress_destination(rs.getString("nom"));
            p.setDate_creation(rs.getString("prenom"));
           
            pers.add(p);
            
            }
        } catch (SQLException ex) {
                       System.out.println(ex.getMessage());        }

    return pers;
            }

    @Override
    public CommandeE recuperer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
