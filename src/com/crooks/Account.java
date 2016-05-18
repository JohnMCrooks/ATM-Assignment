package com.crooks;

/**
 * Created by johncrooks on 5/18/16.
 */
public class Account {
    String name;
    double balance = 100;

    public Account() {
    }

    public void setName(){
        System.out.println("Who are we serving today?");
        String nameinput = Main.scanner.next();
        this.name = nameinput;
        System.out.println("Welcome " + name + ", It's been too long!");
    }

    public void atmSelection() throws Exception {
        System.out.println("What can we do for you today?\n [1] Check My Balance\n [2] Withdraw Funds\n [3] Cancel\n");

        //receive user input
        int selection = Main.scanner.nextInt();


        if (selection == 1){
            System.out.println("Your balance is $" + balance + ".\n");
            atmSelection();
        } else if( selection == 2){
            withdrawModule();
        } else if (selection == 3){
            System.out.println("Are you sure you want to cancel?  [y/n]");
            String confirm = Main.scanner.next();

            if (confirm.equalsIgnoreCase("y")){
                System.out.println("Thank you and please come again");
            } else if(confirm.equalsIgnoreCase("n")){
                atmSelection();
            } else{
                throw new Exception("Invalid Input!");
            }

        } else{
            throw new Exception("That's not an option! Select option 1,2, or 3");
        }
    }

    public void withdrawModule() throws Exception {
        System.out.println("So, how much are you trying to withdraw?\n");
        String cashRequest = Main.scanner.next();

        //receive users request
        int temp = Integer.valueOf(cashRequest);

        //Check to make sure user has enough cash to make withdraw
        if (temp < balance && temp > 0){
            System.out.println("Your cash is in being ejected now, Don't spend it all in one place.\n");
            System.out.println("Old balance: " + balance + "\n");

            //update the balance
            this.balance = (balance - temp);
            System.out.println("New Balance: " + (balance) + "\n");
            atmSelection();
        } else { throw new Exception("Nice try, but you don't have that much!");
        }
    }

}
