/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author shrikrishnanayak
 */
public class MainAdmin {
    // Database connection parameters
    private String dbUrl = "jdbc:mysql://localhost:3306/Medicare";
    private String dbUsername = "root"; 
    private String dbPassword = ""; 


    // Getters for the database parameters
    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    
    
    
}
