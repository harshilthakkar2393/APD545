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
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JournalEntryViewController extends GridPane {
    private final Label title;
    private final Label entryText;
    private final Button editButton;
    private final Button deleteButton;
    private final JournalEntry model;
    private final MainApplication app;
    private final Stage stage;

    public JournalEntryViewController(JournalEntry m, MainApplication app, Stage stage) {
        this.model = m;
        this.app = app;
        this.stage = stage;


        setPadding(new javafx.geometry.Insets(10));

        setHgap(10);
        setVgap(10);
        setStyle("-fx-border-color: black; -fx-border-width: 1;");
        RowConstraints a = new RowConstraints();
        a.setVgrow(Priority.NEVER);
        RowConstraints b = new RowConstraints();
        b.setVgrow(Priority.ALWAYS);
        RowConstraints c = new RowConstraints();
        c.setVgrow(Priority.NEVER);
        this.getRowConstraints().addAll(a, b, c);
        title = new Label(model.getTitle());
        title.setFont(Font.font("System Bold", 18));
        setHalignment(title, HPos.CENTER);
        setValignment(title, javafx.geometry.VPos.CENTER);
        title.setPrefHeight(30);

        add(title, 0, 0);


        entryText = new Label(model.getDescription());
        entryText.setAlignment(Pos.TOP_LEFT);
        entryText.setWrapText(true);
        add(entryText, 0, 1);


        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.setPrefHeight(25);

        setValignment(buttonGrid, VPos.BOTTOM);


        editButton = new Button("Edit");

        editButton.setOnAction(this::handleEditButton);
        buttonGrid.add(editButton, 0, 0);


        deleteButton = new Button("Delete");

        deleteButton.setOnAction(this::handleDeleteButton);
        buttonGrid.add(deleteButton, 1, 0);


        add(buttonGrid, 0, 2);
    }

    public void handleEditButton(ActionEvent actionEvent) {

        app.editEntry(model.getId(), stage);
    }

    public void handleDeleteButton(ActionEvent actionEvent) {
        app.deleteEntry(model.getId());
    }
}
