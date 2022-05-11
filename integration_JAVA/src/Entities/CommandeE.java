/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author omaro
 */
public class CommandeE {
    private int id;
           private Date  date_creation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    @Override
    public String toString() {
        return "CommandeE{" + "id=" + id + ", date_creation=" + date_creation + ", address_destination=" + address_destination + '}';
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public String getAddress_destination() {
        return address_destination;
    }

    public void setAddress_destination(String address_destination) {
        this.address_destination = address_destination;
    }

    public CommandeE(Date date_creation, String address_destination) {
        this.date_creation = date_creation;
        this.address_destination = address_destination;
    }

    public CommandeE() {
    }

    public CommandeE(int id, Date date_creation, String address_destination) {
        this.id = id;
        this.date_creation = date_creation;
        this.address_destination = address_destination;
    }
           private String  address_destination;
}
