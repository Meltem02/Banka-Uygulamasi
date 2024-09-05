
package atm;

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        int secim ;
        do {
              System.out.println("Banka Hesap Yönetim Sistemi");
            System.out.println("1. Kısa Vadeli Hesap Oluştur");
            System.out.println("2. Uzun Vadeli Hesap Oluşturun");
            System.out.println("3. Özel Hesap Oluşturun");
            System.out.println("4. Cari Hesap Oluştur");
            System.out.println("5. Hesaba Para Yatırma");
            System.out.println("6. Bir Hesaptan Para Çekme");
            System.out.println("7. Sistem Tarihini Ayarla");
            System.out.println("8. Hesap Ayrıntılarını Göster");
            System.out.println("9. Tüm Hesapları Göster");
            System.out.println("0. Çıkış");
            System.out.print("Seçimini Giriniz: ");
             secim = scanner.nextInt();

            switch (secim ) {
                case 1:
                    createShortTermAccount(scanner, bank);
                    break;
                case 2:
                    createLongTermAccount(scanner, bank);
                    break;
                case 3:
                    createSpecialAccount(scanner, bank);
                    break;
                case 4:
                    createCurrentAccount(scanner, bank);
                    break;
                case 5:
                    depositToAccount(scanner, bank);
                    break;
                case 6:
                    withdrawFromAccount(scanner, bank);
                    break;
                case 7:
                    setSystemDate(scanner, bank);
                    break;
                case 8:
                    showAccountDetails(scanner, bank);
                    break;
                case 9:
                    showAllAccounts(bank);
                    break;
                case 0:
                    System.out.println("Programdan Cıkıs Yaptınız.. Hoşçakal!");
                    break;
                default:
                    System.out.println("Gecersiz Secim. Lütfen Tekrar Deneyin.");
            }

            System.out.println();
        } while (secim  != 0);

        scanner.close();
    }

    private static void createShortTermAccount(Scanner scanner, Bank bank) {
        System.out.print("ID giriniz: ");
        int accountID = scanner.nextInt();
        System.out.print("İlk bakiyeyi girin: ");
        int balance = scanner.nextInt();

        bank.createShortTermAccount(accountID, balance);
        System.out.println( accountID + "  ID ile kısa vadeli hesap oluşturuldu. ");
    }

    private static void createLongTermAccount(Scanner scanner, Bank bank) {
        System.out.print("ID Giriniz: ");
        int accountID = scanner.nextInt();
        System.out.print("İlk Bakiyeyi Giriniz : ");
        int balance = scanner.nextInt();

        bank.createLongTermAccount(accountID, balance);
        System.out.println( accountID +" ID ile uzun vadeli hesap oluşturuldu. " );
    }

    private static void createSpecialAccount(Scanner scanner, Bank bank) {
        System.out.print("ID Giriniz: ");
        int accountID = scanner.nextInt();
        System.out.print("İlk Bakiyeyi Giriniz : ");
        int balance = scanner.nextInt();

       bank.createSpecialAccount(accountID, balance);
        System.out.println(accountID + " ID ile özel hesap oluşturuldu. "  );
    }

    private static void createCurrentAccount(Scanner scanner, Bank bank) {
        System.out.print("ID Giriniz: ");
        int accountID = scanner.nextInt();
        System.out.print("İlk Bakiyeyi Giriniz : ");
        int balance = scanner.nextInt();

        bank.createCurrentAccount(accountID, balance);
        System.out.println(accountID + " ID ile cari hesap oluşturuldu. " );
    }

    private static void depositToAccount(Scanner scanner, Bank bank) {
         System.out.print("ID Giriniz: ");
        int accountID = scanner.nextInt();
        System.out.print("Yatırılacak parayı giriniz: ");
        int miktar = scanner.nextInt();

        bank.deposit(accountID, miktar);
        System.out.println(miktar + " TL " + accountID+ " ID'ye yatırıldı. " );
    }

    private static void withdrawFromAccount(Scanner scanner, Bank bank) {
       System.out.print("ID Giriniz: ");
        int accountID = scanner.nextInt();
        System.out.print("Çekilecek tutarı girin ");
        int miktar = scanner.nextInt();

        bank.withdraw(accountID, miktar);
        System.out.println(miktar + " TL " + accountID + "ID hesabından çekildi. " );
    }

    private static void setSystemDate(Scanner scanner, Bank bank) {
        System.out.print("Gün Girin: ");
        int day = scanner.nextInt();
        System.out.print("Ay Girin: ");
        int month = scanner.nextInt();
        System.out.print("Yıl Girin: ");
        int year = scanner.nextInt();

        bank.setSystemDate(day, month, year);
        System.out.println("Sistem tarihi şu şekilde ayarlandı: " + day + "." + month + "." + year);
    }

    private static void showAccountDetails(Scanner scanner, Bank bank) {
        System.out.print("ID girin:  ");
        int accountID = scanner.nextInt();

        bank.showAccount(accountID);
    }

    private static void showAllAccounts(Bank bank) {
        bank.showAllAccounts();
    }
  
    }

