package bank;
import java.util.Objects;

public class Customer {

  //Customer Fields
  private int ID, accountID;
  private String name, username, password;

  public Customer(int iD, int accountID, String name, String username, String password) {
    ID = iD;
    this.accountID = accountID;
    this.name = name;
    this.username = username;
    this.password = password;
  }
  //Getters and setters
  public int getID() {
    return this.ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getAccountID() {
    return this.accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  

}
