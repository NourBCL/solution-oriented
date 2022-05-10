/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;

/**
 *
 * @author omaro
 */
public class Commande {
   private int  id;
   private String  adresse_destination;
   private Date  date_commande;
        private  int    commande_e_c_id;
        private int             commande_m_c_id;
        private int              commmande_t_c_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Commande(String adresse_destination, Date date_commande, int commande_e_c_id, int commande_m_c_id, int commmande_t_c_id) {
//        this.adresse_destination = adresse_destination;
//        this.date_commande= date_commande;
//        this.commande_e_c_id = commande_e_c_id;
//        this.commande_m_c_id = commande_m_c_id;
//        this.commmande_t_c_id = commmande_t_c_id;
//    }
    

    public String getAdresse_destination() {
        return adresse_destination;
    }

    public void setAdresse_destination(String adresse_destination) {
        this.adresse_destination = adresse_destination;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public int getCommande_e_c_id() {
        return commande_e_c_id;
    }

    public void setCommande_e_c_id(int commande_e_c_id) {
        this.commande_e_c_id = commande_e_c_id;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", adresse_destination=" + adresse_destination + ", date_commande=" + date_commande + ", commande_e_c_id=" + commande_e_c_id + ", commande_m_c_id=" + commande_m_c_id + ", commmande_t_c_id=" + commmande_t_c_id + '}';
    }

    public int getCommande_m_c_id() {
        return commande_m_c_id;
    }

    public void setCommande_m_c_id(int commande_m_c_id) {
        this.commande_m_c_id = commande_m_c_id;
    }

    public int getCommmande_t_c_id() {
        return commmande_t_c_id;
    }

    public void setCommmande_t_c_id(int commmande_t_c_id) {
        this.commmande_t_c_id = commmande_t_c_id;
    }

    public Commande(String adresse_destination, Date date_commande, int commande_e_c_id, int commande_m_c_id, int commmande_t_c_id) {
        this.adresse_destination = adresse_destination;
        this.date_commande = date_commande;
        this.commande_e_c_id = commande_e_c_id;
        this.commande_m_c_id = commande_m_c_id;
        this.commmande_t_c_id = commmande_t_c_id;
    }

    public Commande(int id, String adresse_destination, Date date_commande, int commande_e_c_id, int commande_m_c_id, int commmande_t_c_id) {
        this.id = id;
        this.adresse_destination = adresse_destination;
        this.date_commande = date_commande;
        this.commande_e_c_id = commande_e_c_id;
        this.commande_m_c_id = commande_m_c_id;
        this.commmande_t_c_id = commmande_t_c_id;
    }

    public Commande() {
    }
}
