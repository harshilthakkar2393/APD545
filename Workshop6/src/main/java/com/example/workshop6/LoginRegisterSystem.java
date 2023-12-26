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

import java.util.HashMap;
import java.util.Map;

public class LoginRegisterSystem {
    Map<String,User> Dataset=new HashMap<>();

//    returns true if credentials are correct and false otherwise.
    public boolean login(String userId,String password)
    {
        return Dataset.containsKey(userId) && Dataset.get(userId).getPassword().equals(password);
    }

//    returns true if the userid is unique and false otherwise.
    public boolean register(String userId,String password)
    {
        if(Dataset.containsKey(userId))
        {
            return false;
        }
        else {
            User user=new User(userId,password);
            Dataset.put(userId,user);
            return true;
        }
    }
}
