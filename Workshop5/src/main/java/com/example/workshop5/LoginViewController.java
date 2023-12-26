/**********************************************
 Workshop 5
 Course:APD545 - Fall 2023
 Last Name:Thakkar
 First Name:Harshil
 ID:160431219
 Section:NBB
 This assignment represents my own work in accordance with Seneca Academic
 Policy.
 harshil
 Date:Nov 09, 2023
 **********************************************/
package com.example.workshop5;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

public class LoginViewController {

    @FXML
    private Button registerButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label welcomeMsg;

    public Button getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(Button registerButton) {
        this.registerButton = registerButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(Button loginButton) {
        this.loginButton = loginButton;
    }

    public Label getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(Label welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}


