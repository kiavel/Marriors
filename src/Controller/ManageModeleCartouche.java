/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.Cartouche;
import Metier.ModeleCartouche;
import Model.CartoucheDAO;
import Model.ModeleDAO;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class ManageModeleCartouche {

    private ModeleCartouche modele;
    private Connection conn;

    public ManageModeleCartouche(ModeleCartouche modele) {
        this.modele = modele;
    }

    public void ajouterModele(ModeleCartouche modele) {
        ModeleDAO mod = new ModeleDAO(this.conn);
        mod.insert(modele);
    }

    public void supprimerModele(ModeleCartouche modele) {
        ModeleDAO mod = new ModeleDAO(this.conn);
        mod.delete(modele);
    }

    public void modifierModele(ModeleCartouche modeleUn, ModeleCartouche modeleDeux) {
        ModeleDAO mod = new ModeleDAO(this.conn);
        mod.delete(modele);
    }

    public Map<ModeleCartouche, Integer> listeModele() {
        CartoucheDAO cart = new CartoucheDAO(this.conn);
        return cart.nbCartoucheParModele();
    }

    public int nbSelonService(String service) {
        return 0;
    }

    public int nbSelonBureau(String bureau) {
        return 0;
    }

    public int nbSelonPersonne(String personne) {
        return 0;
    }
}
