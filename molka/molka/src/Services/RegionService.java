/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Region;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import molka.MaConnexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RegionService {
    Connection cnx;
    Statement ste;
    public RegionService(){
        cnx= MaConnexion.getinstance().getCnx();
    }
    
    public void ajouterRegion(Region r){ 
        
        String sql="insert into region(nomregion,image) VALUES('"+r.getNomregion()+"','"+r.getImage()+"')";
        try {
            ste=cnx.prepareStatement(sql);
            ste.executeUpdate(sql);
            System.out.println("Region ajouté..");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
    public List<Region> display() {
        List<Region> regions = new ArrayList<>();
        String query = "select * from region";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                regions.add(new Region(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return regions;
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
    
    
    public ObservableList<Region> afficher() {
         ObservableList<Region> regions =FXCollections.observableArrayList(); 
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM `Region`";
     
        ResultSet rs= stm.executeQuery(querry);
        
        while(rs.next()){
            Region r = new Region();
            r.setId(rs.getInt(1));
            r.setNomregion(rs.getString(2));
            r.setImage(rs.getString(3));
            
            
            
            regions.add(r);
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
         return  regions;
   
    }
    public ArrayList<String> afficherNom() {
         ArrayList<String> regions =new ArrayList(); 
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT nomregion FROM `Region`";
     
        ResultSet rs= stm.executeQuery(querry);
        
        while(rs.next()){
            Region r = new Region();
           
            r.setNomregion(rs.getString(1));
      
            
            
            
            regions.add(r.getNomregion());
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
         return  regions;
   
    }
    public void supprimerRegion(int id){  
        String sql="delete from region where id="+id;
        try {
            ste=cnx.prepareStatement(sql);
            ste.executeUpdate(sql);
            System.out.println("Region supprimé..");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }
     public void ModifierRegion(Region r){  
        String sql="update region set nomregion='"+r.getNomregion()+"',"+"image='"+r.getImage()+"' where id=" + r.getId();
        try {
            ste=cnx.prepareStatement(sql);
            ste.executeUpdate(sql);
            System.out.println("Region modifié..");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    
     
   
    public Region RecupererRegion(int id) {
         Region r = new Region();
    
        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM `Region` where id="+id;
     
        ResultSet rs= stm.executeQuery(querry);
        
        while(rs.next()){
           
            r.setNomregion(rs.getString(2));
            r.setImage(rs.getString(3));
            r.setId(rs.getInt(1));
            
            
        }
        
    } catch (SQLException ex) {
            System.out.println(ex.getMessage()); 
    
    }
   
         return  r;
   
    }
    
    public Region find (int id ) {
        Region r = null;
        String query = "select * from region r where r.id = "+ id +" limit 1";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                r = new Region(rs.getInt("r.id"),
                        rs.getString(2), 
                        rs.getString(3)
                );
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }


    
     
}
