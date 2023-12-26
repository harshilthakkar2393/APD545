/**********************************************
 Workshop 3
 Course:APD545 - Fall2023
 Last Name: Thakkar
 First Name:Harshil
 ID:160431219
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:oct 9 2023
 **********************************************/
package com.example.workshop3;


import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class CompanyDetailsView extends Pane {
    private final Label nameLabel;
    private final Label descLabel;
    private final Label phoneLabel;
    private final Label emailLabel;
    private final Label jobTitleLabel;
    private final Label jobDescLabel;
    private final Label qualLabel;
    private final Label welcomeLabel;

    private final Label desc;
    private final Label name;
    private final Label phoneNumber;
    private final Label email;
    private final Label jobTitle;
    private final Label jobDesc;
    private final Label qual;


    public CompanyDetailsView(Company c) {
        nameLabel = new Label("Name:");
        nameLabel.relocate(56, 56);

        descLabel = new Label("Description:");
        descLabel.relocate(56, 82);

        phoneLabel = new Label("Phone Number:");
        phoneLabel.relocate(56, 111);

        emailLabel = new Label("Email:");
        emailLabel.relocate(56, 130);

        jobTitleLabel = new Label("Job Title:");
        jobTitleLabel.relocate(56, 150);

        jobDescLabel = new Label("Job Desc:");
        jobDescLabel.relocate(56, 170);

        qualLabel = new Label("Qualifications:");
        qualLabel.relocate(56, 190);

        welcomeLabel = new Label("Company Details");
        welcomeLabel.relocate(253, 14);

        name = new Label(c.getName());
        name.relocate(152, 56);

        phoneNumber = new Label(c.getPhoneNo());
        phoneNumber.relocate(152, 111);

        email = new Label(c.getEmail());
        email.relocate(152, 130);

        desc = new Label(c.getDescription());
        desc.relocate(152, 82);

        jobTitle = new Label(c.getJobPosting().getJobTitle());
        jobTitle.relocate(152, 150);

        jobDesc = new Label(c.getJobPosting().getDescription());
        jobDesc.relocate(152, 170);

        qual = new Label(c.getJobPosting().getQualifications());
        qual.relocate(152, 190);

        getChildren().addAll(welcomeLabel, nameLabel, phoneLabel, emailLabel, descLabel, jobTitleLabel, jobDescLabel, qualLabel, name, phoneNumber, email, desc, jobDesc, jobTitle, qual);
    }

    public Label getQual() {
        return qual;
    }

    public Label getJobDesc() {
        return jobDesc;
    }

    public Label getJobTitle() {
        return jobTitle;
    }

    public Label getEmail() {
        return email;
    }

    public Label getPhoneNumber() {
        return phoneNumber;
    }

    public Label getName() {
        return name;
    }

    public Label getDesc() {
        return desc;
    }
}

