/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Transport {

   
    private int id;
    private int id_cat;
    private String lieu_depart;
    private String lieu_arrivee;
    private Date date_dep;
    private Date date_arrivee;
    private String heure_arrivee;
    private String heure_depart;
    private Date date_retour;
    private String heure_retour;
    private int nb_place;
    private int nb_bagage;
    private int prix_t;
    private int disp;

    public Transport() {
    }

    public Transport(int id, int id_cat, String lieu_depart, String lieu_arrivee, Date date_dep, Date date_arrivee, String heure_arrivee, String heure_depart, Date date_retour, String heure_retour, int nb_place, int nb_bagage, int prix_t, int disp) {
        this.id = id;
        this.id_cat = id_cat;
        this.lieu_depart = lieu_depart;
        this.lieu_arrivee = lieu_arrivee;
        this.date_dep = date_dep;
        this.date_arrivee = date_arrivee;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
        this.date_retour = date_retour;
        this.heure_retour = heure_retour;
        this.nb_place = nb_place;
        this.nb_bagage = nb_bagage;
        this.prix_t = prix_t;
        this.disp = disp;
    }

    public Transport(int id_cat, String lieu_depart, String lieu_arrivee, Date date_dep, Date date_arrivee, String heure_arrivee, String heure_depart, Date date_retour, String heure_retour, int nb_place, int nb_bagage, int prix_t, int disp) {
        this.id_cat = id_cat;
        this.lieu_depart = lieu_depart;
        this.lieu_arrivee = lieu_arrivee;
        this.date_dep = date_dep;
        this.date_arrivee = date_arrivee;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
        this.date_retour = date_retour;
        this.heure_retour = heure_retour;
        this.nb_place = nb_place;
        this.nb_bagage = nb_bagage;
        this.prix_t = prix_t;
        this.disp = disp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getLieu_depart() {
        return lieu_depart;
    }

    public void setLieu_depart(String lieu_depart) {
        this.lieu_depart = lieu_depart;
    }

    public String getLieu_arrivee() {
        return lieu_arrivee;
    }

    public void setLieu_arrivee(String lieu_arrivee) {
        this.lieu_arrivee = lieu_arrivee;
    }

    public Date getDate_dep() {
        return date_dep;
    }

    public void setDate_dep(Date date_dep) {
        this.date_dep = date_dep;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public String getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(String heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public String getHeure_retour() {
        return heure_retour;
    }

    public void setHeure_retour(String heure_retour) {
        this.heure_retour = heure_retour;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public int getNb_bagage() {
        return nb_bagage;
    }

    public void setNb_bagage(int nb_bagage) {
        this.nb_bagage = nb_bagage;
    }

    public int getPrix_t() {
        return prix_t;
    }

    public void setPrix_t(int prix_t) {
        this.prix_t = prix_t;
    }

    public int getDisp() {
        return disp;
    }

    public void setDisp(int disp) {
        this.disp = disp;
    }

   
   
   
    
    
}
