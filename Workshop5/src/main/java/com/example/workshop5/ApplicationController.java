/**********************************************
 Workshop 5
 Course:APD545 - Fall 2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:Nov 09, 2023
 **********************************************/
package com.example.workshop5;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

public class ApplicationController extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<com.example.workshop5.Currency> currList = new ArrayList<>();
        currList.add(new com.example.workshop5.Currency("USD", 1.0));
        currList.add(new com.example.workshop5.Currency("INR", 83.19));
        currList.add(new com.example.workshop5.Currency("CAD", 1.36));
        currList.add(new com.example.workshop5.Currency("EUR", 0.95));
        currList.add(new com.example.workshop5.Currency("GBP", 0.82));
        CurrencyConverter model = new CurrencyConverter(currList);
        FXMLLoader loginFxmlLoader = new FXMLLoader(LoginViewController.class.getResource("Login-view.fxml"));
        Scene loginScene = new Scene(loginFxmlLoader.load(), 374.0, 209.0);
        LoginViewController loginController =  loginFxmlLoader.getController();
        LoginRegisterSystem loginRegisterSystem=new LoginRegisterSystem();
        FXMLLoader applicationFxmlLoader = new FXMLLoader(ApplicationController.class.getResource("Application-view.fxml"));
        Scene applicationScene = new Scene(applicationFxmlLoader.load(), 619.0, 141.0);
        ApplicationViewController applicationController =  applicationFxmlLoader.getController();
        applicationController.setModel(model);
        stage.setTitle("Currency Converter");
        stage.setScene(loginScene);
        stage.show();


        loginController.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Dialog dialog = new Dialog();
                dialog.setTitle("Login Dialog");
                dialog.setHeaderText(null);
                ButtonType loginButtonType = new ButtonType("Login",
                        ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                        ButtonType.CANCEL);
                GridPane grid = new GridPane();
                grid.setHgap(10); grid.setVgap(10);
                grid.setPadding(new Insets(10, 10, 10, 10));
                TextField username = new TextField(); username.setPromptText("Username");
                PasswordField password = new PasswordField();
                password.setPromptText("Password");
                grid.add(new Label("Username:"), 0, 0); grid.add(username, 1, 0);
                grid.add(new Label("Password:"), 0, 1); grid.add(password, 1, 1);
                dialog.getDialogPane().setContent(grid);
                dialog.showAndWait();
                if(!username.getText().isEmpty() && !password.getText().isEmpty())
                {
                    while(!(loginRegisterSystem.login(username.getText(),password.getText())))
                    {
                        dialog.setHeaderText("Invalid credentials ! try again.");
                        dialog.showAndWait();
                        if(username.getText().isEmpty() && password.getText().isEmpty())
                        {break;}
                    }
//                    to make sure user doesn't get access when cancel is pressed
                    if(loginRegisterSystem.login(username.getText(),password.getText()))
                    {
                        stage.setScene(applicationScene);
                        stage.show();
                    }
                }
                dialog.close();
            }
        });
        loginController.getRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Dialog dialog = new Dialog();
                dialog.setTitle("Register Dialog");
                dialog.setHeaderText(null);
                ButtonType loginButtonType = new ButtonType("Register",
                        ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().addAll(loginButtonType,
                        ButtonType.CANCEL);
                GridPane grid = new GridPane();
                grid.setHgap(10); grid.setVgap(10);
                grid.setPadding(new Insets(10, 10, 10, 10));
                TextField username = new TextField(); username.setPromptText("Username");
                PasswordField password = new PasswordField();
                password.setPromptText("Password");
                grid.add(new Label("Username:"), 0, 0); grid.add(username, 1, 0);
                grid.add(new Label("Password:"), 0, 1); grid.add(password, 1, 1);
                dialog.getDialogPane().setContent(grid);
                dialog.showAndWait();
                if(!username.getText().isEmpty() && !password.getText().isEmpty()) {

                    while (!(loginRegisterSystem.register(username.getText(), password.getText()))) {
                        dialog.setHeaderText("Username already taken ! try a different one.");
                        dialog.showAndWait();
                    }
//                    to make sure that user doesn't get access on pressing cancel
                        if(loginRegisterSystem.login(username.getText(),password.getText()))
                        {
                            stage.setScene(applicationScene);
                            stage.show();
                        }
                }


            }
        });
        applicationController.getLogOut().setOnAction(new EventHandler<ActionEvent>() {
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
                alert.setContentText("This Application allows a user to convert any amount from one currency from another currency . Choose a Currency that you want to convert . Choose a currency that you want to convert to . And enter the amount . Enjoy !!!");
                alert.showAndWait();
            }
        });

        // Adding a invalidation listener (lambda expression)
        applicationController.getEnteredAmount().textProperty().addListener((ObservableValue<? extends String> ov, String oldVal,
                                                                  String newVal) -> {
            try {

                if (Double.parseDouble(applicationController.getEnteredAmount().getText()) < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid value ! currency can never be negative . enter a number greater than 0.");
                    alert.showAndWait();
                } else {
                    applicationController.getResult().setText(new DecimalFormat("0.##").format(model.convert(applicationController.getToList().getValue(), applicationController.getFromList().getValue(), Double.parseDouble(applicationController.getEnteredAmount().getText()))));
                }
            } catch (Exception ignored) {

            }
        });
        applicationController.getFromList().getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String oldVal,
                                                                                         String newVal) -> {
            try {

                if (Double.parseDouble(applicationController.getEnteredAmount().getText()) > 0) {
                    applicationController.getResult().setText(new DecimalFormat("0.##").format(model.convert( applicationController.getToList().getValue(), applicationController.getFromList().getValue(), Double.parseDouble(applicationController.getEnteredAmount().getText()))));
                }
            } catch (Exception ignored) {

            }
        });
        applicationController.getToList().getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String oldVal,
                                                                                       String newVal) -> {
            try {

                if (Double.parseDouble(applicationController.getEnteredAmount().getText()) > 0) {
                    applicationController.getResult().setText(new DecimalFormat("0.##").format(model.convert(applicationController.getToList().getValue(), applicationController.getFromList().getValue(), Double.parseDouble(applicationController.getEnteredAmount().getText()))));
                }
            } catch (Exception ignored) {

            }
        });
    }
}