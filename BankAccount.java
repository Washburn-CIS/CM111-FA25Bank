public class BankAccount {
    private int balance;        // pennies
    private String holderName; 
    private int number;

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String newHolderName) {
        holderName = newHolderName;
    }

    public void setNumber(int newNumber) throws IllegalArgumentException {
        if(newNumber < 0) {
            throw new IllegalArgumentException();
        }
        number = newNumber;
    }

    public int getNumber() {
        return number;
    }

    /** Returns the balance of the account in dollars
     * 
     * @return
     */
    public double getBalance() {
        return (double)balance/100.0;
    }

    /** make withdraw in dollars */
    public void withdraw(double amount) {
        balance = balance - (int)(100*amount);
    }

    /** make deposit in dollars */
    public void deposit(double amount) {
        balance = balance + (int)(100*amount);
    }

}