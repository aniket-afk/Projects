/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author shrikrishnanayak
 */
public class HospitalDoctor {
    private String name;
    private String qualification;
    private String department;
    private String email;
    private String contact;
    private String password;

    public HospitalDoctor(String name, String qualification, String department, String email, String contact, String password) {
        this.name = name;
        this.qualification = qualification;
        this.department = department;
        this.email = email;
        this.contact = contact;
        this.password = password;
    }

    // Getters
    public String getName() { return name; }
    public String getQualification() { return qualification; }
    public String getDepartemnt(){ return department; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }
    public String getPassword() { return password; }
}
