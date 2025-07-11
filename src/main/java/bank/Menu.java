package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import java.util.Objects;

public class Menu {



  private Scanner scanner;

  public static void main (String[] args){
    System.out.println("Welcome to the bank!");

    //Main is static method so doesnt have access to non static fields
    //Need instance of menu class to access scanner

    Menu menu= new Menu();
    menu.scanner= new Scanner(System.in);

    Customer customer= menu.authenticateUser();

    if (customer!=null){
      //Once customer logs in, it will load up account details 
      Account account= DataSource.getAccount(customer.getAccountID());//Create instance of account details

      menu.showMenu(customer, account);


    }

    


    menu.scanner.close();
  }

  private Customer authenticateUser(){
    System.out.println("Please enter username:");
    String username= scanner.next();
    System.out.println("Please enter password:");
    String password= scanner.next();

    Customer customer= null;

    try{
      customer= Authenticator.logIn(username,password);
    }
    catch(LoginException e){
      System.out.println(e.getMessage());
    }
    
    return customer;

  }

  private void showMenu(Customer customer, Account account){


    int selection=0;
    
    while (selection!=4 && customer.isAuthenticated()){

      System.out.println("==================================");
      System.out.println("Please select an option");

      System.out.println("1- Deposit");
      System.out.println("2- Withdraw");
      System.out.println("3- Check balance");
      System.out.println("4- Exit");
      System.out.println("==================================");

      selection= scanner.nextInt();
      double amount=0;

      switch(selection){

        case 1:
        System.out.println("How much would you like to desposit?");
        amount= scanner.nextDouble();
        account.deposit(amount);
        break;

        case 2:
          System.out.println("How much would you like to withdraw?");
          amount = scanner.nextDouble();
          account.withdraw(amount);
          break;

        case 3:
          System.out.println("Current balance:"+account.getBalance());
          break;

        case 4:
        Authenticator.logOut(customer);
        System.out.println("Goodbye!");

        default:
        System.out.println("Invalid option. Please try again.");
      }

    }

  }
}


