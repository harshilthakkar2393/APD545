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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationViewController {

    @FXML
    private GridPane mainGrid;
    @FXML
    private MenuBar menu;
    @FXML
    private Menu fileOption;
    @FXML
    private MenuItem logOffOption;
    @FXML
    private MenuItem exitOption;
    @FXML
    private MenuItem aboutOption;
    @FXML
    private Button addButton;
    @FXML
    private FlowPane Dashboard;
    private MainApplication app;
    private Stage stage;


    public GridPane getMainGrid() {
        return mainGrid;
    }

    public void setMainGrid(GridPane mainGrid) {
        this.mainGrid = mainGrid;
    }

    public MenuBar getMenu() {
        return menu;
    }

    public void setMenu(MenuBar menu) {
        this.menu = menu;
    }

    public Menu getFileOption() {
        return fileOption;
    }

    public void setFileOption(Menu fileOption) {
        this.fileOption = fileOption;
    }

    public MenuItem getLogOffOption() {
        return logOffOption;
    }

    public void setLogOffOption(MenuItem logOffOption) {
        this.logOffOption = logOffOption;
    }

    public MenuItem getExitOption() {
        return exitOption;
    }

    public void setExitOption(MenuItem exitOption) {
        this.exitOption = exitOption;
    }

    public MenuItem getAboutOption() {
        return aboutOption;
    }

    public void setAboutOption(MenuItem aboutOption) {
        this.aboutOption = aboutOption;
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public FlowPane getDashboard() {
        return Dashboard;
    }

    public void setDashboard(FlowPane dashboard) {
        Dashboard = dashboard;
    }

    public void handleAddButton(ActionEvent actionEvent) {
        app.addEntry(stage);
    }

    public MainApplication getApp() {
        return app;
    }

    public void setApp(MainApplication app) {
        this.app = app;
        loadEntries();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void loadEntries() {
        if (app.loginRegisterSystem.getCurrentUser() != null) {
            getDashboard().getChildren().clear();
            for (var entry : app.loginRegisterSystem.getCurrentUser().getEntries()
            ) {

                if (entry.getImagePath() != null && !entry.getImagePath().isEmpty()) {
                    JournalEntryWithImageViewController j = new JournalEntryWithImageViewController(entry, app, stage);
                    getDashboard().getChildren().add(j);
                } else {
                    JournalEntryViewController j = new JournalEntryViewController(entry, app, stage);
                    getDashboard().getChildren().add(j);
                }
            }
        }
    }
}