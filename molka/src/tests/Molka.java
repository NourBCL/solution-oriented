package tests;

import entities.region;
import entities.restaurant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import services.regionService;
import services.restaurantService;

/**
 *
 * @author MOLKA
 */
public class Molka {

    
    public static void main(String[] args) throws ParseException {
        
        restaurantService rs=new restaurantService();
                regionService res=new regionService();

        
        String sDate1="31/12/1998";
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date date1=formatter1.parse(sDate1);
        
        //restaurant r= new restaurant(1, "brrr", 77777, date1, date1, "azer");
        restaurant r= new restaurant(3,"brrr", 77777, date1, date1, "azer");
        
        region re=new region(1, "ariana", "touzzer-6226654a39a15.png");
        //res.ajouterregion(re);
        //res.deleteregion(re);
        //rs.updaterestaurant(r);
        
        rs.ajouterrestaurant(r,43);
        //rs.deleterestaurant(r) ;
        
        
        
        System.out.println(rs.afficherrestaurants().toString());

    }
    
}
