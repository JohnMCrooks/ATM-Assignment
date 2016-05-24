package com.crooks;

import java.util.HashMap;

/**
 * Created by johncrooks on 5/18/16.
 */
public class Account {
    static String name;
    double balance = 100;

    static private final String adminPass = "TIY2016";

    public Account() {
    }

    public void login() throws Exception {
        System.out.println("Would you like to login? [y/n]");
        String temp = Main.scanner.next();

        Main.accounts.put("john", 200.0);
        Main.accounts.put("alice", 100.0);
        Main.accounts.put("bob", 134.56);
        Main.accounts.put("charlie", 45.0);

        if (temp.equals("y")){
            while (!Main.logout) {
                setName();
                atmMenu();
            }
        }else {
            System.out.println("ATM Shutting Down...");
        }

    }

    public void setName(){


        System.out.println("Who are we serving today?");
        String nameInput = Main.scanner.next();
        this.name = nameInput;

        if (Main.accounts.containsKey(nameInput)){
            System.out.println("welcome " + nameInput + " you have a balance of : $" + Main.accounts.get(nameInput));
        }else if ((!Main.accounts.containsKey(nameInput))){
            System.out.println("It appears as though you don't have an account...\n if you open one with us We'll give you a few bucks to get you started.\n");
                Main.accounts.put(nameInput, 15.0);
                System.out.println("welcome " + nameInput + "!\n");
        }
    }

    public void atmMenu() throws Exception {
        System.out.println("What can we do for you today?\n [1] Check My Balance\n [2] Withdraw Funds\n [3] Close Account\n [4] Admin View \n [5] Sign off ");

        //receive user selection
        int selection = Main.scanner.nextInt();


        if (selection == 1){
            printBalance();
            atmMenu();
        } else if( selection == 2){
            withdrawModule();
        } else if (selection == 3){
            removeAccount();
        } else if (selection == 4){
            adminMenu();
        } else if (selection == 5){
            exitATM();
        }

        else{
            throw new Exception("That's not an option! Select option 1,2,3,4, or 5");
        }
    }

    public void printBalance() {
        System.out.println(name + ", Your balance is $" + Main.accounts.get(name) + ".\n");
    }


    public void withdrawModule() throws Exception {
        System.out.println("So, how much are you trying to withdraw?\n");
        String cashRequest = Main.scanner.next();

        //receive users request
        int temp = Integer.valueOf(cashRequest);
        double tempaccount = Main.accounts.get(name);

        //Check to make sure user has enough cash to make withdraw
        if ((double) temp < tempaccount && temp > 0){

            System.out.println("Your cash is in being ejected now, Don't spend it all in one place.\n");
            System.out.println("Old balance: " + tempaccount + "\n");

            //update the balance
            this.balance = (tempaccount - temp);
            System.out.println("New Balance: " + (balance) + "\n");
            Main.accounts.put(name,balance);
            atmMenu();

        } else { throw new Exception("Nice try, but you don't have that much!");
        }
    }

    public void adminMenu() throws Exception {
        System.out.println("Enter the Password");
        String temp = Main.scanner.next();
        if (temp.equals(adminPass)){
            System.out.println("current accounts include: " + Main.accounts);
            atmMenu();
        } else{
            System.out.println("you aren't allowed here");
            atmMenu();
        }

    }

    public void removeAccount() throws Exception {
        System.out.println("Are you sure you want to close your account? [y/n]");
        String confirm = Main.scanner.next();

        if (confirm.equalsIgnoreCase("y")){
            System.out.println("Alrighty, goodluck.");
            Main.accounts.remove(name);
            System.out.println(Main.accounts);
        }
        else if(confirm.equalsIgnoreCase("n")){
            atmMenu();
        }
        else{
            throw new Exception("Invalid Input!");
        }
    }


    public void exitATM() throws Exception {
        System.out.println("Are you sure you want to Sign out?  [y/n]");
        String confirm = Main.scanner.next();

        if (confirm.equalsIgnoreCase("y")){
            System.out.println("Thank you and please come again");
        } else if(confirm.equalsIgnoreCase("n")){
            login();
        } else{
            throw new Exception("Invalid Input!");
        }
    }

}
