/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author shrikrishnanayak
 */
public class InsuranceCustomer {
    private String name;
    private Date dob;
    private int age;
    private String gender;
    private String contact;
    private String email;
    private String address;
    private String premium;
    private Date startDate;
    private Date endDate;
    private String insuranceNumber;

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPremium() {
        return premium;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }
    
}
