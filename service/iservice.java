/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author User
 */
public interface iservice<C> {
     void ajouter(C c);
    void modifier(C c);
    void supprimer(int id);
    List<C> recuperer();
    C recuperer(int id);
    
}
