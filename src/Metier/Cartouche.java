/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metier;

import java.sql.Date;

/**
 *
 * @author Nunux
 */
public class Cartouche {
 
   private  Date dateAchat;
   private  Date datePeremption;
   private  int  id;
   private  int  ref;
   
   public Cartouche (Date dateAchat, Date datePeremption, int id, int ref) {
       this.dateAchat= dateAchat;
       this.datePeremption=  datePeremption;
       this.id= id;
       this.ref= ref;
      
   }  
      public void ajouterCartouche(Cartouche modele) {
   
   }
      public void supprimerCartouche(Cartouche modele) {
       
      
   }
           
      public int nbSelonParam () {
           return 0;
}
           
      public Date getdateAchat() {
        return dateAchat;
    }       
      
      public Date setdateAchat() {
        return dateAchat;
    }  
      public Date getdatePeremption() {
        return datePeremption;
    }       
     
      public Date setdatePeremption() {
        return dateAchat;
    }       
 
      public long getid () {
        return id ;
    } 
      public long setid() {
        return id;
    }
      public long getRef() {
        return ref;
    }
      public long setRef() {
        return ref;
    }
}
    

