public abstract class BankAccount
{


    // Fields
    private double balance;             // Included in Constructor
    private double annualInterestRate;  // Included in Constructor
    private int numberOfDepositsThisMonth;
    private int numberOfWithdrawals;
    public double monthlyServiceCharges;

    // Constructors
    public BankAccount()
    {

    }
    public BankAccount(double balance, double annualInterestRate )
    {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.numberOfDepositsThisMonth=0;
        this.numberOfWithdrawals = 0;


    }
    // Methods
    //Deposit
    public void deposit(double depositAmount)
    {
        balance += depositAmount;
        numberOfDepositsThisMonth++;
    }
    // Withdraw
    public void withdraw(double withdrawAmount)
    {
        balance -=withdrawAmount;
        numberOfWithdrawals++;
    }
    // CalcInterest
    public void calcInterest()
    {
        // Use this formula
        double monthlyInterestRate = annualInterestRate / 12.0;
        double monthlyInterest = balance * monthlyInterestRate;
        balance+= monthlyInterest;
    }

    // monthly Process
    public void monthlyProcess()
    {
        balance -= getMonthlyServiceCharges();

        // calls the calcInterest() method
        calcInterest();

        // sets number of withdrawals, deposts and monthly service charge to 0
        numberOfWithdrawals = 0;
        numberOfDepositsThisMonth = 0;
        monthlyServiceCharges = 0;

    }

    // Getters and Setters
    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate)
    {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfDepositsThisMonth()
    {
        return numberOfDepositsThisMonth;
    }

    public void setNumberOfDepositsThisMonth(int numberOfDepositsThisMonth)
    {
        this.numberOfDepositsThisMonth = numberOfDepositsThisMonth;
    }

    public int getNumberOfWithdrawals()
    {
        return numberOfWithdrawals;
    }

    public void setNumberOfWithdrawals(int numberOfWithdrawals)
    {
        this.numberOfWithdrawals = numberOfWithdrawals;
    }

    public double getMonthlyServiceCharges()
    {
        return monthlyServiceCharges;
    }

    public void setMonthlyServiceCharges(double monthlyServiceCharges)
    {
        this.monthlyServiceCharges = monthlyServiceCharges;
    }
}
