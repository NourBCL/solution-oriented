/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.CommandeE;
import java.sql.Connection;
import java.util.Date;
import Utils.MyBD;

/**
 *
 * @author omaro
 */
public class CommandeEService implements iserviceE<CommandeE>{
    Connection cnx ;

    public CommandeEService() {
        cnx = MyBD.getInstance().getConnection();
    }    @Override

    public void ajouter(CommandeE t) {
        try {
            String req = "insert into commande_e(date_creation,address_destination) Values(?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(2, t.getAddress_destination());
            st.setDate(1, (java.sql.Date) (Date) t.getDate_creation());
          
            st.executeUpdate();
            System.out.println("commande ajouté");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
    }
    @Override

    public void modifier(CommandeE t) {

String req = "update commande_e set date_commande =? ,adresse_destination =? where id = ? ";
        try {
            PreparedStatement ps =cnx.prepareStatement(req);
            ps.setString(2, t.getAddress_destination());
            ps.setDate(1, (java.sql.Date) t.getDate_creation());
      

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
            Connection cnx = MyBD.getInstance().getConnection();
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
             String req = "select * from commande_e ";

            Statement st = cnx.createStatement();
            ResultSet rs =  st.executeQuery(req);
            while (rs.next()){
         CommandeE p = new CommandeE(rs.getInt("id"), rs.getDate("date_creation"),rs.getString("address_destination"));
           
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
public CommandeE GetById(int id) throws SQLException {
        return recuperer().stream().filter(e -> e.getId()== id).findFirst().get();
    }
}
