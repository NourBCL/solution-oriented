/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nours
 */
public class Region {
  private int id;
      private String nomregion;
   private String image;

    public Region() {
    }

    public Region(String nomregion, String image) {
       
        this.nomregion = nomregion;
        this.image = image;
    }

    public Region(int id, String nomregion, String image) {
        this.id = id;
        this.nomregion = nomregion;
        this.image = image;
    }
    
    

    public int getId() {
        return id;
    }

    public String getNomregion() {
        return nomregion;
    }

    public String getImage() {
        return image;
    }
 public SimpleStringProperty getNomregion1() {
         return new SimpleStringProperty(String.valueOf(nomregion));
    }

    public SimpleStringProperty getImage1() {
         return new SimpleStringProperty(String.valueOf(image));
        
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return getNomregion();
    }
    
   

}