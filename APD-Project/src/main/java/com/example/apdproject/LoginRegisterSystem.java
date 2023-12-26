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

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginRegisterSystem {
    private Map<String, User> Dataset = new HashMap<>();
    private User currentUser;

    public LoginRegisterSystem() {
        loadData();
    }

    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src//main//resources//com//example//apdproject//database.txt"))) {
            out.writeObject(Dataset);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src//main//resources//com//example//apdproject//database.txt"))) {
            Dataset = (Map<String, User>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //    returns true if credentials are correct and false otherwise.
    public boolean login(String userId, String password) {
        if (Dataset.containsKey(userId) && Dataset.get(userId).getPassword().equals(password)) {
            setCurrentUser(Dataset.get(userId));
            return true;
        }

        return false;
    }

    //    returns true if the userid is unique and false otherwise.
    public boolean register(String userId, String password) {
        if (Dataset.containsKey(userId)) {
            return false;
        } else {
            User user = new User(userId, password);
            Dataset.put(userId, user);
            setCurrentUser(Dataset.get(userId));
            saveData();
            return true;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
