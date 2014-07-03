/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Controller.SaisieException;
import java.sql.Connection;

/**
 *
 * @author Benjamin
 */
public abstract class AbstractDAO<T> {
    public Connection conn;
    
    public AbstractDAO(Connection conn)  {
        this.conn = conn;
    }
    
    protected abstract void insert(T obj) throws SaisieException ;
    
    protected abstract void update(T obj) throws SaisieException ;
}
