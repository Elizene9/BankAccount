import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/* Charlene Creighton
 * Copyright October 13, 2021,
 * Simulation Bank Account App
 */

// This Class allows money to be withdrawn from an account provided that money is there
public class WithdrawalController {
    public Button DoneButton;
    public TextField MessageDisplay;
    public TextField amount;
    public TextField Message;
    int check = -1;

    public void Display() {
        if (check == - 1) {
            String display;
            String fName;
            String lName;
            fName = BankData.accountHolders.get(BankData.curIndex).getFirstName();
            lName = BankData.accountHolders.get(BankData.curIndex).getLastName();
            display = "Welcome, " + fName + " " + lName + ", Make changes to your account here";

            Message.setText(display);
            check = 0;
        }
    }

    public void WithdrawalEntered() {
        int q = BankData.curIndex;
        boolean valid = false;
        double digit = 0;
        try {

            digit = Double.parseDouble(amount.getText());
            valid = true;
        }

        catch(NumberFormatException e) {

            MessageDisplay.setText("Please enter a valid numerical value");
        }

        if (valid) {
            if (digit > 0 && BankData.accountHolders.get(q).getBalance() > digit) {
                BankData.accountHolders.get(q).setBalance(BankData.accountHolders.get(q).getBalance() - digit);
                BankData.accountHolders.get(q).recentWith = digit;
                MessageDisplay.setText("Withdrawal of $" + digit + " made");
            }
            else if (digit > 0 && BankData.accountHolders.get(q).getBalance() < digit) {
                MessageDisplay.setText("Not enough money in account to make a withdrawal of $" + digit);
            }

            else if (digit < 0 && BankData.accountHolders.get(q).getBalance() > digit) {
                MessageDisplay.setText("Must enter positive value");
            }

            else if (digit < 0 && BankData.accountHolders.get(q).getBalance() < digit) {
                MessageDisplay.setText("Must enter positive value\nNot enough money in account to make a withdrawal of $" + digit);
            }

            else if (digit == 0){

                MessageDisplay.setText("Nothing Withdrawn");
            }
        }
    }

    public void DonePressed() {
        MessageDisplay.clear();
        Stage stage = (Stage) DoneButton.getScene().getWindow();
        stage.close();
    }
}
