/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author User
 */
public class evenement {
    private int id;
    private String nom;
    private Date dateDeb;
    private Date dateFin;
    private String image;
    private String description;
    private float prix;
    private Integer categoryId;
    private int count;

    //private String categorie;

    public evenement() {
    }

      public evenement(int id, Integer categoryId,String nom, int count) {
        this.id = id;
        this.categoryId = categoryId;
        this.nom = nom;
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public evenement(int id, String nom, Date dateDeb, Date dateFin, String image, String description, float prix) {
        this.id = id;
        this.nom = nom;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.image = image;
        this.description = description;
        this.prix = prix;
        //this.categorie = categorie;
    }

    public evenement(String nom, Date dateDeb, Date dateFin, String image, String description, float prix, String categorie) {
        this.nom = nom;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.image = image;
        this.description = description;
        this.prix = prix;
        //this.categorie = categorie;
    }

    public int getId() {
        return id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

//    public String getCategorie() {
//        return categorie;
//    }

//    public void setCategorie(String categorie) {
//        this.categorie = categorie;
//    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", nom=" + nom + ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + ", image=" + image + ", description=" + description + ", prix=" + prix +  '}';
    }
    
  
}
