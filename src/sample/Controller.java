package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;



public class Controller {


    @FXML private Text actiontargetlogin;
    @FXML private Text actiontargetcontactus;
    @FXML private Text  actiontargetregister;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordField2;

    @FXML
    private TextField emailField;

    @FXML
    private TextArea inquiryField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private Button closeButton;


    @FXML
    private ComboBox genderComboField;



    @FXML public void handleCloseButtonAction(ActionEvent event)
    {

        Stage stage = (Stage) closeButton.getScene().getWindow(); stage.close();
    }

    @FXML protected void handleLoginButtonAction(ActionEvent event) {
            if (logIn().equals("Success")) {
                setActionTarget(actiontargetlogin, Color.GREEN, "Log in Successful");
            }
        }


    @FXML protected void handleSubmitInquiryAction(ActionEvent event) {

        if (sendInquiry().equals("Success")) {
            setActionTarget(actiontargetcontactus, Color.GREEN, "Inquiry sent");
        }
    }

    @FXML protected void handleRegisterButtonAction(ActionEvent event) throws IOException {
        if (register().equals("Success")) {
            setActionTarget(actiontargetregister, Color.GREEN, "Registration Successful");

        }
    }

    @FXML protected void handleLoginPageAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Beyond The Stereotypes");
        primaryStage.setScene(new Scene(root, 300, 275));

    }

    @FXML protected void handleRegisterPageAction(ActionEvent event) throws IOException {

        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        primaryStage.setTitle("Beyond The Stereotypes");
        primaryStage.setScene(new Scene(root, 400, 350));

    }

    @FXML protected void handleInquiryPageAction(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("contact-us.fxml"));
        primaryStage.setTitle("Beyond The Stereotypes");
        primaryStage.setScene(new Scene(root, 350, 295));

    }

    private String logIn() {

        String status = "Success";
        String email = emailField.getText();
        String password = passwordField.getText();
        if(email.isEmpty() || password.isEmpty()) {
            setActionTarget(actiontargetlogin, Color.TOMATO, "Empty credentials");
            status = "Error";
        }
        else {
            //TODO: LOGIN LOGIC

        }

        return status;
    }

    private String register() {

        String status = "Success";
        String email = emailField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String password = passwordField.getText();
        String confirmPassword = passwordField2.getText();
        String gender = genderComboField.getSelectionModel().getSelectedItem().toString();


        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || gender.isEmpty()) {
            setActionTarget(actiontargetregister, Color.TOMATO, "All fields are required");
            status = "Error";
        }

        if(! (password.equals(confirmPassword))) {
            System.out.println(password);
            System.out.println(confirmPassword);

            setActionTarget(actiontargetregister, Color.TOMATO, "Passwords do not match");
            status = "Error";
        }

        else {
            //TODO: REGISTER LOGIC

        }

        return status;
    }


    private String sendInquiry() {

        String status = "Success";
        String email = emailField.getText();
        String inquiry = inquiryField.getText();
        if(email.isEmpty() || inquiry.isEmpty()) {
            setActionTarget(actiontargetcontactus, Color.TOMATO, "Email and Inquiry must be filled!");
            status = "Error";
        }
        else {
            //TODO: INQUIRY UPDATE LOGIC
            //PERSIST DATA SOMEWHERE

        }

        return status;
    }


    private void setActionTarget(Text action, Color color, String text) {
        action.setFill(color);
        action.setText(text);
    }





}
