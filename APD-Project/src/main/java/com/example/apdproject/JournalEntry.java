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

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private int id;
    private String title;
    private String description;
    private String imagePath;

    public JournalEntry(String title, String description, String imagePath) {
        setTitle(title);
        setDescription(description);
        setImagePath(imagePath);
    }

    public JournalEntry(int id, String title, String description, String imagePath) {
        setId(id);
        setTitle(title);
        setDescription(description);
        setImagePath(imagePath);
    }

    public JournalEntry() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
