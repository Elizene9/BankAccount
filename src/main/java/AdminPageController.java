import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

/* Charlene Creighton
 * Copyright September 29, 2021,
 * Simulation Bank Account App
 */

// Administrator's page where user info can be viewed and saved to local files
public class AdminPageController {
    public AnchorPane Anchor;
    Stage stage = new Stage();
    File userFile;
    PrintWriter writer;

    @FXML
    public SplitMenuButton ViewUsers;
    public Button DoneButton;
    public TextField newEmail;
    public TextField Social;
    public TextField NewAddress;
    public TextField Message;
    public TextField fName;
    public TextField Address;
    public TextField Email;
    public TextField accountNum;
    public TextField lName;
    FileChooser dir = new FileChooser();
    int check = 0;
    String tempAddress;
    String tempEmail;
    String tempSocial;
    String oldAddress;
    String oldEmail;
    String oldSocial;
    boolean email = false, address = false, social = false;
    boolean undo = false;

    public void UpdateUsers() {

        if (check == 0 && BankData.accountHolders.size() != 0) {

            ViewUsers.getItems().clear();
            for (int i = 0; i < BankData.accountHolders.size(); i++) {
                String name = BankData.accountHolders.get(i).getLastName() + ", Account Number: " + BankData.accountHolders.get(i).getAccountNumber();

                MenuItem item = new MenuItem();

                item.setText(name);
                int finalTemp = i;
                item.setOnAction((event-> {
                    BankData.adminIndex = finalTemp;
                    fName.setText(BankData.accountHolders.get(BankData.adminIndex).getFirstName());
                    lName.setText(BankData.accountHolders.get(BankData.adminIndex).getLastName());
                    Address.setText(BankData.accountHolders.get(BankData.adminIndex).getAddress());
                    Email.setText(BankData.accountHolders.get(BankData.adminIndex).getEmailAddress());
                    accountNum.setText(BankData.accountHolders.get(BankData.adminIndex).getAccountNumber());

                }));

                ViewUsers.getItems().add(item);

            }

            tempAddress = BankData.accountHolders.get(BankData.adminIndex).getAddress();
            tempEmail = BankData.accountHolders.get(BankData.adminIndex).getEmailAddress();
            tempSocial = BankData.accountHolders.get(BankData.adminIndex).getSocial();
            oldAddress = BankData.accountHolders.get(BankData.adminIndex).getAddress();
            oldEmail = BankData.accountHolders.get(BankData.adminIndex).getEmailAddress();
            oldSocial = BankData.accountHolders.get(BankData.adminIndex).getSocial();
        }
        check = 1;

    }

    public void ViewUsersPressed() {

        Message.setText("Hello Administrator, press edit when Account info is updated");
    }

    public void EditUserPressed() {
        Message.setText("Hello Administrator, press edit when Account info is updated");
    }

    public void EditPressed() {
        Message.setText("Account # " + BankData.accountHolders.get(BankData.adminIndex).getAccountNumber() + " updated");

        if (social)
            BankData.accountHolders.get(BankData.adminIndex).setSocial(Social.getText());

        if (address)
            BankData.accountHolders.get(BankData.adminIndex).setAddress(NewAddress.getText());

        if (email)
            BankData.accountHolders.get(BankData.adminIndex).setEmailAddress(newEmail.getText());
        Email.setText(tempEmail);
        Address.setText(tempAddress);
        undo = false;
    }

    public void UndoPressed() {
        if (!undo) {
            BankData.accountHolders.get(BankData.adminIndex).setSocial(oldSocial);
            BankData.accountHolders.get(BankData.adminIndex).setAddress(oldAddress);
            BankData.accountHolders.get(BankData.adminIndex).setEmailAddress(oldEmail);
            Message.setText("Changes Undone: Account #" + BankData.accountHolders.get(BankData.adminIndex).getAccountNumber());
            Email.setText(oldEmail);
            Address.setText(oldAddress);
        }

        else
            Message.setText("Changes Already Undone");

        undo = true;
    }

    public void DonePressed() throws IOException {
        ChangeScenes.Change(ViewScenes.Menu);
    }

    public void newEmailPressed() {
        Message.setText("Hello Administrator, press edit when Account info is updated");
        email = true;
        tempEmail = newEmail.getText();
    }

    public void newSocialPressed() {
        social = true;
        Message.setText("Hello Administrator, press edit when Account info is updated");
        tempSocial = Social.getText();
    }

    public void newAddressPressed() {
        address = true;
        Message.setText("Hello Administrator, press edit when Account info is updated");
        tempAddress = NewAddress.getText();
    }

    public void SaveUsersPressed() throws IOException {
        
        dir.getExtensionFilters().clear();
            dir.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"));


        userFile = dir.showSaveDialog(stage);
            writer = new PrintWriter(userFile);

            for (int i = 0; i < BankData.accountHolders.size(); i++) {

                writer.write("User #" + (i + 1) + ": Information:\n");
                writer.write("----------------------------\n");
                writer.write("Account#: " + BankData.accountHolders.get(i).getAccountNumber());
                writer.write("\nName: " + BankData.accountHolders.get(i).getFirstName() + " " + BankData.accountHolders.get(i).getLastName());
                writer.write("\nUsername: " + BankData.accountHolders.get(i).getUserName());
                writer.write("\nPassword: " + BankData.accountHolders.get(i).getPassWord());
                writer.write("\nSocial: " + BankData.accountHolders.get(i).getSocial());

                writer.write("\nEmail: " + BankData.accountHolders.get(i).getEmailAddress());
                writer.write("\nAddress: " + BankData.accountHolders.get(i).getAddress());
                writer.write("\nBalance: " + BankData.accountHolders.get(i).getBalance());
                writer.write("\n\n");
            }
            writer.close();
        }

}
