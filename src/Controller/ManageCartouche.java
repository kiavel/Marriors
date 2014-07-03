/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Metier.Cartouche;
import Metier.ModeleCartouche;
import Model.CartoucheDAO;
/**
 *
 * @author Nunux
 */
public class ManageCartouche {
    CartoucheDAO mod = new CartoucheDAO();
    
    private Cartouche cartouche;    

    public ManageCartouche(Cartouche modele) {
        this.cartouche = modele;
    }

    public void ajouterModele(Cartouche modele) {
        CartoucheDAO mod = new CartoucheDAO();
        //mod.insert(modele);
        mod.insert(modele);
    }

    public void supprimerCartouche(ModeleCartouche modele) {
        mod.delete(modele);
    }

    public int nbSelonParam () {
           return 0;
}
}
