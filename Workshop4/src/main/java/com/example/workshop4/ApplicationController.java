/**********************************************
 Workshop 4
 Course:APD545 - Fall 2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:Oct 18, 2023
 **********************************************/
package com.example.workshop4;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ApplicationController extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<com.example.workshop4.Currency> currList = new ArrayList<>();
        currList.add(new com.example.workshop4.Currency("USD", 1.0));
        currList.add(new com.example.workshop4.Currency("INR", 83.19));
        currList.add(new com.example.workshop4.Currency("CAD", 1.36));
        currList.add(new com.example.workshop4.Currency("EUR", 0.95));
        currList.add(new com.example.workshop4.Currency("GBP", 0.82));
        CurrencyConverter model = new CurrencyConverter(currList);

        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationController.class.getResource("Application-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 495.0, 199.0);
        ApplicationViewController controller = fxmlLoader.getController();
        controller.setModel(model);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
        controller.getExitOption().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                stage.close();
            }
        });
        controller.getAboutOption().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("About this Application");
                alert.setHeaderText(null);
                alert.setContentText("This Application allows a user to convert any amount from one currency from another currency . Choose a Currency that you want to convert . Choose a currency that you want to convert to . And enter the amount . Enjoy !!!");
                alert.showAndWait();
            }
        });

        // Adding a invalidation listener (lambda expression)
        controller.getEnteredAmount().textProperty().addListener((ObservableValue<? extends String> ov, String oldVal,
                                                                  String newVal) -> {
            try {

                if (Double.parseDouble(controller.getEnteredAmount().getText()) < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid value ! currency can never be negative . enter a number greater than 0.");
                    alert.showAndWait();
                } else {
                    controller.getResult().setText(new DecimalFormat("0.##").format(model.convert(controller.getToList().getValue(), controller.getFromList().getValue(), Double.parseDouble(controller.getEnteredAmount().getText()))));
                }
            } catch (Exception ignored) {

            }
        });
        controller.getFromList().getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String oldVal,
                                                                                         String newVal) -> {
            try {

                if (Double.parseDouble(controller.getEnteredAmount().getText()) > 0) {
                    controller.getResult().setText(new DecimalFormat("0.##").format(model.convert(controller.getToList().getValue(), controller.getFromList().getValue(), Double.parseDouble(controller.getEnteredAmount().getText()))));
                }
            } catch (Exception ignored) {

            }
        });
        controller.getToList().getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String oldVal,
                                                                                       String newVal) -> {
            try {

                if (Double.parseDouble(controller.getEnteredAmount().getText()) > 0) {
                    controller.getResult().setText(new DecimalFormat("0.##").format(model.convert(controller.getToList().getValue(), controller.getFromList().getValue(), Double.parseDouble(controller.getEnteredAmount().getText()))));
                }
            } catch (Exception ignored) {

            }
        });
    }
}