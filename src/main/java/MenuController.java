import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* Charlene Creighton
* Copyright September 29, 2021,
* Simulation Bank Account App
 */

// This controller controls front page allowing user or administrator to access accounts
public class MenuController {
    final String AdminPSWD = "password";
    public PasswordField AdminLogin;
    public TextField Message;
    public Button LoginBTN;
    int check = 0;
    File loadFile;
    FileChooser load = new FileChooser();
    Stage stage = new Stage();
    Scanner input;

    public void ExitPressed() {
        System.exit(0);
    }

    public void ViewPressed() throws IOException {
        loadFile = load.showOpenDialog(stage);
        Desktop.getDesktop().open(loadFile);
    }

    public void CreateAccountPressed() throws IOException {
        new MultipleScenes(ViewScenes.RegisterPage);
    }

    public void LoginPressed() throws IOException {
        new MultipleScenes(ViewScenes.LoginPage);

    }

    public void AdminLoginEntered() throws IOException {

        if (check == 1) {
            Message.setText("You have two more attempts to enter the password");
        }
        else if (check == 2) {

            Message.setText("Program will terminate if next password attempt is incorrect");
        }

        else if (check == 3)
            System.exit(0);

        if (AdminLogin.getText().equals(AdminPSWD)) {
            Message.setText("Hello Administrator, press edit when Account info is updated");
            ChangeScenes.Change(ViewScenes.AdminPage);
        }

        else {
            Message.setText("Invalid Password");
            check++;
        }
    }

    public void LoadUsersPressed() throws IOException {
        loadFile = load.showOpenDialog(stage);
        input = new Scanner(new File(loadFile.getAbsolutePath()));

        int myCheck = 0;
        char[] newText;
        StringBuilder fileText = new StringBuilder();
        while (input.hasNext()) {
            fileText.append(input.nextLine());
            fileText.append("\n");
        }

        int start = 0, x = 0;
        newText = fileText.toString().toCharArray();

        while (x < newText.length) {
            Users call = new Users();
            double bal;
            StringBuilder accountNum = new StringBuilder(), address = new StringBuilder();
            StringBuilder email = new StringBuilder(), fName = new StringBuilder();
            StringBuilder lName = new StringBuilder(), social = new StringBuilder();
            StringBuilder pWord = new StringBuilder(), uName = new StringBuilder();

            if (newText[x] == '-') {
                x += 28;
                myCheck = 1;
                start = x;
            }

            if (myCheck == 1) {
                x = start + 11;
                while (newText[x] != '\n') {
                    accountNum.append(newText[x]);
                    x++;
                }
                x+=7;
                call.setAccountNumber(accountNum.toString());

                while (newText[x] != ' ') {
                    fName.append(newText[x]);
                    x++;
                }
                call.setFirstName(fName.toString());
                x++;

                while (newText[x] != '\n') {
                    lName.append(newText[x]);
                    x++;
                }
                call.setLastName(lName.toString());
                x+=11;

                while (newText[x] != '\n') {
                    uName.append(newText[x]);
                    x++;
                }
                call.setUserName(uName.toString());
                x+= 11;

                while (newText[x] != '\n') {
                    pWord.append(newText[x]);
                    x++;
                }
                call.setPassWord(pWord.toString());
                x+= 9;

                while (newText[x] != '\n') {
                    social.append(newText[x]);
                    x++;
                }
                call.setSocial(social.toString());
                x+= 8;

                while (newText[x] != '\n') {
                    email.append(newText[x]);
                    x++;
                }
                call.setEmailAddress(email.toString());
                x+= 10;

                while (newText[x] != '\n') {
                    address.append(newText[x]);
                    x++;
                }
                call.setAddress(address.toString());
                x+= 9;

                StringBuilder balance = new StringBuilder();
                while (newText[x] != '\n') {
                    balance.append(newText[x]);
                    x++;
                }

                bal = Double.parseDouble(balance.toString());
                call.setBalance(bal);
                call.recentDep = 0;
                call.recentWith = 0;
                myCheck = 0;
                BankData.accountHolders.add(call);
            }
            x++;
        }
    }

}
