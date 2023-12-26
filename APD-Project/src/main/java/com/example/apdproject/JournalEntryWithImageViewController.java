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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JournalEntryWithImageViewController extends GridPane {

    private final Label title;
    private final ImageView entryImage;
    private final Label entryText;
    private final Button editButton;
    private final Button deleteButton;

    private JournalEntry model;
    private final MainApplication app;
    private final Stage stage;

    public JournalEntryWithImageViewController(JournalEntry m, MainApplication app, Stage stage) {
        this.app = app;
        setModel(m);
        this.stage = stage;


        setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setStyle("-fx-border-color: black; -fx-border-width: 1;");


        title = new Label(model.getTitle());
        title.setFont(Font.font("System Bold", 18));
        setHalignment(title, HPos.CENTER);
        setValignment(title, VPos.CENTER);
        add(title, 0, 0);


        entryImage = new ImageView(new Image("file:" + model.getImagePath()));
        entryImage.setFitHeight(179.0);
        entryImage.setFitWidth(291.0);
        entryImage.setPreserveRatio(true);
        setHalignment(entryImage, HPos.CENTER);
        setValignment(entryImage, VPos.CENTER);
        add(entryImage, 0, 1);


        entryText = new Label(model.getDescription());
        entryText.setAlignment(Pos.CENTER);
        entryText.setWrapText(true);
        add(entryText, 0, 2);


        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);

        editButton = new Button("Edit");

        editButton.setOnAction(this::handleEditButton);
        buttonGrid.add(editButton, 0, 0);


        deleteButton = new Button("Delete");

        deleteButton.setOnAction(this::handleDeleteButton);
        buttonGrid.add(deleteButton, 1, 0);


        add(buttonGrid, 0, 3);
    }

    public void handleEditButton(ActionEvent actionEvent) {
        app.editEntry(model.getId(), stage);
    }

    public void handleDeleteButton(ActionEvent actionEvent) {
        app.deleteEntry(model.getId());
    }

    public JournalEntry getModel() {
        return model;
    }

    public void setModel(JournalEntry model) {
        this.model = model;
    }
}
