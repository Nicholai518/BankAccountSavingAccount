import javax.swing.*;

public class SavingsAccount extends BankAccount
{
    // Fields
    private boolean isActive;  // inactive if balance falls below 25

    // Constructors
    public SavingsAccount(double balance, double annualInterestRate)
    {
        setBalance(balance);
        setAnnualInterestRate(annualInterestRate);
        setNumberOfDepositsThisMonth(0);
        setNumberOfWithdrawals(0);
        setAccountStatus();
    }
    // Methods
    public void setAccountStatus()
    {
        isActive = super.getBalance() > 25;
    }

    @Override
    public void withdraw(double withdrawAmount)
    {
        if(isActive)
        {
            super.withdraw(withdrawAmount);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"The savings account is currently inactive." +
                                                                     "\nPlease bring your balance above $25.00" +
                                                                     "\nCurrent Balance: " + super.getBalance() );
        }
    }
    @Override
    public void deposit(double deposit)
    {
        if(!isActive)
        {
            super.deposit(deposit);
            setAccountStatus();
        }
        else
        {
            super.deposit(deposit);
        }
    }

    @Override
    public void monthlyProcess()
    {
        if(super.getNumberOfWithdrawals()>4)
        {
            monthlyServiceCharges = (super.getNumberOfWithdrawals() - 4);
        }
        else
        {
            monthlyServiceCharges = 0;
        }

        if((super.getBalance() - monthlyServiceCharges) < 25)
        {
            isActive = false;
        }
        // Call the super class
        super.monthlyProcess();

    }

}
