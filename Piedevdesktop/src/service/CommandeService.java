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
import entite.Commande;
import java.sql.Connection;
import java.sql.Date;
import util.MyDB;

/**
 *
 * @author omaro
 */
public class CommandeService implements IService<Commande> {

    Connection cnx;


 

    public CommandeService() {
        cnx = MyDB.getInstance().getConnection();
    
    }

    @Override
    public void ajouter(Commande t) {
        try {
            String req = "insert into commande(adresse_destination,date_commande,commmande_t_c_id,commande_m_c_id,commande_e_c_id) Values(?,?,?,?,?)";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, t.getAdresse_destination());
            st.setDate(2, (Date) t.getDate_commande());
            st.setInt(3, t.getCommmande_t_c_id());
            st.setInt(4, t.getCommande_m_c_id());
            st.setInt(5, t.getCommande_e_c_id());

            st.executeUpdate();
            System.out.println("commande ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Commande t) {

        String req = "update commande set date_commande =? ,adresse_destination =? , commande_e_c_id= ? , commande_m_c_id= ? , commmande_t_c_id= ? where id = ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setDate(1, (Date) t.getDate_commande());
            ps.setString(2, t.getAdresse_destination());
            ps.setInt(3, t.getCommande_e_c_id());
            ps.setInt(4, t.getCommande_m_c_id());
            ps.setInt(5, t.getCommmande_t_c_id());
ps.setInt(6, t.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

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
            PreparedStatement preparedStmt = cnx.prepareStatement("DELETE FROM commande WHERE ID = ? ");
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            System.out.println("commande "
                    + "+ number " + id + " has been deleted !");
//            return true;
        } catch (SQLException ex) {
            System.err.println("Ga3ga3 ma5edmetich!");
            System.out.println(ex.getMessage());
//            return false;
        }
    }

    @Override
    public List<Commande> recuperer() {
        List<Commande> pers = new ArrayList<>();
        try {
            String req = "select * from commande ";

            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Commande p = new Commande(rs.getInt("id"), rs.getString("adresse_destination"), rs.getDate("date_commande"), rs.getInt("commande_e_c_id"), rs.getInt("commande_m_c_id"), rs.getInt("commmande_t_c_id"));
//            p.setId(rs.getInt("id"));
//            p.setAdresse_destination(rs.getString("adresse_destination"));
//            p.setDate_commande(rs.getDate("date_commande"));
//            p.setCommande_e_c_id(rs.getInt("commande_e_c_id"));
//            p.setCommande_m_c_id(rs.getInt("commande_m_c_id"));
//            p.setCommmande_t_c_id(rs.getInt("commmande_t_c_id"));
                pers.add(p);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return pers;
    }

    @Override
    public Commande recuperer(int id) {
Commande e = new Commande(); try {
            String req = "SELECT * FROM commande WHERE id = ?";
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            rs.next();
        e.setAdresse_destination(rs.getString(1));
            e.setDate_commande(rs.getDate(2));
            e.setCommande_e_c_id(rs.getInt("commande_e_c_id"));
        e.setCommande_m_c_id(rs.getInt("commande_m_c_id"));
     e.setCommmande_t_c_id(rs.getInt("commmande_t_c_id"));
          
           
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return e;
    }
}
