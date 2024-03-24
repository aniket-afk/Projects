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
public class HospitalPatient {
    private String name;
    private String age;
    private Date dob;
    private String gender;
    private String address;
    private String contact;
    private String email;
    private String bloodGroup;
    private String medicalHistory;
    private String allergy;
    private String department;
    private String doctor;
    private String reasonToVisit;

    public HospitalPatient(String name, String age, Date dob, String gender, String address, String contact, String email, String bloodGroup, String medicalHistory, String allergy, String department, String doctor, String reasonToVisit) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.medicalHistory = medicalHistory;
        this.allergy = allergy;
        this.department = department;
        this.doctor = doctor;
        this.reasonToVisit = reasonToVisit;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getAllergy() {
        return allergy;
    }

    public String getDepartment() {
        return department;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getReasonToVisit() {
        return reasonToVisit;
    }

}
