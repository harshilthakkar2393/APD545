/**********************************************
 Workshop 6
 Course:APD545 - Fall 2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:Nov 30, 2023
 **********************************************/
package com.example.workshop6;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

public class ApplicationController extends javafx.application.Application {
    public static void main(String[] args) {
        launch();
    }
    public void loadCurrencies(ArrayList<Currency> list)
    {
        try (BufferedReader in = new BufferedReader(new FileReader("src//main//resources//com//example//workshop6//exchange-rates.txt"))) {
            String line;

            while ((line = in.readLine()) != null) {
                String[] fields = line.split(",");
                if(fields.length==3)
                {

//              assuming the data is in format From currency , To Currency , Exchange rate
//               assuming that the to-currency is always CAD
                String fromCurrency = fields[0].split(":")[1].trim();
                double exchangeRate = Double.parseDouble(fields[2].split(":")[1].trim());
                list.add(new Currency(fromCurrency,exchangeRate));
                }

            }
//            adding CAD
            list.add(new Currency("CAD",1));
        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file");
        }

    }
    public void saveResult(String from,String to,String excRate,String res)
    {
        String line="From Currency: "+from+",  To Currency: "+to+", Entered Amount: "+ excRate+", Converted result: "+res;

        try (BufferedWriter out = new BufferedWriter(new FileWriter("src//main//resources//com//example//workshop6//exchange-rates.txt",true))) {
            out.newLine();
            out.write(line);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Cannot open file for reading");
        } catch (IOException e) {
            System.out.println("Error: Cannot read from file");
        }
    }

    public Dialog registerDialog()
    {
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

    public Dialog loginDialog(){
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

    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<com.example.workshop6.Currency> currList = new ArrayList<>();
        loadCurrencies(currList);
        CurrencyConverter model = new CurrencyConverter(currList);
        FXMLLoader loginFxmlLoader = new FXMLLoader(LoginViewController.class.getResource("Login-view.fxml"));
        Scene loginScene = new Scene(loginFxmlLoader.load(), 374.0, 209.0);
        LoginViewController loginController = loginFxmlLoader.getController();
        LoginRegisterSystem loginRegisterSystem = new LoginRegisterSystem();
        FXMLLoader applicationFxmlLoader = new FXMLLoader(ApplicationController.class.getResource("Application-view.fxml"));
        Scene applicationScene = new Scene(applicationFxmlLoader.load(), 619.0, 141.0);
        ApplicationViewController applicationController = applicationFxmlLoader.getController();
        applicationController.setModel(model);
        stage.setTitle("Currency Converter");
        stage.setScene(loginScene);
        stage.show();


        loginController.getLoginButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Dialog dialog=loginDialog();
                Optional<Pair<String, String>> result = dialog.showAndWait();
                if (result.isPresent()) {
                    if(loginRegisterSystem.login(result.get().getKey(), result.get().getValue())) {

                        stage.setScene(applicationScene);
                        stage.show();
                    }
                    else {
                        dialog.setHeaderText("Invalid credentials ! try again.");
                        dialog.getDialogPane().lookup(".header-panel .label").setStyle("-fx-text-fill: red;");
                        dialog.showAndWait();
                    }
                }
            }
        });
        loginController.getRegisterButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Dialog dialog=registerDialog();
                Optional<Pair<String, String>> result = dialog.showAndWait();
                if (result.isPresent()) {
                    if(loginRegisterSystem.register(result.get().getKey(), result.get().getValue())) {

                        stage.setScene(applicationScene);
                        stage.show();
                    }
                    else {
                        dialog.setHeaderText("Username already taken ! try a different one.");
                        dialog.getDialogPane().lookup(".header-panel .label").setStyle("-fx-text-fill: red;");
                        dialog.showAndWait();
                    }
                }
            }
        });
        applicationController.getSaveOption().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                saveResult(applicationController.getFromList().getValue(),applicationController.getToList().getValue(),applicationController.getEnteredAmount().getText(),applicationController.getResult().getText());
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
                    applicationController.getResult().setText(new DecimalFormat("0.##").format(model.convert(applicationController.getToList().getValue(), applicationController.getFromList().getValue(), Double.parseDouble(applicationController.getEnteredAmount().getText()))));
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