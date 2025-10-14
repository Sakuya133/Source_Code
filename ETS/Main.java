import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VendingMachine machine = new VendingMachine(sc);
        machine.addCoffee("Es Teh", 3000, 5);
        machine.addCoffee("Air Putih", 2000, 3);
        machine.addCoffee("Kopi Hitam", 5000, 2);
        boolean running = true;
        while(running){
            System.out.println("\n1. Menu");
            System.out.println("2. Pilih Produk");
            System.out.println("3. Isi Saldo");
            System.out.println("4. Log Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            if(!sc.hasNextInt()){
                System.out.println("???");
                sc.nextLine();
                continue;
            }
            int option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:
                    machine.showMenu();
                    break;
                case 2:
                    machine.selectProduct();
                    break;
                case 3:
                    machine.topUpBalance();
                    break;
                case 4:
                    machine.showTransactionLog();
                    break;
                case 5:
                    running = false;
                    System.out.println("quit");
                    break;
                default:
                    System.out.println("???");
            }
        }
        sc.close();
    }
}