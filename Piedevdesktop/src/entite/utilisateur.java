/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

/**
 *
 * @author Administrateur
 */
public class utilisateur {
    private int id ;
    private String email;

    public utilisateur(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public utilisateur() {
    }

    public utilisateur(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
