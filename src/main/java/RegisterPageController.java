import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Random;

/* Charlene Creighton
 * Copyright September 29, 2021,
 * Simulation Bank Account App
 */

// This class allows user to register for an account in app
public class RegisterPageController {
    public TextField messageDisplay;
    public TextField fName;
    public TextField EmailAddress;
    public TextField LName;
    public TextField UserName;
    public TextField Social1;
    public TextField Social2;
    public TextField Address;
    public PasswordField password1;
    public PasswordField password2;
    public Button Register;
    public Button Close;
    Users call = new Users();
    int passwordCheck;
    int socialCheck;

    public void Social1Entered() {
        if (Social1.getText().equals(Social2.getText()))
            socialCheck = 1;

        else
            socialCheck = -1;

    }

    public void Social2Entered() {
        if (Social1.getText().equals(Social2.getText()))
            socialCheck = 1;

        else
            socialCheck = -1;
    }

    public void password1Entered() {

        if (password1.getText().equals(password2.getText()))
            passwordCheck = 1;

        else
            passwordCheck = -1;
    }

    public void password2Entered() {

        if (password1.getText().equals(password2.getText()))
            passwordCheck = 1;

        else
            passwordCheck = -1;
    }

    public void RegisterConfirmed() {
        messageDisplay.setText("Please Enter Account Information");
        StringBuilder account = new StringBuilder();
        Random rand = new Random();
        if (passwordCheck == 1 && socialCheck == 1) {

            for (int i = 0; i < 9; i++) {

                account.append(rand.nextInt(10));
            }

            call.setFirstName(fName.getText());
            call.setLastName(LName.getText());
            call.setAddress(Address.getText());
            call.setBalance(0);
            call.setEmailAddress(EmailAddress.getText());
            call.setUserName(UserName.getText());
            call.setSocial(Social1.getText());
            call.setPassWord(password1.getText());
            call.setAccountNumber(account.toString());
            BankData.accountHolders.add(call);
            messageDisplay.setText("Account Registered");
        }

        else if (passwordCheck == 1) {

            messageDisplay.setText("Social Security Numbers do not match");
        }

        else if (socialCheck == 1) {

            messageDisplay.setText("Passwords do not match");
        }

        else
            messageDisplay.setText("Social Security Numbers do not match\nPasswords do not match");

    }

    public void ClosePressed() {
        Stage stage = (Stage) Close.getScene().getWindow();
        stage.close();
    }
}
