import java.util.Scanner;

public class BankAcc {

    private String AccNo;
    private String accHolderName;
    private double balance;

    public BankAcc(String AccNo, String accHolderName, double balance) {
        this.AccNo = AccNo;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            System.out.printf("Successfully deposited: %.2f\n", amt);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("Invalid withdrawal amt.");
        } else if (amt <= balance) {
            balance -= amt;
            System.out.printf("Successfully withdrew: %.2f\n", amt);
        } else {
            System.out.println("Insufficient balance, Withdrawal failed.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayAccount() {
        System.out.println("Account Details");
        System.out.println("Acc No      : " + AccNo);
        System.out.println("Acc Holder Name : " + accHolderName);
        System.out.printf("Current Balance     : %.2f\n", balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Acc No: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Acc Holder Name: ");
        String accHolder = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        BankAcc account = new BankAcc(accNo, accHolder, initialBalance);

        account.displayAccount();

        System.out.print("Enter amt to deposit: ");
        double depositAmt = sc.nextDouble();
        account.deposit(depositAmt);

        System.out.print("Enter amt to withdraw: ");
        double withdrawAmt = sc.nextDouble();
        account.withdraw(withdrawAmt);

        System.out.println("Final Acc Summary:");
        account.displayAccount();

        sc.close();
    }
}