/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entities.Restaurant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Services.RegionService;
import Services.RestaurantService;

/**
 *
 * @author SHS TECH
 */
public class ListData1 {
      private ObservableList<Restaurant> restos=FXCollections.observableArrayList();

    public ListData1() {
        
        RestaurantService pdao=new RestaurantService();
        restos=  pdao.afficher();
        System.out.println(restos);
    }
  

   
    
    public ObservableList<Restaurant> getRestos(){
        return restos;
    }
}
