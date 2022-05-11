/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.evenement;
import Utils.MyBD;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class EvenementService implements iserviceE<evenement>{
    Connection cnx;
    public EvenementService(){
        cnx= MyBD.getInstance().getConnection();
    }

    public void ajouter(evenement e) {
        try {
            String req = "insert into evenement (nom_e ,date_deb , date_fin, image_e,description ,prix_e, category_id_id )"+ "values('"+e.getNom()+"','"+e.getDateDeb()+"','"+e.getDateFin()+"','"+e.getImage()+"','"+e.getDescription()+"', '"+e.getPrix()+"', '"+e.getCategoryId()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(evenement e) {
         try {
        String req = "update evenement set nom_e= ?, date_deb= ?, date_fin= ? ,image_e = ? , description = ? , prix_e=?  where id=?";
             PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1, e.getNom());
             ps.setDate(2,e.getDateDeb());
             ps.setDate(3,e.getDateFin());
             ps.setString(5, e.getImage());
             ps.setString(4, e.getDescription());
             ps.setFloat(6, e.getPrix());
             ps.setInt(7, e.getId());
             ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void supprimer(int id) {
        String req = "DELETE from evenement WHERE id = "+id;
        try {
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
             System.out.println("  c bon fas5naha ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
    }

    public List<evenement> recuperer() {
        List<evenement>evenement = new ArrayList<>();
        try {
        String req ="select * from evenement";
        
            Statement st = cnx .createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
                evenement e = new evenement();
                e.setId(rs.getInt(1)); 
                e.setNom(rs.getString("nom_e"));
                e.setDateDeb(rs.getDate("date_deb"));
                e.setDateFin(rs.getDate("date_fin"));
                e.setImage(rs.getString("image_e"));
                e.setDescription(rs.getString("description"));
                e.setPrix(rs.getFloat("prix_e"));
                
                
                evenement.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenement;
    }

    public evenement recuperer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public ArrayList<evenement> getNumberOfEventsByCat() {
        ArrayList<evenement> prods = new ArrayList();
        
        CategorieService tt = new CategorieService();
        try {
            String req = "SELECT id, category_id_id, nom_e, COUNT(*) FROM evenement GROUP BY category_id_id;";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                prods.add(new evenement(
                        result.getInt(1),
                        tt.find(result.getInt(2)).getId_cat(),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
            
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prods;
    }
    
}
