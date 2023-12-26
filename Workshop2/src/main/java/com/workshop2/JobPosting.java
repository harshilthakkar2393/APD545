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

public class JobPosting {
    private String jobTitle = "";
    private String description = "";
    private String qualifications = "";

    public JobPosting(String jobTitle, String description, String qualifications) {
        setJobTitle(jobTitle);
        setDescription(description);
        setQualifications(qualifications);
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

}
