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

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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
        view.getSkillsList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                handleEdit(mouseEvent);
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
        Applicant newApplicant = new Applicant();
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
        if (model.getSkills().size() == 1) {
            model.setSkills(new ArrayList<String>());
        } else {

            if (index > 0) {
                model.removeSkill(index);
            }
        }
        view.update();
    }

    private void handleAddButtonPress() {
        model.setName(view.getName().getText().trim());
        model.setPhoneNo(view.getPhoneNumber().getText().trim());
        model.setEmail(view.getEmail().getText().trim());
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Input Required: Add a new skill");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your skill:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            model.addSkill(result.get().trim());
            view.update();
        }
    }

    public void handleEdit(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            String selectedSkill;
            int selectedIndex = view.getSkillsList().getSelectionModel().
                    getSelectedIndex();
            if (selectedIndex >= 0) {
                selectedSkill = model.getSkills().get(selectedIndex);
                if (selectedSkill == null) return;
// Now bring up the dialog box
                TextInputDialog dialog = new TextInputDialog(selectedSkill);
                dialog.setTitle("Input Required : Edit the selected skill");
                dialog.setHeaderText(null);
                dialog.setContentText("Please enter new/edited skill:");
                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    model.getSkills().set(selectedIndex, result.get());
                    view.update();
                }
            }
        } else {
            view.update(); // Allows Remove button to be enabled on single click
        }
    }
}