/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;

/**
 * Classe d'exception personnalisé qui permet de faire remonter certaines exceptions 
 * jusqu'à la couche interface afin de les indiquer à l'utilisateur
 * @author mariebarbier
 */
public class SaisieException  extends Exception {
    /**
     * titre a afficher dans la boite de dialogue
     */
    private String dialogTitre;
    /**
     * message a afficher dans la boite de dialogue
     */
    private String dialogMessage;
    /**
     * type de boite de dialogue conformément aux options de JOptionPane
     */
    private int dialogOption;

    /**
     * 
     * @param dialogTitre titre a afficher dans la boite de dialogue
     * @param dialogMessage message a afficher dans la boite de dialogue
     * @param dialogOption  type de boite de dialogue
     */
    public SaisieException(String dialogTitre, String dialogMessage, int dialogOption) {
        this.dialogTitre = dialogTitre;
        this.dialogMessage = dialogMessage;
        this.dialogOption = dialogOption;
    }

    public String getDialogTitre() {
        return dialogTitre;
    }

    public String getDialogMessage() {
        return dialogMessage;
    }

    public int getDialogOption() {
        return dialogOption;
    }
     
     public String toString() {
        return dialogTitre+" : "+dialogMessage;
  }
}
