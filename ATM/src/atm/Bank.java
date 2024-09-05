
package atm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank{
       private LocalDate currentDate;
    private List<Account> accounts;

    public Bank() {
        currentDate = LocalDate.of(2023, 5, 5);
        accounts = new ArrayList<>();
    }

    public void createShortTermAccount(int accountID, int balance) {
        if (balance >= 1000) {
            Account account = new ShortTerm(accountID, balance);
            accounts.add(account);
        } else {
           System.out.println("Kısa Vadeli hesap için minimum bakiye 1000 TL'dir");
        }
    }

    public void createLongTermAccount(int accountID,int balance) {
        if (balance >= 1500) {
            Account account = new LongTerm(accountID, balance);
            accounts.add(account);
        } else {
            System.out.println("Uzun Vadeli hesap için minimum bakiye 1500 TL'dir");
        }
    }

    public void createSpecialAccount(int accountID, int balance) {
        Account account = new Special(accountID, balance);
        accounts.add(account);
    }

    public void createCurrentAccount(int accountID, int balance) {
        Account account = new Current(accountID, balance);
        accounts.add(account);
    }

    public void deposit(int accountID, int miktar) {
        Account account = findAccountByID(accountID);
        if (account != null) {
            account.deposit(miktar);
        } else {
           System.out.println( accountID +" ID hesabı bulunmuyor ");
        }
    }

    public void withdraw(int accountID, int miktar) {
        Account account = findAccountByID(accountID);
        if (account != null) {
            account.withdraw(miktar);
        } else {
            System.out.println(  accountID +" ID hesabı bulunmuyor " );

        }
    }

    public void setSystemDate(int gun, int ay, int yil) {
        currentDate = LocalDate.of(gun,ay,yil);
    }

    public void showAccount(int accountID) {
        Account account = findAccountByID(accountID);
        if (account != null) {
              System.out.println("ID: " + accountID);
            System.out.println("Current Balance: " + account.getBalance() + " TL");
            System.out.println("Son İşlemler: ");
            List<Transaction> transactions = account.getTransactions();
            for (int i = transactions.size() - 1; i >= 0 && i >= transactions.size() - 5; i--) {
                Transaction transaction = transactions.get(i);
                System.out.println(transaction);
            }
        } else {
            System.out.println( accountID +" ID hesabı bulunamadı");
        }
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
           System.out.println("Hesap Bulunamadı");
        } else {
            System.out.println("Tüm Hesaplar:");
            for (Account account : accounts) {
                System.out.println("ID: " + account.getID());
                System.out.println("Current Balance: " + account.getBalance() + " TL");
                System.out.println();
            }
        }
    }

    private Account findAccountByID(int accountID) {
        for (Account account : accounts) {
            if (account.getID() == accountID) {
                return account;
            }
        }
        return null;
    }

}
