/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Ritik
 */
public class LabAdmin {
    private String name;
    private String username;
    private String password;
    private String email;

    public LabAdmin(String name, String username, String password,String lab) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Getters
    public String getName() { return name;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getEmail() {return email;}
}
