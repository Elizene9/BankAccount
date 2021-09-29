import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/* Charlene Creighton
 * Copyright September 29, 2021,
 * Simulation Bank Account App
 */

// Allows user to login if correct credentials are used
public class LoginPageController {
    public TextField Username;
    public TextField Password;
    public Button LoginBTN;
    public Button exitButton;
    public TextField Validation;

    public void exitPressed() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void loginPressed() throws IOException {
        int index = -5;
        int check = -1;
        for (int i = 0; i < BankData.accountHolders.size(); i++) {
            System.out.println(BankData.accountHolders.get(0).getUserName());
            if (Username.getText().equals(BankData.accountHolders.get(i).getUserName()) && Password.getText().equals(BankData.accountHolders.get(i).getPassWord())) {
                check = 1;
                index = i;
                break;
            }
        }
        if (check == 1) {
            BankData.curIndex = index;
            new MultipleScenes(ViewScenes.Account);
            Stage stage = (Stage) LoginBTN.getScene().getWindow();
            stage.close();
        }
        else {
            Validation.setText("INCORRECT LOGIN INFORMATION");
        }
    }
}
