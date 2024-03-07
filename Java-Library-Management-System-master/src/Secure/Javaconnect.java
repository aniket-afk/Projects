/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

/**
 *
 * @author Vedant Parnaik
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class Javaconnect {
Connection conn;
public static Connection ConnecrDb(){
    try{
        Class.forName("org.sqlite.JDBC");
        Connection conn=DriverManager.getConnection("jdbc:sqlite:E:\\aniket\\netbeans\\LMS\\LMS-20190920T162919Z-001\\LMS\\LMS\\LibraryMgmt.sqlite");
                return conn;
    }catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
}
}
