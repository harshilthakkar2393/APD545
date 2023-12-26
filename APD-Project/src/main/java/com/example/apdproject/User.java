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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User implements Serializable {
    private String userId;
    private String password;
    private HashMap<Integer, JournalEntry> entries = new HashMap<>();

    public User(String userId, String password) {
        setUserId(userId);
        setPassword(password);
    }

    public User(String userId, String password, HashMap<Integer, JournalEntry> entries) {
        setUserId(userId);
        setPassword(password);
        setEntries(entries);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<JournalEntry> getEntries() {
        return (new ArrayList<>(entries.values()));
    }

    public void setEntries(HashMap<Integer, JournalEntry> entries) {
        this.entries = entries;
    }

    public JournalEntry getEntryById(int id) {
        return entries.get(id);
    }

    public void addEntry(JournalEntry e) {
        if (e.getId() <= 0) {
            if (getEntries().size() == 0) {
                e.setId(1);
            } else {
                e.setId(getEntries().get(entries.size()).getId()+1);
            }
        }
        entries.put(e.getId(), e);

    }

    public void editEntry(JournalEntry e) {

        if (!Objects.equals(entries.get(e.getId()).getTitle(), e.getTitle())) {
            entries.get(e.getId()).setTitle(e.getTitle());
        }
        if (!Objects.equals(entries.get(e.getId()).getDescription(), e.getDescription())) {
            entries.get(e.getId()).setDescription(e.getDescription());
        }
        if (!Objects.equals(entries.get(e.getId()).getImagePath(), e.getImagePath())) {
            if (e.getImagePath() != null && !e.getImagePath().isEmpty()) {
                entries.get(e.getId()).setImagePath(e.getImagePath());
            }
        }

    }

    public void deleteEntry(int id) {
        entries.remove(id);
    }
}
