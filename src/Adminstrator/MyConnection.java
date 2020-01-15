/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adminstrator;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class MyConnection {
    public static Connection getConnection() throws ClassNotFoundException{
        Connection con =null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =DriverManager.getConnection("jdbc:mysql://localhost/yuklama", "root", "");
            //JOptionPane.showMessageDialog(null, " DataBase Connected!");
        }
        catch ( SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
}
