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

import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ApplicationView extends Pane {
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
        clearButton = new Button("Clear");
        clearButton.relocate(617, 400);

        exitButton = new Button("Exit");
        exitButton.relocate(758, 11);

        companyDetail = new ChoiceBox<String>();
        companyDetail.relocate(611, 167);
        companyDetail.setPrefSize(135, 25);

        detailsButton = new Button("Details");
        detailsButton.relocate(749, 167);

        name = new TextField();
        name.relocate(131, 42);

        phoneNumber = new TextField();
        phoneNumber.relocate(131, 75);

        email = new TextField();
        email.relocate(131, 111);

        enteredSkill = new TextField();
        enteredSkill.relocate(401, 67);

        skillsList = new ListView<String>();
        skillsList.relocate(381, 100);
        skillsList.setPrefSize(200, 200);

        addButton = new Button("Add");
        addButton.relocate(622, 67);
        addButton.setPrefSize(150, 25);

        removeButton = new Button("Remove");
        removeButton.relocate(622, 99);
        removeButton.setPrefSize(150, 25);

        companyOptions = new ListView<String>();
        companyOptions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        companyOptions.relocate(617, 213);
        companyOptions.setPrefSize(160, 174);

        submitButton = new Button("Submit");
        submitButton.relocate(715, 400);

        nameLabel = new Label("Name :");
        nameLabel.relocate(16, 46);

        phoneLabel = new Label("Phone Number :");
        phoneLabel.relocate(18, 79);

        emailLabel = new Label("Email :");
        emailLabel.relocate(18, 115);

        welcomeLabel = new Label("Fill the form to apply for a job !!");
        welcomeLabel.relocate(318, 6);

        skillsLabel = new Label("Skills");
        skillsLabel.relocate(466, 46);

        CompaniesLabel = new Label("Companies");
        CompaniesLabel.relocate(668, 192);

        companyDetailsLabel = new Label("Company Details");
        companyDetailsLabel.relocate(655, 144);

        getChildren().addAll(welcomeLabel, nameLabel, phoneLabel, emailLabel, name, phoneNumber, email, skillsLabel, enteredSkill, skillsList, addButton, removeButton, CompaniesLabel, submitButton, clearButton, exitButton, companyDetail, companyDetailsLabel, companyOptions, detailsButton);

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