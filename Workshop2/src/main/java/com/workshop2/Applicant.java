/**********************************************
 Workshop 2
 Course:APD545 - FALL2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 Signature: harshil
 Date:Oct 5 2023
 **********************************************/
package com.workshop2;

import java.util.ArrayList;

public class Applicant {
    private String name = "";
    private String phoneNo = "";
    private String email = "";
    private ArrayList<String> skills = new ArrayList<String>();

    private ArrayList<Company> Companies = new ArrayList<Company>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public void removeSkill(String skill) {
        this.skills.remove(skill);
    }

    public ArrayList<Company> getCompanies() {
        return Companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        Companies = companies;
    }

    public void addCompany(Company c) {
        this.Companies.add(c);
    }

    public void removeCompany(Company c) {
        this.Companies.remove(c);
    }
}
