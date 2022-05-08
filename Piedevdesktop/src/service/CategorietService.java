/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Categoriet;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.MyDB;

/**
 *
 * @author DELL
 */
public class CategorietService /*implements iservice<Categoriet>*/ {

    Connection cnx;

    public CategorietService() {
        cnx = MyDB.getInstance().getConnection();
    }

public void ajoutercategorie_t(Categoriet e) throws SQLException {
        String req = "INSERT INTO `categorie_t` (`type_transport`,`image_transport`) "
                + "VALUES (?,?) ";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, e.getType_transport());
        ps.setString(2, e.getImage_tranport());
  
             

        ps.executeUpdate();
    }
  
  
     public List<Categoriet> AfficherAllcategorie_t() throws SQLException {

        List<Categoriet> Categoriets = new ArrayList<>();
        String req = "select * from categorie_t ";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Categoriet e = new Categoriet(
                     rst.getInt("id"),
                    rst.getString("type_transport")
                  
                    , rst.getString("image_transport"));
            Categoriets.add(e);
        }
        return Categoriets;
    }

     public void Supprimercategorie_t(Categoriet e) throws SQLException {

        String req = "DELETE FROM categorie_t WHERE id =?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
    }
        public void supp2(Categoriet m) throws SQLException {

        String req = "DELETE FROM categorie_t WHERE id ="+m.getId()+"";
     
         PreparedStatement ps = cnx.prepareStatement(req);
        ps.executeUpdate();
     
    }
     
     
     
        public void modifiercategorie_t(Categoriet e) throws SQLException, NoSuchAlgorithmException {
        String req = "UPDATE categorie_t SET "
                + " type_transport='"+e.getType_transport()+"'"
     
                + ", image_transport='"+e.getImage_tranport()+"' where id  = "+e.getId()+"";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(req);
    }
        
        
        
        
        
        
}
