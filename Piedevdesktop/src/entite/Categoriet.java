/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author ASUS
 */
public class Categoriet {
 private int id;
 private String type_transport;
 private String image_tranport;

    public Categoriet(int id, String type_transport, String image_tranport) {
        this.id = id;
        this.type_transport = type_transport;
        this.image_tranport = image_tranport;
    }

    public Categoriet(String type_transport, String image_tranport) {
        this.type_transport = type_transport;
        this.image_tranport = image_tranport;
    }

    public Categoriet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType_transport() {
        return type_transport;
    }

    public void setType_transport(String type_transport) {
        this.type_transport = type_transport;
    }

    public String getImage_tranport() {
        return image_tranport;
    }

    public void setImage_tranport(String image_tranport) {
        this.image_tranport = image_tranport;
    }

    @Override
    public String toString() {
        return "Categoriet{" + "id=" + id + ", type_transport=" + type_transport + ", image_tranport=" + image_tranport + '}';
    }
 
 
 
}
