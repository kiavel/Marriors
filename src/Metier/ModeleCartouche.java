/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metier;

/**
 *
 * @author Benjamin
 */
public class ModeleCartouche {
    private long ref;
    private String couleur;
    private String type;
    
    public ModeleCartouche(long ref, String couleur, String type) {
        this.ref = ref;
        this.couleur = couleur;
        this.type = type;
    }

    public long getRef() {
        return ref;
    }

    public void setRef(long ref) {
        this.ref = ref;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}