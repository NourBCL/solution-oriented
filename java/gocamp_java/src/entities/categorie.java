/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class categorie {
    private int id_cat; 
    private String nom; 
    private String desciption; 
    private String image;

    public categorie() {
    }

    public categorie(int id_cat, String nom, String image,String desciption ) {
        this.id_cat = id_cat;
        this.nom = nom;
        this.image = image;
        this.desciption = desciption;
    }

    public categorie(String nom,String image, String desciption ) {
        this.nom = nom;
        this.image = image;
        this.desciption = desciption;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
      @Override
    public String toString() {
        return "personne{" + "id=" + id_cat + ", nom=" + nom + ", desciption=" + desciption + ", image=" + image + '}';
    }
}
