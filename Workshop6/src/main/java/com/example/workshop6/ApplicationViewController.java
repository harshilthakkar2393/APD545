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

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ApplicationViewController {


    private CurrencyConverter model;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu fileMenu;
    @FXML
    private MenuItem exitOption;
    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem aboutOption;
    @FXML
    private ChoiceBox<String> toList;
    @FXML
    private ChoiceBox<String> fromList;
    @FXML
    private Label toLabel;
    @FXML
    private TextField enteredAmount;
    @FXML
    private Label result;
    @FXML
    private MenuItem logOut;
    @FXML
    private MenuItem saveOption;


    public void setModel(CurrencyConverter m) {
        this.model = m;
        toList.setItems(FXCollections.observableArrayList(model.getCurrencyNames()));
        fromList.setItems(FXCollections.observableArrayList(model.getCurrencyNames()));

    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public Menu getFileMenu() {
        return fileMenu;
    }

    public void setFileMenu(Menu fileMenu) {
        this.fileMenu = fileMenu;
    }

    public MenuItem getExitOption() {
        return exitOption;
    }

    public void setExitOption(MenuItem exitOption) {
        this.exitOption = exitOption;
    }

    public Menu getHelpMenu() {
        return helpMenu;
    }

    public void setHelpMenu(Menu helpMenu) {
        this.helpMenu = helpMenu;
    }

    public MenuItem getAboutOption() {
        return aboutOption;
    }

    public void setAboutOption(MenuItem aboutOption) {
        this.aboutOption = aboutOption;
    }

    public Label getToLabel() {
        return toLabel;
    }

    public void setToLabel(Label toLabel) {
        this.toLabel = toLabel;
    }

    public TextField getEnteredAmount() {
        return enteredAmount;
    }

    public void setEnteredAmount(TextField enteredAmount) {
        this.enteredAmount = enteredAmount;
    }

    public Label getResult() {
        return result;
    }

    public void setResult(Label result) {
        this.result = result;
    }

    public ChoiceBox<String> getToList() {
        return toList;
    }

    public void setToList(ChoiceBox<String> toList) {
        this.toList = toList;
    }

    public ChoiceBox<String> getFromList() {
        return fromList;
    }

    public void setFromList(ChoiceBox<String> fromList) {
        this.fromList = fromList;
    }

    public MenuItem getLogOut() {
        return logOut;
    }

    public void setLogOut(MenuItem logOut) {
        this.logOut = logOut;
    }

    public MenuItem getSaveOption() {
        return saveOption;
    }

    public void setSaveOption(MenuItem saveOption) {
        this.saveOption = saveOption;
    }
}
