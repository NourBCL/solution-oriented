/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nours
 */
public class Restaurant {

    private int id;
    private String nom;
    private int num;
    private Date horraire_ouverture;
    private Date horraire_fermeture;
    private String image;
    private Region nom_reg;
    private int rating;
    private int count;

    public Restaurant(int id, Region nom_reg, String nom, int count) {
        this.id = id;
        this.nom = nom;
        this.nom_reg = nom_reg;
        this.count = count;
    }

    public Restaurant(int id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Restaurant(String nom, int num, Date horraire_ouverture, Date horraire_fermeture, String image, Region nom_reg) {
        this.nom = nom;
        this.num = num;
        this.horraire_ouverture = horraire_ouverture;
        this.horraire_fermeture = horraire_fermeture;
        this.image = image;
        this.nom_reg = nom_reg;

    }

    public Restaurant(int id, String nom, int num, Date horraire_ouverture, Date horraire_fermeture, String image, int rating, Region nom_reg) {
        this.id = id;
        this.nom = nom;
        this.num = num;
        this.horraire_ouverture = horraire_ouverture;
        this.horraire_fermeture = horraire_fermeture;
        this.image = image;
        this.rating = rating;
        this.nom_reg = nom_reg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Restaurant() {
    }

    public int getId() {
        return id;
    }

    public SimpleStringProperty getregion() {
        return new SimpleStringProperty(String.valueOf(nom_reg));
    }

    public String getNom() {
        return nom;
    }

    public SimpleStringProperty getNom1() {
        return new SimpleStringProperty(String.valueOf(nom));
    }

    public SimpleStringProperty getHorraire_ouverture1() {
        return new SimpleStringProperty(String.valueOf(horraire_ouverture));
    }

    public SimpleStringProperty getHorraire_fermeture1() {
        return new SimpleStringProperty(String.valueOf(horraire_fermeture));
    }

    public int getNum() {
        return num;
    }

    public Date getHorraire_ouverture() {
        return horraire_ouverture;
    }

    public void setHorraire_ouverture(Date horraire_ouverture) {
        this.horraire_ouverture = horraire_ouverture;
    }

    public Date getHorraire_fermeture() {
        return horraire_fermeture;
    }

    public void setHorraire_fermeture(Date horraire_fermeture) {
        this.horraire_fermeture = horraire_fermeture;
    }

    public String getImage() {
        return image;
    }

    public Region getNom_reg() {
        return nom_reg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNom_reg(Region nom_reg) {
        this.nom_reg = nom_reg;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", nom=" + nom + ", num=" + num + ", horraire_ouverture=" + horraire_ouverture + ", horraire_fermeture=" + horraire_fermeture + ", image=" + image + ", nom_reg=" + nom_reg + '}';
    }

}
