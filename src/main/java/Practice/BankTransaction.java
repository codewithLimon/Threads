package Practice;

public class BankTransaction implements Runnable{

    private BankAccount bankAccount;
    private boolean isDeposit;
    private double trAmount;


    public BankTransaction(BankAccount bankAccount, boolean isDeposit, double trAmount) {
        this.bankAccount = bankAccount;
        this.isDeposit = isDeposit;
        this.trAmount = trAmount;
    }

    @Override
    public void run() {
        synchronized (bankAccount){
            if(isDeposit){
                bankAccount.deposit(trAmount);
            }else {
                bankAccount.withdraw(trAmount);
            }
        }
    }
}
