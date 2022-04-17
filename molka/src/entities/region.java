 
package entities;

/**
 *
 * @author MOLKA
 */
public class region {
    
    private int id;
      private String nomregion;
   private String image;

    public region() {
    }

    public region(int id, String nomregion, String image) {
        this.id = id;
        this.nomregion = nomregion;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomregion() {
        return nomregion;
    }

    public void setNomregion(String nomregion) {
        this.nomregion = nomregion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "region{" + "nomregion=" + nomregion + ", image=" + image + '}';
    }
   
   
 
    
}
