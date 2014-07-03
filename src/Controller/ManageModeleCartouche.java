/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Metier.ModeleCartouche;
import Model.ModeleDAO;
import java.sql.Connection;
import java.util.HashMap;

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

    }

    public void modifierModele(ModeleCartouche modeleUn, ModeleCartouche modeleDeux) {

    }

    public HashMap<ModeleCartouche, Integer> listeModele() {
        return null;
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
