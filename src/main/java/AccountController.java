import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/* Charlene Creighton
 * Copyright October 13, 2021,
 * Simulation Bank Account App
 */
public class AccountController
{
    public TextField CurrentUser;
    public Button RecWithdraw;
    public Button RecDeposit;
    public Button ViewBal;
    public Button Exit;
    public TextField MessageDisplay;
    public AnchorPane Anchor;
    int check = -1;

    public void DepositPressed() throws IOException
    {
        new MultipleScenes(ViewScenes.Deposit);
    }

    public void WithdrawPressed() throws IOException
    {
        new MultipleScenes((ViewScenes.Withdrawal));
    }

    public void RecentDeposit()
    {
        String display;
        display = "Most Recent Deposit: " + "$" + BankData.accountHolders.get(BankData.curIndex).recentDep;
        MessageDisplay.setText(display);
    }

    public void RecentWithdrawal()
    {
        String display;
        display = "Most Recent Withdrawal: " + "$" + BankData.accountHolders.get(BankData.curIndex).recentWith;
        MessageDisplay.setText(display);
    }

    public void CheckBalance()
    {
        String display;
        display = "Current Balance: " + "$" + BankData.accountHolders.get(BankData.curIndex).getBalance();
        MessageDisplay.setText(display);
    }

    public void exitPressed()
    {
        MessageDisplay.clear();
        CurrentUser.clear();
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

    public void Displayed()
    {
        if (check == - 1)
        {
            String display;
            String fName;
            String lName;
            fName = BankData.accountHolders.get(BankData.curIndex).getFirstName();
            lName = BankData.accountHolders.get(BankData.curIndex).getLastName();
            display = "Welcome, " + fName + " " + lName + ", Make changes to your account here";

            CurrentUser.setText(display);
            check = 0;
        }
    }
}
