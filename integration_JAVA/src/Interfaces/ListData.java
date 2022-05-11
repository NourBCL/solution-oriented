/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Entities.Region;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Services.RegionService;

/**
 *
 * @author SHS TECH
 */
public class ListData {
      private ObservableList<Region> regions=FXCollections.observableArrayList();

    public ListData() {
        
        RegionService pdao=new RegionService();
        regions=  pdao.afficher();
        System.out.println(regions);
    }
  

   
    
    public ObservableList<Region> getRegions(){
        return regions;
    }
}
