package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Handle to connecting to the dtaabase
//Reading and writing from the datbase
public class DataSource{

  public static Connection connect(){
    String db_file= "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try{
      connection = DriverManager.getConnection(db_file);
      System.out.println("Connected!");

    }
    catch(SQLException e){
      e.printStackTrace();//Gives us a log of the code's execution path so far

    }
    

    return connection;
  }

  public static Customer getCustomer(String username){

    String sql= "SELECT * FROM Customers WHERE username= ?";
    Customer customer= null;

    try(Connection connection= connect(); 
    PreparedStatement statement= connection.prepareStatement(sql)){

      statement.setString(1,username);

      
      try (ResultSet rs= statement.executeQuery();){
        customer= new Customer(
          rs.getInt("id"),
          rs.getString("name"),
          rs.getString("username"),
          rs.getString("password"),
          rs.getInt("account_id")
        );
      }
  
    }
    catch(SQLException e){
      e.printStackTrace();
    }

    return customer;
  }

  public static Account getAccount(int accountID) {

    String sql = "SELECT * FROM Accounts WHERE id= ?";
    Account account = null;

    try (Connection connection = connect();
    PreparedStatement statement = connection.prepareStatement(sql)) {

      statement.setInt(1, accountID);

      
      try (ResultSet rs = statement.executeQuery();) {
        account = new Account(
            rs.getInt("id"),
            rs.getString("type"),
            rs.getDouble("balance"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return account;
  }
  public static void main(String[] args){
    Customer customer= getCustomer("ojamblinbx@ycombinator.com");
    Account account  = getAccount(10557);

    System.out.println(customer.getName());
    System.out.println(account.getBalance());
  }

}
