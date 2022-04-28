/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MyBD;

/**
 *
 * @author User
 */
public class CategorieService implements iservice<categorie>{
    Connection cnx;
    public CategorieService(){
        cnx= MyBD.getInstance().getConnection();
    }
    
     @Override
    public void ajouter(categorie c) {
        
        try {
            String req = "insert into categorie_e (nom_cat_e , image_e ,desciption) values(?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, c.getNom());
             ps.setString(2, c.getImage());
             ps.setString(3, c.getDesciption());
             
             ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void modifier(categorie c) {
        try {
        String req = "update categorie_e set nom_cat_e= ?, image_e = ? , desciption = ? where id=?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, c.getNom());
             ps.setString(3, c.getDesciption());
             ps.setString(2, c.getImage());
             ps.setInt(4, c.getId_cat());
             ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(int id) {
      String req = "DELETE from categorie_e WHERE id = "+id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
             System.out.println("  c bon fas5naha ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }


    @Override
    public List<categorie> recuperer() {
        List<categorie>categorie = new ArrayList<>();
        try {
        String req ="select * from categorie_e";
        
            Statement st = cnx .createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                categorie c = new categorie();
                c.setId_cat(rs.getInt(1)); 
                c.setNom(rs.getString("nom_cat_e"));
                c.setImage(rs.getString("image_e"));
                c.setDesciption(rs.getString("desciption"));
                categorie.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categorie;
    }

    @Override
    public categorie recuperer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public categorie find (int id ) {
        categorie c = null;
        String query = "select * from categorie_e where id = "+ id +" limit 1";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                c = new categorie(rs.getInt("id"),
                        rs.getString(2), 
                        rs.getString(3),
                        rs.getString(4)
                );
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }

//   public List<categorie> recupererID() {
//        List<categorie> categories=new ArrayList<>();
//        String req ="select id from categorie_e";
//         try {
//            Statement st = cnx.createStatement();
//             ResultSet rs = st.executeQuery(req);
//             while(rs.next()){
//                 categorie cat = new categorie();
//                 cat.setId_cat(rs.getInt(1));
//                 categories.add(cat);  
//             }
//             
//            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//           // Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//         return categories;
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
