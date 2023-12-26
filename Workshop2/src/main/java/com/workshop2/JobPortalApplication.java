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

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class JobPortalApplication extends Application {
    private ApplicationView view;
    private Applicant model;
    private ArrayList<Company> companies;
    private ArrayList<Applicant> applicants;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        applicants = new ArrayList<>();
        companies = new ArrayList<>();
        JobPosting posting = new JobPosting("Application Developer", "Make desktop apps using JavaFX !", "CPA @ seneca college!");
        model = new Applicant();
        companies.add(new Company("A", "1234567890", "A@mysenecca.ca", "We are company A", posting));
        companies.add(new Company("B", "1234567890", "B@mysenecca.ca", "We are company B", posting));
        companies.add(new Company("C", "1234567890", "C@mysenecca.ca", "We are company C", posting));
        companies.add(new Company("D", "1234567890", "D@mysenecca.ca", "We are company D", posting));
        companies.add(new Company("E", "1234567890", "E@mysenecca.ca", "We are company E", posting));
        view = new ApplicationView(model, companies);

        // Add event handler for the Add button
        view.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleAddButtonPress();
            }
        });

        view.getRemoveButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleRemoveButtonPress();
            }
        });

        view.getSubmitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleSubmitButtonPress();
            }
        });

        view.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleExitButtonPress(stage);
            }
        });
        view.getClearButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleClearButtonPress();
            }
        });
        view.getDetailsButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                handleDetailsButtonPress();
            }
        });
        Scene scene = new Scene(view, 813, 449);
        stage.setTitle("Online Job Application Portal");
        stage.setScene(scene);
        stage.show();

    }

    private void handleDetailsButtonPress() {
        int index = view.getCompanyDetail().getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            CompanyDetailsView cView = new CompanyDetailsView(companies.get(index));
            Scene scene = new Scene(cView, 600, 238);
            Stage stage = new Stage();
            stage.setTitle("Company Details");
            stage.setScene(scene);
            stage.show();
        }

    }

    private void handleClearButtonPress() {
        view.getEnteredSkill().clear();
        view.getName().clear();
        view.getPhoneNumber().clear();
        view.getEmail().clear();
        view.getSkillsList().setItems(FXCollections.observableArrayList(new ArrayList<String>()));
        model.setSkills(new ArrayList<String>());
        view.update();

    }

    private void handleSubmitButtonPress() {
        Applicant newApplicant=new Applicant();
        newApplicant.setName(view.getName().getText().trim());
        newApplicant.setPhoneNo(view.getPhoneNumber().getText().trim());
        newApplicant.setEmail(view.getEmail().getText().trim());
        for (int index : view.getCompanyOptions().getSelectionModel().getSelectedIndices()) {
            newApplicant.addCompany(companies.get(index));
        }
        for (String s : view.getSkillsList().getItems()) {
            newApplicant.addSkill(s);
        }
        applicants.add(newApplicant);
        view.update();
    }

    private void handleExitButtonPress(Stage stage) {
        stage.close();
    }

    private void handleRemoveButtonPress() {
        model.setName(view.getName().getText().trim());
        model.setPhoneNo(view.getPhoneNumber().getText().trim());
        model.setEmail(view.getEmail().getText().trim());

        int index = view.getSkillsList().getSelectionModel().getSelectedIndex();
        if (index > 0) {
            model.removeSkill(model.getSkills().get(index));
            view.update();
        }
    }

    private void handleAddButtonPress() {
        model.setName(view.getName().getText().trim());
        model.setPhoneNo(view.getPhoneNumber().getText().trim());
        model.setEmail(view.getEmail().getText().trim());
        String text = view.getEnteredSkill().getText().trim();
        if (!text.isEmpty()) {
            model.addSkill(text);
            view.update();
        }
    }
}