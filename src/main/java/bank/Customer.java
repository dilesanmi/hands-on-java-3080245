package bank;
import java.util.Objects;

public class Customer {

  //Customer Fields
  private int ID, accountID;
  private String name, username, password;
  boolean authenticated;
  
  public boolean isAuthenticated() {
    return authenticated;
  }
  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }
  public Customer(int iD, String name, String username, String password, int accountID) {
    ID = iD;
    this.accountID = accountID;
    this.name = name;
    this.username = username;
    this.password = password;
    this.authenticated= false;
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
