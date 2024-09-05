
package atm;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ShortTerm extends Account {
      private static final double INTEREST_RATE = 0.17;
    private static final double MIN_BALANCE = 1000;

    public ShortTerm(int accountID, int balance) {
        super(accountID, balance);
    }

    @Override
    public void deposit(int miktar) {
        balance += miktar;
         addTransaction("Deposit", miktar);
        System.out.println( accountID+ " ID hesabından" +miktar + " TL deposit yatırıldı. " );
    }

    @Override
    public void withdraw(int miktar) {
        if (balance >= miktar) {
            balance -= miktar;
            addTransaction("Para çekme", miktar);
            System.out.println(accountID + " ID hesabından" +miktar + " TL para çekildi. ");
        } else {
            System.out.println(accountID + " ID hesabında yetersiz bakiye: ");
        }
    }

    public void calculateInterest() {
        long days = ChronoUnit.DAYS.between(transactions.get(transactions.size() - 1).getDate(), LocalDate.now());
        double interest = balance * INTEREST_RATE * days / 365;
        balance += interest;
        addTransaction("Faiz", (int) interest);
        System.out.println("Hesap Kimliğine eklenen faiz: " + accountID);
    }

}
