/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metier;

import java.util.Date;

/**
 *
 * @author Nunux
 */
public class Cartouche {
 
   private  Date dateAchat;
   private  Date datePeremption;
   private  int  id;
   private  long  ref;
   
   public Cartouche (Date dateAchat, Date datePeremption, int id, long ref) {
       this.dateAchat= dateAchat;
       this.datePeremption=  datePeremption;
       this.id= id;
       this.ref= ref;
      
   }  
   
   public Cartouche (Date dateAchat, Date datePeremption, int ref) {
       this.dateAchat= dateAchat;
       this.datePeremption=  datePeremption;
       this.ref= ref;
      
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
     
      public long getRef() {
        return ref;
    }
      public long setRef() {
        return ref;
    }
}
    

