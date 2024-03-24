/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.JPanel;

/**
 *
 * @author shrikrishnanayak
 */
public class HospitalStaff {
     private String name;
    private String qualification;
    private String email;
    private String contact;
    private String password;

    // Constructor
    public HospitalStaff(String name, String qualification, String email, String contact, String password) {
        this.name = name;
        this.qualification = qualification;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

   


    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }
    
}
