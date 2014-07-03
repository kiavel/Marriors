/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.*;
import Metier.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Frébault
 */
public class ModeleDAO extends AbstractDAO<ModeleCartouche> {

    public ModeleDAO(Connection conn) {
        super(conn);
    }
    
    
    
    
    @Override
    public void update(ModeleCartouche unMod) {
        
        Long ref = unMod.getRef();
        String couleur = unMod.getCouleur();
        String type =  unMod.getType();
        String taille = unMod.getTaille();
              
        Statement state = null;
        
        try {
            state = this.conn.createStatement();
            state.executeUpdate("Update modele set couleur = "+couleur+", type = "+type+", taille = "+taille+" where ref = "+ref+";"); 
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void insert(ModeleCartouche unMod) {
        
        Long ref = unMod.getRef();
        String couleur = unMod.getCouleur();
        String type =  unMod.getType();
        String taille = unMod.getTaille();
        Integer nbPages = unMod.getNbPages();
        Double prix = unMod.getPrix();
                
        
        try {
            Statement state = this.conn.createStatement();            
            state.executeUpdate("Insert into modele(ref,couleur,type,taille,prix,nbpages) values('"+ref+"','"+couleur+"','"+type+"','"+taille+"','"+prix+"','"+nbPages+"');"); 
            state.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }

    public void delete(ModeleCartouche unMod) {

        Statement state = null;
        Long ref = unMod.getRef();
        
        try {
            state = this.conn.createStatement();
            state.execute("Delete from modele where ref = " +ref+ ";");           
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Des cartouches possèdent encore ce modèle. Impossible de le supprimer");
        }      
    }
    
    
    
    
    
    
    
}
