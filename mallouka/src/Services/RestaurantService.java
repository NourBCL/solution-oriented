/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Region;
import Entities.Restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import molka.EmailSender;
import molka.EmailTemplate;
import molka.MaConnexion;

/**
 *
 * @author nours
 */
public class RestaurantService {

    Connection cnx;
    Statement ste;
    RegionService tt = new RegionService();

    public RestaurantService() {
        cnx = MaConnexion.getinstance().getCnx();
    }

    public HashMap<String, Integer> getRatingStats() {
        List<Restaurant> list = this.afficher();
        HashMap<String, Integer> stat = new HashMap<>();
        stat.put(">3", 0);
        stat.put("=3", 0);
        stat.put("<3", 0);

        list.stream().map((res) -> res.getRating()).forEachOrdered((rating) -> {
            if (rating < 3) {
                stat.put(">3", stat.get(">3") + 1);
            } else if (rating == 3) {
                stat.put("=3", stat.get("=3") + 1);
            } else if (rating > 3) {
                stat.put("<3", stat.get("<3") + 1);
            }
        });

        return stat;
    }

    public void ajouterOrganisateur(Restaurant re) throws Exception {
        String sql = "insert into restaurant(nom_resto,num_tel,horraire_ouverture,horraire_fermeture,image,id_region_id) VALUES('" + re.getNom() + "'," + re.getNum() + ",'" + re.getHorraire_ouverture() + "','" + re.getHorraire_fermeture() + "','" + re.getImage() + "','" + re.getNom_reg().getId() + "')";
        try {
            ste = cnx.prepareStatement(sql);
            ste.executeUpdate(sql);
            System.out.println("Restaurant ajouté..");
            EmailSender.sendEmailWithAttachments("molka.elabed@esprit.tn", "Restaurant ajouté", EmailTemplate.addRestaurant(re.getNom(), re.getNom_reg().getNomregion()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    public ObservableList<Restaurant> afficher() {
        ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `restaurant`";
            RegionService tt = new RegionService();
            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Restaurant re = new Restaurant();
                re.setId(rs.getInt(1));
                re.setNom(rs.getString(3));
                re.setNum(rs.getInt(4));
                re.setHorraire_ouverture(rs.getDate(5));
                re.setHorraire_fermeture(rs.getDate(6));
                re.setImage(rs.getString(7));
                re.setRating(rs.getInt(8));
                re.setNom_reg(tt.find(rs.getInt(2)));

                restaurants.add(re);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return restaurants;

    }

    public List<Restaurant> getall() {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `restaurant`";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Restaurant re = new Restaurant();

                re.setNom(rs.getString(3));
                re.setNum(rs.getInt(4));
                re.setHorraire_ouverture(rs.getDate(5));
                re.setHorraire_fermeture(rs.getDate(6));
                re.setImage(rs.getString(7));
                re.setRating(8);
                re.setNom_reg(tt.find(rs.getInt(2)));

                restaurants.add(re);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return restaurants;

    }

    public void supprimerRestaurant(int id) {
        String sql = "delete from restaurant where id=" + id;
        try {
            ste = cnx.prepareStatement(sql);
            ste.executeUpdate(sql);
            System.out.println("Restaurant supprimé..");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<Restaurant> display() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "select * from restaurant r inner join region re on r.id_region_id = re.id";
        Statement st = null;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                restaurants.add(new Restaurant(rs.getInt("r.id"), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getInt(8), new Region(rs.getInt("re.id"), rs.getString(9), rs.getString(10))));

            }
            return restaurants;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void ModifierRestaurant(Restaurant re) {
        String sql = "update Restaurant set nom_resto='" + re.getNom() + "'," + "horraire_ouverture='" + re.getHorraire_ouverture() + "'," + "horraire_fermeture='" + re.getHorraire_fermeture() + "'," + "image='" + re.getImage() + "',id_region_id='" + re.getNom_reg().getId() + "',num_tel=" + re.getNum() + " where id=" + re.getId();
        try {
            ste = cnx.prepareStatement(sql);
            ste.executeUpdate(sql);
            System.out.println("Restaurant modifié..");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void addRating(int value, int id) {
        String sql = "update Restaurant set rating='" + value + "' where id=" + id;
        try {
            ste = cnx.prepareStatement(sql);
            ste.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public ArrayList<Restaurant> getNumberOfRestaurantsByCat() {
        ArrayList<Restaurant> prods = new ArrayList();
        try {
            String req = "SELECT id, id_region_id, nom_resto, COUNT(*) FROM restaurant GROUP BY id_region_id;";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                prods.add(new Restaurant(
                        result.getInt(1),
                        tt.find(result.getInt(2)),
                        result.getString(3),
                        result.getInt(4)
                ));
            }
        } catch (SQLException ex) {
        }
        return prods;
    }

    /*public Restaurant RecupererResto(int id) {
         Restaurant r = new Restaurant();

        try {
        Statement stm =cnx.createStatement();
        String querry ="SELECT * FROM `Restaurant` where id="+id;

        ResultSet rs= stm.executeQuery(querry);

        while(rs.next()){


            r.setId(rs.getInt(1));
            r.setNom(rs.getString(2));
            r.setNum(rs.getInt(3));
            r.setHorraire_ouverture(rs.getDate(4));
            r.setHorraire_fermeture(rs.getDate(5));
            r.setImage(rs.getString(6));
            r.setNom_reg(rs.getString(7));
        }

    } catch (SQLException ex) {
            System.out.println(ex.getMessage());

    }

         return  r;

    }*/
    public ObservableList<Restaurant> search(String text) {
        ObservableList<Restaurant> restaurants = FXCollections.observableArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "select * from restaurant r inner join region re on r.id_region_id = re.id WHERE nom_resto LIKE '%" + text + "%' OR num_tel LIKE '%" + text + "%' ";
            RegionService tt = new RegionService();
            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                restaurants.add(new Restaurant(rs.getInt("r.id"), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getDate(6), rs.getString(7), rs.getInt(8), new Region(rs.getInt("re.id"), rs.getString(9), rs.getString(10))));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return restaurants;

    }
}

