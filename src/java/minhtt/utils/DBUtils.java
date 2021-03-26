/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhtt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBUtils {
    public static Connection getConnection() throws SQLException{
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Assigment1_TranTuanMinh_SE140690";
            conn=DriverManager.getConnection(url, "sa", "minhlk123");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE,null,e);
        }
        return conn;
    }
}
