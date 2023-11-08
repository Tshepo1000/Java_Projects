import java.io.BufferedReader;
import java.io.InputStreamReader;

//interface for my methods

@FunctionalInterface
interface ATM
{
    void inputPin();
}

class Pin implements ATM
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private double budgetAccountBalance = 15000.00;
    private double savingsAccountBalance = 3700.00;

    int opt1 = 1, opt2 = 2, opt3 = 3, opt4 = 4, opt5 = 5;

    private double savingsAccount()
    {
        System.out.println("Savings Account Available Balance: R" + savingsAccountBalance);
        return this.savingsAccountBalance;
    }

    private double budgetAccount()
    {
        System.out.println("Budget Account Available Balance: R" + budgetAccountBalance);
        return this.budgetAccountBalance;
    }
    public void inputPin(){
        System.out.println("Welcome to Tshepo's QuickStop ATM");
        System.out.println("Please insert card, and enter your pin to continue.");

        //for user input

        int attempts = 1;
        String userPin;
        int userPinNo;
        System.out.print("Enter your pin to continue: ");

        //handle exceptions for incorrect user input
        try
        {
            userPinNo = Integer.parseInt(br.readLine());

            //check if user entered correct pin
            if(userPinNo != 1234)
            {
                while (userPinNo != 1234)
                {
                    attempts++;
                    System.out.print("Incorrect Pin. Enter Correct Pin: ");
                    userPinNo = Integer.parseInt(br.readLine());

                    if(attempts == 3)
                    {
                        System.out.println("Account Blocked.");
                        exitAtm();
                        break;
                    }
                }
            }
            else
            {
                System.out.println("PIN OK. Chose the options below.");
                //display options
                displayOptions();
            }
        }

        catch (Exception e)
        {
            System.out.println("PIN has to be numbers only.");
        }
    }

    private void displayOptions()
    {
        int userInputOpt;

        System.out.println(
                opt1 + ". Withdrawal\n" +
                        opt2 + ". Check Balance\n" +
                        opt3 + ". Transfer Money\n" +
                        opt4 + ". Deposit Money\n" +
                        opt5 + ". Exit"
        );
        System.out.println();
        System.out.print("Select an option: ");

        try
        {
            userInputOpt = Integer.parseInt(br.readLine());

            if (userInputOpt == opt1 | userInputOpt == opt2 | userInputOpt == opt3 | userInputOpt == opt4 | userInputOpt == opt5)
            {
                switch (userInputOpt)
                {
                    case 1:
                        withdrawal();
                        break;
                    case 2:
                        checkBalance();
                        break;

                    case 3:
                        transferMoney();
                        break;

                    case 4:
                        depositMoney();
                        break;

                    case 5:
                        exitAtm();
                        break;

                    default:
                        System.out.println("Please select one of the opions above.");
                }
            }
            else
            {
                    System.out.println("Please enter correct information to continue");
                    options();
            }

        }
        catch (Exception e)
        {
            System.out.println("Enter a valid option.");
            displayOptions();
        }
    }

    //withdraw methods
    private void withdrawal()
    {
        savingsAccount();
        try
        {
            System.out.print("Withdrawal Amount: R");
            double withdrawalAmount = Double.parseDouble(br.readLine());
            if (withdrawalAmount > this.savingsAccountBalance)
            {
                System.out.println("Insufficient funds.");
            }
            else
            {
                this.savingsAccountBalance = this.savingsAccountBalance - withdrawalAmount;
                System.out.println("Withdrawal Successful");
                System.out.println("Available Balance: R" + this.savingsAccountBalance);
            }
            options();
        }
        catch (Exception e)
        {
            System.out.println("Enter correct amount in numbers.");
            options();
        }
    }

    private void checkBalance()
    {
        System.out.println(opt1 + ". Savings Account \n" + opt2 + ". Budget Account");

        try
        {
            System.out.print("Select an option: ");
            int typeAccountBalance = Integer.parseInt(br.readLine());

            switch (typeAccountBalance)
            {
                case 1:
                    savingsAccount();
                    options();
                    break;

                case 2:
                    budgetAccount();
                    options();
                    break;

                default:
                    System.out.println("Select a valid option.");
                    options();
            }
        }
        catch (Exception e)
        {
            System.out.println("Please Select an option in numbers.");
            options();
        }


    }

    private void transferMoney()
    {
        System.out.println("From:  \n" + opt1 + " .Savings \n" + opt2 + " .Budget");
        try
        {
            System.out.print("Select an option: ");
            int userTransferOption = Integer.parseInt(br.readLine());
            double amount = 0;

            switch (userTransferOption)
            {
                case 1:
                    System.out.println("To Budget");
                    System.out.print("Amount: R");
                    amount = Double.parseDouble(br.readLine());
                    if (amount > this.savingsAccountBalance)
                    {
                        System.out.println("Insufficient funds. Lower transfer amount.");
                        options();
                    }
                    else
                    {
                    this.budgetAccountBalance = this.budgetAccountBalance + amount;
                    this.savingsAccountBalance = this.savingsAccountBalance - amount;
                    budgetAccount();
                    savingsAccount();
                    options();
                    }
                    break;

                case 2:
                    System.out.println("To Savings");
                    System.out.print("Amount: R");
                    amount = Double.parseDouble(br.readLine());

                    if(amount > this.budgetAccountBalance)
                    {
                        System.out.println("Insufficient funds. Lower transfer amount.");
                        options();
                    }
                    else
                    {
                        this.savingsAccountBalance = this.savingsAccountBalance + amount;
                        this.budgetAccountBalance = this.budgetAccountBalance - amount;
                        savingsAccount();
                        budgetAccount();
                        options();
                    }
                    break;

                default:
                    System.out.println("Select between the options provided");
                    options();
            }
        }
        catch (Exception e)
        {
            System.out.println("Select a valid option");
            options();
        }
    }

    private void depositMoney()
    {
        int accNumber;
        savingsAccount();
        System.out.print("Amount to Deposit: R");
        try
        {
            double amountDeposit = Double.parseDouble(br.readLine());
            System.out.println();

            if(amountDeposit > savingsAccount())
            {
                System.out.println("Insufficient funds. Lower deposit amount.");
                depositMoney();
            }
            else
            {
                System.out.print("Account Number to deposit into: ");
                accNumber = Integer.parseInt(br.readLine());
                this.savingsAccountBalance = this.savingsAccountBalance - amountDeposit;
                System.out.println("Deposit Successful");
                savingsAccount();
                options();
            }
        }
        catch (Exception e)
        {
            System.out.println("Enter a valid amount in numbers.");
            options();
        }
    }
    private void exitAtm()
    {
        System.out.println("Thank you for using QuickStop. Bye");
    }

    private void options()
    {
        char userOpt = 'y', userOpt2 = 'n';
        try
        {
            System.out.print("Choose another option? y/n: ");
            char c = br.readLine().toLowerCase().charAt(0);
            if (c == userOpt)
            {
                displayOptions();
            }
            else
            {
                if(c == userOpt2)
                    exitAtm();
            }
        }
        catch (Exception e)
        {
            System.out.println("Please select a valid option.");
            options();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        ATM atm = new Pin();
        atm.inputPin();

    }
}