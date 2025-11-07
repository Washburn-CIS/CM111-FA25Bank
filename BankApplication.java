import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        b1.setHolderName("bill");
        b1.setNumber(4236);
        b1.deposit(4.40);
        b2.setHolderName("jill");
        b2.setNumber(5642);
        b2.deposit(30);

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the bank app!");
        while(true) {
            System.out.println("Choose an option:");
            System.out.println("1. get balance");
            System.out.println("2. make deposit");
            System.out.println("3. make withdraw");
            System.out.println("4. quit");
            System.out.print("\nEnter choice: ");
            String choice = input.nextLine();
            switch(Integer.parseInt(choice)) {
                case 1:{
                    System.out.print("Enter Account Number: ");
                    int acct = Integer.parseInt(input.nextLine());
                    if(acct == b1.getNumber()) {
                        System.out.println("Balance: $" + b1.getBalance());
                    } else {
                        System.out.println("Balance: $" + b2.getBalance());
                    }
                    break;
                } case 2:{
                    System.out.print("Enter Account Number: ");
                    int acct = Integer.parseInt(input.nextLine());
                    BankAccount b;
                    if(acct == b1.getNumber()) {
                        b = b1;
                    } else {
                        b = b2;
                    }

                    System.out.println("Enter deposit ammount (in dollars)");
                    double ammount = Double.parseDouble(input.nextLine());
                    b.deposit(ammount);
                    System.out.println("done!");
                    break;
                } case 3:
                    break;
                case 4:
                    System.out.println("bye!");
                    System.exit(1);
            }
        }
    }
}