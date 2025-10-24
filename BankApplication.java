public class BankApplication {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.setHolderName("bill");
        b1.deposit(4.40);
        System.out.println(b1.getBalance());
    }
}