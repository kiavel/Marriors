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
    private Double prix;
    private String taille;
    private int nbPages;
    
    public ModeleCartouche(long ref, String couleur, String type, Double prix, int nbPages, String taille) {
        this.ref = ref;
        this.couleur = couleur;
        this.type = type;
        this.prix = prix;
        this.nbPages = nbPages;
        this.taille = taille;
    }

    public ModeleCartouche(long ref) {
        this.ref = ref;
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
    
    
}
