import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        b1.setHolderName("bill");
        b1.deposit(4.40);
        b2.setHolderName("jill");
        b2.deposit(30);

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the bank app!");
        while(true) {
            System.out.println("Choose an option:");
            System.out.println("1. get balance");
            System.out.println("2. make deposit");
            System.out.println("3. make withdraw");
            System.out.println("4. quit");

            String choice = input.nextLine();
            switch(Integer.parseInt(choice)) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("bye!");
                    System.exit(1);
            }
        }
    }
}