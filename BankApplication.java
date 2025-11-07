import java.util.Scanner;

public class BankApplication {

    public static final int NUM_ACCOUNTS = 3;
    public static final String ACCOUNT_DATA = "bill,4236,4.40\njill,5642,4.40\nphil,-1111,5000000";

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[NUM_ACCOUNTS];

        String[] lines = ACCOUNT_DATA.split("\n");

        if(lines.length != NUM_ACCOUNTS) {
            System.out.println("Wrong number of accounts");
            System.exit(1);
        }

        try {
            for(int i=0; i<NUM_ACCOUNTS; i++) {
                String[] tokens = lines[i].split(",");
                accounts[i] = new BankAccount();
                accounts[i].setHolderName(tokens[0]);
                accounts[i].setNumber(Integer.parseInt(tokens[1]));
                accounts[i].deposit(Double.parseDouble(tokens[2]));
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Account data is bad, fix it");
            System.exit(1);
        } catch(NumberFormatException e) {
            System.out.println("Account data is bad, fix it");
            System.exit(1);
        } catch(IllegalArgumentException e) {
            System.out.println("Account data is bad, fix it");
            System.exit(1);
        }
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
                    for(int i=0; i<accounts.length; i++) {
                        if(acct == accounts[i].getNumber()) {
                            System.out.println("Balance: $" + accounts[i].getBalance());
                        } 
                    }
                    break;
                } case 2:{
                    System.out.print("Enter Account Number: ");
                    int acct = Integer.parseInt(input.nextLine());
                    BankAccount b = null;
                    for(int i=0; i<accounts.length; i++) {
                        if(acct == accounts[i].getNumber()) {
                            b = accounts[i];
                        } 
                    }
                    System.out.println("Enter deposit ammount (in dollars)");
                    double ammount = Double.parseDouble(input.nextLine());
                    b.deposit(ammount);
                    System.out.println("done!");
                    break;
                } case 3:{
                    System.out.print("Enter Account Number: ");
                    int acct = Integer.parseInt(input.nextLine());
                    BankAccount b = null;
                    for(int i=0; i<accounts.length; i++) {
                        if(acct == accounts[i].getNumber()) {
                            b = accounts[i];
                        } 
                    }
                    System.out.println("Enter withdraw ammount (in dollars)");
                    double ammount = Double.parseDouble(input.nextLine());
                    b.withdraw(ammount);
                    System.out.println("done!");
                    break;
                } case 4:
                    System.out.println("bye!");
                    System.exit(1);
            }
        }
    }
}