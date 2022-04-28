/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gocamp_java;

import entities.categorie;
import entities.evenement;
import service.CategorieService;
import service.EvenementService;
import util.MyBD;

/**
 *
 * @author User
 */
public class Gocamp_java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         MyBD bd = MyBD.getInstance();
        System.out.println(bd);
        categorie C = new categorie(13, "nour","nouur","nouuurr");
        CategorieService cs = new CategorieService();
        //evenement E = new evenement(2, "nour", 2022-10-03, 2022-10-03, "62460101ec7b1.png", "test", 222);
        EvenementService es = new EvenementService();
        System.out.println(es.recuperer());
         //es.ajouter(E);
        //es.supprimer(3);
        //es.modifier(E);
    }
    
}
