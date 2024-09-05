
package atm;

public class Special extends Account{
  private static final double MIN_BALANCE = 0;

    public Special(int accountID, int balance) {
        super(accountID, balance);
    }

    @Override
    public void deposit(int miktar) {
        balance += miktar;
      addTransaction("Deposit", miktar);
        System.out.println(accountID+ " ID hesabından" +miktar + " TL deposit yatırıldı. ");
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
}
