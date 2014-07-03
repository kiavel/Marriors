/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Metier.Cartouche;
import Metier.ModeleCartouche;
import Model.CartoucheDAO;
import java.sql.Connection;
/**
 *
 * @author Nunux
 */
public class ManageCartouche {
    
    
    private Cartouche cartouche;  
    private Connection conn;

    public ManageCartouche(Cartouche cart, Connection conn) {
        this.cartouche = cart;
        this.conn = conn;
    }

    public void ajouterCartouche() {
        CartoucheDAO cart = new CartoucheDAO(conn);
        cart.insert(this.cartouche);
    }

    public void supprimerCartouche() {
        CartoucheDAO cart = new CartoucheDAO(conn);
        
        Cartouche uneCart = cart.findByRef(this.cartouche.getRef());
        
        cart.delete(uneCart);
    }

    public int nbSelonParam () {
           return 0;
}
}