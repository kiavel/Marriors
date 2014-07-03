/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.sql.Date;

/**
 *
 * @author Nunux
 */
public class Cartouche {
 
    
   private  Date dateAchat;
   private  Date datePeremption;
   private  int id;
   
   public Cartouche (Date dateAchat, Date datePeremption, int id) {
       this.dateAchat= dateAchat;
       this.datePeremption=  datePeremption;
       this.id= id;
      
   }  
   public void ajouterCartouche(Cartouche modele) {
   
   }
   public void supprimerCartouche(Cartouche modele) {
       
      
   }
           
   public int nbSelonParam () {
           return 0;
}
           
           
           
   
}
