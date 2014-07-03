/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package marriors;
import View.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Frébault
 */
public class Marriors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        registerFont();
        EntreeEnStock s = new  EntreeEnStock();
        s.show();
    }
        public static void registerFont() {
                try{
                        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                        
                        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(Paths.get(System.getProperty("user.dir"),"/src/Ressources/open-sans.bold.ttf").toUri())));
                        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(Paths.get(System.getProperty("user.dir"),"/src/Ressources/open-sans.italic.ttf").toUri())));
                        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(Paths.get(System.getProperty("user.dir"),"/src/Ressources/open-sans.regular.ttf").toUri())));
                }
                catch(IOException ex ){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                } catch (FontFormatException ex) {
                        Logger.getLogger(Marriors.class.getName()).log(Level.SEVERE, null, ex);
                 }

        }
    }


