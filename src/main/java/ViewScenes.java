/* Charlene Creighton
 * Copyright October 13, 2021,
 * Simulation Bank Account App
 */

// This enum allows scene switching
public enum ViewScenes {

    // Allows scenes to be switched upon access to this class
    Menu("Menu.fxml"),
    LoginPage("LoginPage.fxml"),
    Account("Account.fxml"),
    RegisterPage("RegisterPage.fxml"),
    Deposit("Deposit.fxml"),
    Withdrawal("Withdrawal.fxml"),
    AdminPage("AdminPage.fxml");

    // Get file to be opened
    public String file;
    ViewScenes(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
