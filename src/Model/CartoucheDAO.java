/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.*;
import Controller.SaisieException;
import Metier.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author loren_000
 */
public class CartoucheDAO extends AbstractDAO<Cartouche> {

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
            state.executeUpdate("Update cartouche set dte_achat = " + dteA + ", dte_peremption = " + dteP + ", fk_ref = " + ref + " where id = " + id + ";");
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
    public void insert(Cartouche uneCar) throws SaisieException {

        Date dteA = uneCar.getdateAchat();
        Date dteP = uneCar.getdatePeremption();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

        String dtePFormatted = format1.format(dteP);
        String dteAFormatted = format1.format(dteA);
        Long ref = uneCar.getRef();
        int id = uneCar.getId();

        try {
            Statement state = this.conn.createStatement();

            state.executeUpdate("Insert into cartouche(dte_achat, dte_peremption, fk_ref) values('" + dteAFormatted + "','" + dtePFormatted + "','" + ref + "');", Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = state.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Problème lors de l'insertion de la cartouche");
            }

            state.close();
        } catch (SQLException e) {
            throw new SaisieException("Erreur dans la requête", "Le modèle de cartouche ne doit pas exister. Insertion impossible", JOptionPane.ERROR_MESSAGE);
        }

        uneCar.setId(id);

    }

    public void delete(Cartouche cart) {

        Statement state = null;
        Long ref = cart.getRef();

        try {
            state = this.conn.createStatement();
            state.execute("Delete from cartouche where date_peremption = (Select min(date_peremption) from cartouche where ref = " + ref + ");");
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Cartouche findByRef(long ref) {
        Cartouche cart = null;
        String query = "";

        try {
            Statement state = this.conn.createStatement();
            query = "SELECT date_achat, date_peremption, fk_ref, id "
                    + "FROM cartouche "
                    + "WHERE date_peremption ="
                    + "(SELECT MIN(date_peremption) from cartouche "
                    + "WHERE fk_ref = " + ref + ");";
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
