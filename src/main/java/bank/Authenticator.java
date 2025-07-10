package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer logIn(String username, String password) throws LoginException{

    Customer customer= DataSource.getCustomer(username);
    if (customer==null){
      throw new LoginException("Username not found.");
    }


    //== compares memory locations while .equals compares objects
    //So the latter is safer
    if (password.equals(customer.getPassword())){
      customer.setAuthenticated(true);
      return customer;
    }

    else{
      throw new LoginException("Incorrect password.");
    }

  }

  public static void logOut(Customer customer){
    customer.setAuthenticated(false);
  }

}
