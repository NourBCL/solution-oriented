/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author omaro
 */
public class CommandeT {
    private int id ;
    private String  date_creation ;
    private String address_destination;

    public CommandeT() {
    }

    public CommandeT(String date_creation, String address_destination) {
        this.date_creation = date_creation;
        this.address_destination = address_destination;
    }

    public CommandeT(int id, String date_creation, String address_destination) {
        this.id = id;
        this.date_creation = date_creation;
        this.address_destination = address_destination;
    }

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

    @Override
    public String toString() {
        return "CommandeT{" + "id=" + id + ", date_creation=" + date_creation + ", address_destination=" + address_destination + '}';
    }
    
}
