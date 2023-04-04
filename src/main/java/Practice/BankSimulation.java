package Practice;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount();

        BankTransaction[] transactions=new BankTransaction[]{
          new BankTransaction(bankAccount,true,500),
                new BankTransaction(bankAccount,false, 800),
                new BankTransaction(bankAccount,true, 300)
        };

        Thread[] threads=new Thread[transactions.length];

        for(int i=0;i< transactions.length;i++){
            threads[i]=new Thread(transactions[i]);
            threads[i].start();
        }

        for(Thread t:threads){
           try{
               t.join();
           }catch (InterruptedException ie){
               ie.printStackTrace();
            }
        }

        System.out.println(bankAccount.getCurrentBalance());



    }
}
