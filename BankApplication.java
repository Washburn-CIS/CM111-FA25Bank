import java.util.Scanner;
import java.io.*;


public class BankApplication {
    public static void main(String[] args) {
        String filename;

        if(args.length == 0) {
            filename = "accounts.txt"; // use default filename
        } else if(args.length == 1) {
            filename = args[0];  // use the filename provided through command-line
        } else {
            System.out.println("Error: only provide one (or zero) command-line argument(s)");
            System.exit(1);
            return;
        }

        File f = new File(filename);
        BankAccount[] accounts = null;

        try {
            Scanner fin = new Scanner(f);
            int numAccounts = Integer.parseInt(fin.nextLine());
            accounts = new BankAccount[numAccounts];
            for(int i=0; i<numAccounts; i++) {
                String[] tokens = fin.nextLine().split(",");
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
        } catch(FileNotFoundException e) {
            System.out.println("accounts.txt must exist for this to work!");
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
                    try {
                        PrintWriter fout = new PrintWriter(new File(filename));
                        fout.println(accounts.length);
                        for(int i=0; i<accounts.length; i++) {
                            fout.print(accounts[i].getHolderName());
                            fout.print(",");
                            fout.print(accounts[i].getNumber());
                            fout.print(",");
                            fout.println(accounts[i].getBalance());
                        }
                        fout.close();
                        System.out.println("bye!");
                    } catch(FileNotFoundException e) {
                        System.out.println("Error saving file... uh oh");
                    }
                    System.exit(1);
            }
        }
    }
}