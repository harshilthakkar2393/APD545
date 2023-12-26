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


import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class ApplicationView extends GridPane {
    private final Applicant model;
    private final ArrayList<Company> companies;
    private final Button clearButton;
    private final Button exitButton;
    private final ChoiceBox<String> companyDetail;
    private final Button detailsButton;
    private final TextField name;
    private final TextField phoneNumber;
    private final TextField email;
    private final TextField enteredSkill;
    private final ListView<String> skillsList;
    private final Button addButton;
    private final Button removeButton;
    private final ListView<String> companyOptions;
    private final Button submitButton;
    private final Label nameLabel;
    private final Label phoneLabel;
    private final Label emailLabel;
    private final Label welcomeLabel;
    private final Label skillsLabel;
    private final Label CompaniesLabel;
    private final Label companyDetailsLabel;


    public ApplicationView(Applicant a, ArrayList<Company> c) {
        model = a;
        companies = c;
        welcomeLabel = new Label("Fill the form to apply for a job !!");
        setHalignment(welcomeLabel, HPos.CENTER);
        add(welcomeLabel, 2, 0);

        exitButton = new Button("Exit");
        setHalignment(exitButton, HPos.RIGHT);
        setValignment(exitButton, VPos.CENTER);
        add(exitButton, 4, 0);

        nameLabel = new Label("Name :");
        setHalignment(nameLabel, HPos.LEFT);
        setMargin(nameLabel, new Insets(10));
        add(nameLabel, 0, 2);


        name = new TextField();
        setHalignment(name, HPos.CENTER);
        setMargin(name, new Insets(10));
        add(name, 1, 2);

        var applicantDetailsLabel = new Label("Applicant Details");
        setHalignment(applicantDetailsLabel, HPos.CENTER);
        add(applicantDetailsLabel, 1, 1);

        skillsLabel = new Label("Skills");
        setHalignment(skillsLabel, HPos.CENTER);
        add(skillsLabel, 2, 1);

        phoneLabel = new Label("Phone Number :");
        setHalignment(phoneLabel, HPos.LEFT);
        setValignment(phoneLabel, VPos.TOP);
        setMargin(phoneLabel, new Insets(10));
        add(phoneLabel, 0, 3);


        phoneNumber = new TextField();
        setHalignment(phoneNumber, HPos.RIGHT);
        setValignment(phoneNumber, VPos.TOP);
        setMargin(phoneNumber, new Insets(10));
        add(phoneNumber, 1, 3);

        enteredSkill = new TextField();
//        add(enteredSkill,2,2);

        addButton = new Button("Add");
        addButton.setPrefSize(100, 25);
        setMargin(addButton, new Insets(10, 0, 10, 10));
        setHalignment(addButton, HPos.LEFT);
        setValignment(addButton, VPos.TOP);
        add(addButton, 2, 2);

        emailLabel = new Label("Email :");
        setHalignment(emailLabel, HPos.LEFT);
//        setValignment(emailLabel,VPos.CENTER);
        setMargin(emailLabel, new Insets(10, 10, 10, 10));
        add(emailLabel, 0, 3);

        email = new TextField();
        setHalignment(email, HPos.RIGHT);
//        setValignment(email,VPos.CENTER);
        setMargin(email, new Insets(10, 10, 10, 10));
        add(email, 1, 3);

        skillsList = new ListView<String>();
        skillsList.setPrefSize(200, 200);
        setHalignment(skillsList, HPos.CENTER);
        setMargin(skillsList, new Insets(10));
        add(skillsList, 2, 3);

        removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 25);
        setHalignment(removeButton, HPos.RIGHT);
        setValignment(removeButton, VPos.TOP);
        setMargin(removeButton, new Insets(10, 10, 10, 0));
        add(removeButton, 2, 2);

        companyDetailsLabel = new Label("Company Details");
        setValignment(companyDetailsLabel, VPos.TOP);
        setHalignment(companyDetailsLabel, HPos.CENTER);
        add(companyDetailsLabel, 3, 1);

        companyDetail = new ChoiceBox<String>();
        setHalignment(companyDetail, HPos.CENTER);
        setValignment(companyDetail, VPos.CENTER);
        companyDetail.setPrefSize(135, 25);
        setMargin(companyDetail, new Insets(10));
        add(companyDetail, 3, 2);

        detailsButton = new Button("Details");
        setValignment(detailsButton, VPos.TOP);
        setHalignment(detailsButton, HPos.CENTER);
        setMargin(detailsButton, new Insets(10));
        add(detailsButton, 4, 2);


        CompaniesLabel = new Label("Companies");
        setHalignment(CompaniesLabel, HPos.CENTER);
        setValignment(CompaniesLabel, VPos.TOP);
        setMargin(CompaniesLabel, new Insets(10));
        add(CompaniesLabel, 3, 3);

        companyOptions = new ListView<String>();
        companyOptions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        companyOptions.setPrefSize(160, 174);
        setValignment(companyOptions, VPos.CENTER);
        setMargin(companyOptions, new Insets(10));
        add(companyOptions, 3, 3);

        clearButton = new Button("Clear");
        setMargin(clearButton, new Insets(10, 0, 10, 10));
        setHalignment(clearButton, HPos.LEFT);
        add(clearButton, 3, 4);

        submitButton = new Button("Submit");
        setHalignment(submitButton, HPos.RIGHT);
        setMargin(submitButton, new Insets(10, 10, 10, 0));
        add(submitButton, 3, 4);

        update();
    }

    public void update() {
//        setting skills list
        if (model != null && !model.getSkills().isEmpty()) {
            this.skillsList.setItems(FXCollections.observableArrayList(model.getSkills()));
            name.setText(model.getName());
            phoneNumber.setText(model.getPhoneNo());
            email.setText(model.getEmail());
        }
//        setting company options
        if (companies != null && !companies.isEmpty()) {

            ArrayList<String> Companies = new ArrayList<String>();
            for (Company company : companies) {
                Companies.add(company.getName());
            }
            companyDetail.setItems(FXCollections.observableArrayList(Companies));
            companyOptions.setItems(FXCollections.observableArrayList(Companies));
        }


    }

    public TextField getName() {
        return name;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public TextField getEmail() {
        return email;
    }

    public TextField getEnteredSkill() {
        return enteredSkill;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public ListView<String> getCompanyOptions() {
        return companyOptions;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public ListView<String> getSkillsList() {
        return skillsList;
    }

    public Button getDetailsButton() {
        return detailsButton;
    }

    public ChoiceBox<String> getCompanyDetail() {
        return companyDetail;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public Button getExitButton() {
        return exitButton;
    }
}
