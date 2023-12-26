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

public class Company {
    private String name = "";
    private String description = "";
    private String phoneNo = "";
    private String email = "";
    private JobPosting jobPosting;

    public Company(String name, String phoneNumber, String email, String Description, JobPosting posting) {
        setName(name);
        setEmail(email);
        setPhoneNo(phoneNumber);
        setDescription(Description);
        setJobPosting(posting);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }
}
