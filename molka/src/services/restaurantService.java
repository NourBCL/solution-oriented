
package services;




import entities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import tools.MaConnexion;

/**
 *
 * @author MOLKA
 */
public class restaurantService {
    
    Connection cnx;
    public restaurantService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
    
    //id,id_reg,nom,num,hor1,hor2,image
    
    public int ajouterrestaurant(restaurant l,int a){
        int added = 0;
        String sql="insert into restaurant(id,id_region_id,nom_resto,num_tel,horraire_ouverture,horraire_fermeture,image) values(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
             //id,id_reg,nom,num,hor1,hor2,image
            ste.setInt(1,l.getId());
            ste.setInt(2,a);
            ste.setString(3,l.getNom());
            ste.setInt(4,l.getNum());
            
            
            java.util.Date utilDate = l.getHorraire_ouverture();
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             ste.setDate(5, sqlDate);
             
             java.util.Date utilDate1 = l.getHorraire_fermeture();
             java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
             ste.setDate(6, sqlDate1);
             
             ste.setString(7,l.getImage());
             
            
            
            
            ste.executeUpdate();
            
            
            System.out.println("Restaurant Ajoutée");
            added=1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if(added==1){
            return 1;
        }else return 0;
        
    }
    
    
    public ArrayList<restaurant> afficherrestaurants(){
        ArrayList<restaurant> restaurants = new ArrayList<>();
        String query;
        query = "select * from restaurant";
        
        
        try {
            PreparedStatement ste;
            ste = cnx.prepareStatement(query);
            ResultSet rs;
            rs = ste.executeQuery();
           
            //rs.next();
            while(rs.next()){
                 
                //id,id_reg,nom,num,hor1,hor2,image
                restaurant h = new restaurant();
                
                h.setId(rs.getInt("id"));
                h.setId_reg(rs.getInt("id_region_id"));
                h.setNom(rs.getString("nom_resto"));
                h.setNum(rs.getInt("num_tel"));
                h.setHorraire_ouverture(rs.getDate("horraire_ouverture"));
                h.setHorraire_fermeture(rs.getDate("horraire_fermeture"));
                h.setImage(rs.getString("image"));
                
                
                
                String query1="select nomregion from region WHERE id="+rs.getInt("id_region_id")+"";
                PreparedStatement ste1;
                ste1 = cnx.prepareStatement(query1);
                ResultSet rs1;
                rs1 = ste1.executeQuery();
                if(rs1.next()){
                h.setNom_reg(rs1.getString("nomregion"));
                }
                
                
                restaurants.add(h);
                //rs.next();
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return restaurants;
        
    }
    
    
    
    
    
    
    
    
    
    
     public boolean updaterestaurant(restaurant m){
       Statement st = null;
            
       String q1="UPDATE `restaurant` SET `id_region_id`=?,`nom_resto`=?,`num_tel`=?,`horraire_ouverture`=?,`horraire_fermeture`=?,`image`=? WHERE id=?";
        
        try {
            PreparedStatement ste= cnx.prepareStatement(q1);
           
            /*cnx = MaConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            st.executeUpdate(query);*/
            
            ste.setInt(1,m.getId_reg());
            ste.setString(2,m.getNom());
            ste.setInt(3,m.getNum());
            
            java.util.Date utilDate = m.getHorraire_ouverture();
             java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             ste.setDate(4, sqlDate);
             
             java.util.Date utilDate1 = m.getHorraire_fermeture();
             java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
             ste.setDate(5, sqlDate1);
             
            
            ste.setString(6,m.getImage());
            
            ste.setInt(7,m.getId());
            
            
                        ste.executeUpdate();
                        
                        

            
            
            System.out.println("reastaurant modifier");
            
            return true;
            
           
        } catch (SQLException ex) {
            return false;
        }finally {
           
    
    if (st != null) {
        try {
            st.close();
        } catch (SQLException e) { /* Ignored */}
    }
    }
    
    }
     
     
     
     
     
     
      public boolean deleterestaurant(restaurant m){
        
        Statement st = null;
        String query="DELETE restaurant from restaurant WHERE restaurant.id ="+m.getId()+"";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ste.executeUpdate();
            System.out.println("restaurant supprimer");
            return true;
            
            
           
        } catch (SQLException ex) {
            return false;
        }finally {
    
    if (st != null) {
        try {
            st.close();
        } catch (SQLException e) { /* Ignored */}
    }
    }
        
    }
    
    
    
    
    
    
    
    
    
}
