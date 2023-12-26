/**********************************************
 Final Project
 Course:APD545 - Fall 2023
 Last Name: Thakkar
 First Name: Harshil
 ID: 160431219
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date: Dec 7th 2023
 **********************************************/
package com.example.apdproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class MainApplication extends Application {
    LoginRegisterSystem loginRegisterSystem = new LoginRegisterSystem();
    ApplicationViewController applicationController;

    public static void main(String[] args) {
        launch();
    }

    public void editEntry(int Id, Stage stage) {
        Dialog dialog = editDialog(loginRegisterSystem.getCurrentUser().getEntryById(Id), stage);
        Optional<Pair<String, JournalEntry>> result = dialog.showAndWait();
        if (result.isPresent()) {
            loginRegisterSystem.getCurrentUser().editEntry(result.get().getValue());
            loginRegisterSystem.saveData();
            applicationController.loadEntries();
        }
    }

    public void deleteEntry(int Id) {
        loginRegisterSystem.getCurrentUser().deleteEntry(Id);
        loginRegisterSystem.saveData();
        applicationController.loadEntries();
    }

    public void addEntry(Stage stage) {
        Dialog dialog = addDialog(stage);
        Optional<Pair<String, JournalEntry>> result = dialog.showAndWait();
        if (result.isPresent()) {
            loginRegisterSystem.getCurrentUser().addEntry(result.get().getValue());
            loginRegisterSystem.saveData();
            applicationController.loadEntries();
        }
    }

    public Dialog registerDialog() {
        Dialog dialog = new Dialog();
        dialog.setTitle("Register Dialog");
        dialog.setHeaderText(null);
        ButtonType loginButtonType = new ButtonType("Register",
                ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(new Callback<ButtonType, Pair<String, String>>() {
            public Pair<String, String> call(ButtonType b) {
                if (b == loginButtonType && !username.getText().isEmpty() && !password.getText().isEmpty()) {
                    return new
                            Pair<String, String>(username.getText(),
                            password.getText());
                }
                return null;
            }
        });
        return dialog;
    }

    public Dialog loginDialog() {
        Dialog dialog = new Dialog();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText(null);
        ButtonType loginButtonType = new ButtonType("Login",
                ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(new Callback<ButtonType, Pair<String, String>>() {
            public Pair<String, String> call(ButtonType b) {
                if (b == loginButtonType && !username.getText().isEmpty() && !password.getText().isEmpty()) {
                    return new
                            Pair<String, String>(username.getText(),
                            password.getText());
                }
                return null;
            }
        });
        return dialog;
    }

    public Dialog addDialog(Stage stage) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Add Dialog");
        dialog.setHeaderText(null);
        ButtonType loginButtonType = new ButtonType("Add",
                ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        TextField title = new TextField();
        title.setPromptText("Title");
        TextArea desc = new TextArea();
        final String[] imagePath = {null};
        Button image = new Button("Select File");

        image.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Save Data File");
                File f = chooser.showOpenDialog(stage);
                if (f != null) {
                    imagePath[0] = f.getAbsolutePath();

                }
            }
        });

        desc.setPromptText("Title");
        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(desc, 1, 1);
        grid.add(new Label("Image File:"), 0, 2);
        grid.add(image, 1, 2);
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(new Callback<ButtonType, Pair<String, JournalEntry>>() {
            public Pair<String, JournalEntry> call(ButtonType b) {
                if (b == loginButtonType && !title.getText().isEmpty() && !desc.getText().isEmpty()) {
                    return new Pair<String, JournalEntry>(title.getText(), new JournalEntry(title.getText(), desc.getText(), imagePath[0]));
                }
                return null;
            }
        });
        return dialog;
    }

    public Dialog editDialog(JournalEntry e, Stage stage) {
        Dialog dialog = new Dialog();
        dialog.setTitle("Edit Dialog");
        dialog.setHeaderText(null);
        ButtonType loginButtonType = new ButtonType("Edit",
                ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));
        TextField title = new TextField();
        title.setText(e.getTitle());
        TextArea desc = new TextArea();
        desc.setText(e.getDescription());
        final String[] imagePath = {e.getImagePath()};
        Button image = new Button("Select File");

        image.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FileChooser chooser = new FileChooser();
                chooser.setTitle("Save Data File");
                File f = chooser.showOpenDialog(stage);
                if (f != null) {
                    imagePath[0] = f.getAbsolutePath();
                }
            }
        });

        desc.setPromptText("Title");
        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Description:"), 0, 1);
        grid.add(desc, 1, 1);
        grid.add(new Label("Image File:"), 0, 2);
        grid.add(image, 1, 2);
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(new Callback<ButtonType, Pair<String, JournalEntry>>() {
            public Pair<String, JournalEntry> call(ButtonType b) {
                if (b == loginButtonType && !title.getText().isEmpty() && !desc.getText().isEmpty()) {
                    return new Pair<String, JournalEntry>(title.getText(), new JournalEntry(e.getId(), title.getText(), desc.getText(), imagePath[0]));
                }
                return null;
            }
        });
        return dialog;
    }

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loginFxmlLoader = new FXMLLoader(LoginViewController.class.getResource("Login-view.fxml"));
        Scene loginScene = new Scene(loginFxmlLoader.load(), 374.0, 209.0);

        LoginViewController loginController = loginFxmlLoader.getController();

        FXMLLoader applicationFxmlLoader = new FXMLLoader(ApplicationViewController.class.getResource("Application-view.fxml"));
        Scene applicationScene = new Scene(applicationFxmlLoader.load(), 800.0, 600.0);
        applicationController = applicationFxmlLoader.getController();
        applicationController.setApp(this);

        stage.setTitle("Travel Journal");
        stage.setScene(loginScene);
        stage.show();


        loginController.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Dialog dialog = loginDialog();
                Optional<Pair<String, String>> result = dialog.showAndWait();
                if (result.isPresent()) {
                    if (loginRegisterSystem.login(result.get().getKey(), result.get().getValue())) {
                        applicationController.loadEntries();
                        stage.setScene(applicationScene);
                        stage.show();
                    } else {
                        dialog.setHeaderText("Invalid credentials ! try again.");
                        dialog.getDialogPane().lookup(".header-panel .label").setStyle("-fx-text-fill: red;");
                        dialog.showAndWait();
                    }
                }
            }
        });
        loginController.getRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Dialog dialog = registerDialog();
                Optional<Pair<String, String>> result = dialog.showAndWait();
                if (result.isPresent()) {
                    if (loginRegisterSystem.register(result.get().getKey(), result.get().getValue())) {
                        applicationController.loadEntries();
                        stage.setScene(applicationScene);
                        stage.show();
                    } else {
                        dialog.setHeaderText("Username already taken ! try a different one.");
                        dialog.getDialogPane().lookup(".header-panel .label").setStyle("-fx-text-fill: red;");
                        dialog.showAndWait();
                    }
                }
            }
        });
        applicationController.getLogOffOption().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.setScene(loginScene);
                stage.show();
            }
        });
        applicationController.getExitOption().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        applicationController.getAboutOption().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("About this Application");
                alert.setHeaderText(null);
                alert.setContentText("This Application allows a user to create travel journal entries and add new delete and edit them .");
                alert.showAndWait();
            }
        });
    }
}