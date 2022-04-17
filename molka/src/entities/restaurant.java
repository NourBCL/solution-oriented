
package entities;

import java.util.Date;

/**
 *
 * @author GX15
 */
public class restaurant {
    
   private int id;
   private int id_reg;
   private String nom;
   private int num;
   private Date horraire_ouverture;
   private Date horraire_fermeture;
   private String image;
   private String nom_reg;

    public restaurant() {
    }

    public restaurant(int id, String nom, int num, Date horraire_ouverture, Date horraire_fermeture, String image) {
        this.id = id;
        this.nom = nom;
        this.num = num;
        this.horraire_ouverture = horraire_ouverture;
        this.horraire_fermeture = horraire_fermeture;
        this.image = image;
    }

    public restaurant(int id, int id_reg, String nom, int num, Date horraire_ouverture, Date horraire_fermeture, String image) {
        this.id = id;
        this.id_reg = id_reg;
        this.nom = nom;
        this.num = num;
        this.horraire_ouverture = horraire_ouverture;
        this.horraire_fermeture = horraire_fermeture;
        this.image = image;
    }

    public restaurant(int id, int id_reg, String nom, int num, Date horraire_ouverture, Date horraire_fermeture, String image, String nom_reg) {
        this.id = id;
        this.id_reg = id_reg;
        this.nom = nom;
        this.num = num;
        this.horraire_ouverture = horraire_ouverture;
        this.horraire_fermeture = horraire_fermeture;
        this.image = image;
        this.nom_reg = nom_reg;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public void setNom_reg(String nom_reg) {
        this.nom_reg = nom_reg;
    }
    

    public int getId_reg() {
        return id_reg;
    }

    public void setId_reg(int id_reg) {
        this.id_reg = id_reg;
    }
    

    public int getId() {
        return id;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "restaurant{" + "nom=" + nom + ", num=" + num + ", horraire_ouverture=" + horraire_ouverture + ", horraire_fermeture=" + horraire_fermeture + ", image=" + image + ", nom_reg=" + nom_reg + '}';
    }

    
   
   
   
    
}
