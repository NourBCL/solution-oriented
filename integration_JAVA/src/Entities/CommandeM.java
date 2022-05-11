/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author omaro
 */
public class CommandeM {
 private int id;
      private String    date_creation;
     private String     address_destination;
       private float           total;
         private int        quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getAddress_destination() {
        return address_destination;
    }

    public void setAddress_destination(String address_destination) {
        this.address_destination = address_destination;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public CommandeM(int id, String date_creation, String address_destination, float total, int quantite) {
        this.id = id;
        this.date_creation = date_creation;
        this.address_destination = address_destination;
        this.total = total;
        this.quantite = quantite;
    }

    public CommandeM(String date_creation, String address_destination, float total, int quantite) {
        this.date_creation = date_creation;
        this.address_destination = address_destination;
        this.total = total;
        this.quantite = quantite;
    }

    public CommandeM() {
    }
}
