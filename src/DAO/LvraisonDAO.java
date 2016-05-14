/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.*;
import java.sql.Connection;
import technique.DataSource;

/**
 *
 * @author gafsi
 */
public class LvraisonDAO {
    private Connection connection;

    public LvraisonDAO() {
        connection=DataSource.getInstance().getConnection();
    }
    

   
}
