import java.util.*;

class Account {
    String name, accNo, accType;
    double balance;
    Scanner sc = new Scanner(System.in);

    void open() {
        System.out.print("Name: "); name = sc.nextLine();
        System.out.print("Account No: "); accNo = sc.nextLine();
        System.out.print("Type (Savings/Current): "); accType = sc.nextLine();
        System.out.print("Initial Balance: "); balance = sc.nextDouble();
        sc.nextLine(); // clear buffer
    }

    void deposit() {
        System.out.print("Deposit Amount: ");
        balance += sc.nextDouble();
        sc.nextLine(); // clear buffer
    }

    void withdraw(double amt) {
        if (amt > balance) System.out.println("Insufficient balance!");
        else balance -= amt;
    }

    void show() {
        System.out.println(name + " | " + accNo + " | " + accType + " | Balance: " + balance);
    }
}

class SavAcct extends Account {
    void addInterest() {
        System.out.print("Years: "); int y = sc.nextInt();
        balance *= Math.pow(1.05, y); // 5% compound interest
        System.out.println("Interest added!");
    }
}

class CurAcct extends Account {
    final double MIN_BAL = 5000, PENALTY = 500;

    @Override
    void withdraw(double amt) {
        if (amt > balance) System.out.println("Insufficient balance!");
        else {
            balance -= amt;
            if (balance < MIN_BAL) {
                balance -= PENALTY;
                System.out.println("Below minimum! Penalty charged.");
            }
        }
    }
}

public class prog5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Savings  2. Current → ");
        int ch = sc.nextInt();
        sc.nextLine(); // clear buffer

        Account acc = (ch == 1) ? new SavAcct() : new CurAcct();
        acc.open();

        while (true) {
            System.out.println("\n1.Deposit 2.Withdraw 3.Show 4.Interest 5.Exit");
            System.out.print("Choice: ");
            int c = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (c) {
                case 1:
                    acc.deposit();
                    break;
                case 2:
                    System.out.print("Withdraw Amount: ");
                    acc.withdraw(sc.nextDouble());
                    sc.nextLine(); // clear buffer
                    break;
                case 3:
                    acc.show();
                    break;
                case 4:
                    if (acc instanceof SavAcct) {
                        SavAcct s = (SavAcct) acc;
                        s.addInterest();
                    } else {
                        System.out.println("No interest for Current Account!");
                    }
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    sc.close();
            }
        }
    }
}