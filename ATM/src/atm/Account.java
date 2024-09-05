
package atm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
  protected int accountID;
    protected int balance;
    protected List<Transaction> transactions;

    public Account(int accountID, int balance) {
        this.accountID = accountID;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public int getID() {
        return accountID;
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void deposit(int miktar);

    public abstract void withdraw(int miktar);

    protected void addTransaction(String type, int miktar) {
        Transaction transaction = new Transaction(LocalDate.now(), type, miktar);
        transactions.add(transaction);
    }

 
}
