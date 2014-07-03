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
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author loren_000
 */
public class CartoucheDAO  extends AbstractDAO<Cartouche> {
       
    public CartoucheDAO(Connection conn) {
        super(conn);
    }


    
    
    
    @Override
    public void update(Cartouche uneCar) {
        
        Date dteA = uneCar.getdateAchat();
        Date dteP = uneCar.getdatePeremption();
        Integer id = uneCar.getId();
        Long ref = uneCar.getRef();
        
        
        Statement state = null;
        
        try {
            state = this.conn.createStatement();
            state.executeUpdate("Update cartouche set dte_achat = "+dteA+", dte_peremption = "+dteP+", fk_ref = "+ref+" where id = "+id+";"); 
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public Map<ModeleCartouche, Integer> nbCartoucheParModele() {
    
        Map<ModeleCartouche, Integer> lesCart = new HashMap();
        ModeleCartouche unMod;
        Statement state = null;
        
        try {
            state = this.conn.createStatement();
            ResultSet result = state.executeQuery("Select count(id) as nb, fk_ref from cartouche group by fk_ref ;"); 
            
            while (result.next()) {
                unMod = new ModeleCartouche(result.getLong("fk_ref"));
                lesCart.put(unMod, result.getInt("nb"));
            }
            
            
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesCart;
    }
    
    
    @Override
    public void insert(Cartouche uneCar) {
        
        Date dteA = uneCar.getdateAchat();
        Date dteP = uneCar.getdatePeremption();
        Long ref = uneCar.getRef();
        int id = uneCar.getId();
        
        try {
            Statement state = this.conn.createStatement(); 
            
            state.executeUpdate("Insert into cartouche(dte_achat, dte_peremption, fk_ref) values('"+dteA+"','"+dteP+"','"+ref+"');", Statement.RETURN_GENERATED_KEYS); 
           
            ResultSet rs = state.getGeneratedKeys();
            if (rs.next()) {
               id = rs.getInt(1);
            }else{
                System.out.println("Problème lors de l'insertion de la cartouche");
            }           
            
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        uneCar.setId(id);
        
    }

    public void delete(ModeleCartouche unMod) {

        Statement state = null;
        Long ref = unMod.getRef();
        
        try {
            state = this.conn.createStatement();
            state.execute("Delete from cartouche where date_peremption = (Select min(date_peremption) from cartouche where ref = " + ref + ");");           
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    public Cartouche findByRef(int ref) throws Exception {
        Cartouche cart = null;
        String query = "";
        
        try {
            Statement state = this.conn.createStatement();
            query = "SELECT date_achat, date_peremption, fk_ref, id "
                    + "FROM cartouche "
                    + "WHERE date_peremption ="
                    + "(SELECT MIN(date_peremption) from cartouche "
                    + "WHERE fk_ref = " + ref +");";
            ResultSet result = state.executeQuery(query);
            cart = new Cartouche(result.getDate("date_achat"),
            result.getDate("date_peremption"),
                    result.getInt("id"),
            ref);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return cart;
    }
    
}
