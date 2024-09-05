
package atm;

import java.time.LocalDate;

public class Transaction {
 private LocalDate date;
    private String type;
    private int miktar;

    public Transaction(LocalDate date, String type, int miktar) {
        this.date = date;
        this.type = type;
        this.miktar = miktar;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public int getMiktar() {
        return miktar;
    }

    @Override
    public String toString() {
       return "Tarih: " + date + ",Yapılan İşlem: " + type + ", Miktar: " + miktar + " TL";
    }
}
