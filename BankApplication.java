import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new BankAccount();
        accounts[0].setHolderName("bill");
        accounts[0].setNumber(4236);
        accounts[0].deposit(4.40);
        
        accounts[1] = new BankAccount();
        accounts[1].setHolderName("jill");
        accounts[1].setNumber(5642);
        accounts[1].deposit(30);
        
        accounts[2] = new BankAccount();
        accounts[2].setHolderName("phil");
        accounts[2].setNumber(1111);
        accounts[2].deposit(5000000);

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