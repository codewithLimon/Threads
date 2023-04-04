package Practice;

public class BankAccount {
    private double currentBalance=1000;

    public void deposit(double deposit_Balance){
        this.currentBalance+=deposit_Balance;
    }

    public void withdraw(double withdraw_Balance){
        this.currentBalance-=withdraw_Balance;
    }
    public double getCurrentBalance(){
        return this.currentBalance;
    }
}
