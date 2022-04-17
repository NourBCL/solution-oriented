/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.region;
import entities.restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import tools.MaConnexion;

/**
 *
 * @author MOLKA
 */
public class regionService {
    
     Connection cnx;
    public regionService() {
        cnx=MaConnexion.getInstance().getCnx();
    }
    
    
    public int ajouterregion(region l){
        int added = 0;
        String sql="insert into region(id,nomregion,image) values(?,?,?)";
        
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
             //id,id_reg,nom,num,hor1,hor2,image
            ste.setInt(1,l.getId());
            ste.setString(2,l.getNomregion());
            ste.setString(3,l.getImage());
            
            
            ste.executeUpdate();
            
            
            System.out.println("Region Ajoutée");
            added=1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if(added==1){
            return 1;
        }else return 0;
        
    }
    
    
    
    
    
    
    public ArrayList<region> afficherregions(){
        ArrayList<region> regions = new ArrayList<>();
        String query;
        query = "select * from region";
        
        
        try {
            PreparedStatement ste;
            ste = cnx.prepareStatement(query);
            ResultSet rs;
            rs = ste.executeQuery();
           
            //rs.next();
            while(rs.next()){
                 
                //id,id_reg,nom,num,hor1,hor2,image
                region h = new region();
                
                h.setId(rs.getInt("id"));
                h.setNomregion(rs.getString("nomregion"));
                
                h.setImage(rs.getString("image"));
                
                
                
                
                
                
                regions.add(h);
                //rs.next();
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return regions;
        
    }
    
    
    
    
    
    
    public boolean updaterregion(region m,int a){
       Statement st = null;
            
       String q1="UPDATE `region` SET `nomregion`=?,`image`=? WHERE id="+a+"";
        
        try {
            PreparedStatement ste= cnx.prepareStatement(q1);
           
            
            
            ste.setString(1,m.getNomregion());
            ste.setString(2,m.getImage());
            ste.executeUpdate();
                        
                        

            
            
            System.out.println("region modifier");
            
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
    
    
    
     public boolean deleteregion(region m){
        
        Statement st = null;
        String query="DELETE region,restaurant FROM region INNER JOIN restaurant ON region.id = restaurant.id_region_id WHERE region.id ="+m.getId()+"";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            
            ste.executeUpdate();
            
            System.out.println("region deleted");
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
