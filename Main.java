/*
    Chapter 10 Problem 9
    9. BankAccount and SavingsAccount Classes
 */

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
         // Variables
        int userChoice;

        // Greeting
        greeting();

        // Create a SavingAccount object
        SavingsAccount savingsAccount = new SavingsAccount(readDoubleValue("Balance"), readDoubleValue("annual interest rate"));

        do
        {


            // Read user choice
            userChoice = menu();

            // Display chosen option
            displayOption(userChoice, savingsAccount);

        } while(userChoice != 4);

    }
    // Greeting Method
    public static void greeting()
    {
        JOptionPane.showMessageDialog(null, "This is the RussJR08 Bank of Murica Software.");
    }

    // Close the Program
    public static void closeProgram()
    {
        JOptionPane.showMessageDialog(null, "Program complete. Now closing.");
        System.exit(0);
    }

    // Read double value
    public static double readDoubleValue(String aspect)
    {
        return Double.parseDouble(JOptionPane.showInputDialog("Enter the " + aspect + " for your savings account: "));
    }

    // Menu
    public static int menu()
    {
        return Integer.parseInt(JOptionPane.showInputDialog("      MENU \n-------------------" +
                                                 "\nType 1 to make a Deposit" +
                                                 "\nType 2 to make a withdraw" +
                                                 "\nType 3 to see your balance" +
                                                 "\nType 4 to exit"));



    }

    // Display Option
    public static void displayOption(int choice, SavingsAccount savingsAccount)
    {
        switch (choice)
        {
            // Deposit
            case 1: double deposit = Double.parseDouble(JOptionPane.showInputDialog("Enter Deposit Amount: "));
            savingsAccount.deposit(deposit);
            break;

            // Withdraw
            case 2: double withdrawal = Double.parseDouble(JOptionPane.showInputDialog("Enter withdraw Amount: "));
            savingsAccount.withdraw(withdrawal);
            break;

            // show Balance
            case 3: JOptionPane.showMessageDialog(null, "Your current balance is " + savingsAccount.getBalance());
            break;

            case 4: closeProgram();
        }
    }


}
