/* Charlene Creighton
 * Copyright September 29, 2021,
 * Simulation Bank Account App
 */

// This class holds the user's account information
public class Users {

    private String firstName;
    private String lastName;
    private String social;
    private String userName;
    private String passWord;
    private String emailAddress;
    private String address;
    private String AccountNumber;
    public double recentDep;
    public double recentWith;
    private double balance;

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getSocial() {
        return social;
    }

    public String getUserName() {
        return userName;
    }

    public void setAddress(String Address) {
        address = Address;
    }

    public void setEmailAddress(String EmailAddress) {
        emailAddress = EmailAddress;
    }

    public void setFirstName(String FirstName) {
        firstName = FirstName;
    }

    public void setLastName(String LastName) {
        lastName = LastName;
    }

    public void setPassWord(String PassWord) {
        passWord = PassWord;
    }

    public void setSocial(String Social) {
        this.social = Social;
    }

    public void setUserName(String UserName) {
        userName = UserName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double Balance) {
        balance = Balance;
    }
}
