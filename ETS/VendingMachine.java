import java.util.ArrayList;
import java.util.Scanner;
class VendingMachine {
    private final ArrayList<Coffee> coffee;
    private final ArrayList<String> transactionLog;
    private final Scanner sc;
    private int userBalance; 
    VendingMachine(Scanner sc){
        this.coffee = new ArrayList<>();
        this.transactionLog = new ArrayList<>();
        this.sc = sc;
        this.userBalance = 0; }
    public void addCoffee(String name, int price, int stock){
        coffee.add(new Coffee(name, price, stock));}
    public void showMenu(){
        System.out.println("====================");
        for(int i = 0; i < coffee.size(); i++){
            Coffee c = coffee.get(i);
            System.out.println((i+1) + ". " + c.getName() + " - Rp" + c.getPrice() + " (Stock: " + c.getStock() + ")");
        }
        System.out.println("===============================");
        System.out.println("Saldo Anda: Rp" + userBalance);
    }
    public void topUpBalance(){
        System.out.print("Jumlah tambah saldo: Rp");
        int amount = sc.nextInt();
        sc.nextLine();
        userBalance += amount;
        System.out.println("Saldo sekarang: Rp" + userBalance);
    }
    public void selectProduct(){
        showMenu();
        System.out.print("Pilih nomor: ");
        int choice = sc.nextInt();
        sc.nextLine();
        Coffee selected = coffee.get(choice - 1);
        if(selected.getStock() <= 0){
            System.out.println("Produk " + selected.getName() + " habis");
            transactionLog.add(selected.getName() + " - Produk habis");
            return;
        }
        System.out.println("Anda memilih: " + selected.getName());
        System.out.println("Harga: Rp" + selected.getPrice());
        System.out.println("Saldo Anda: Rp" + userBalance);
        if(userBalance < selected.getPrice()){
            System.out.println("Saldo tidak cukup");
            return;
        }
        userBalance -= selected.getPrice();
        selected.reduceStock();
        System.out.println("Silakan ambil " + selected.getName());
        System.out.println("Sisa saldo: Rp" + userBalance);
        transactionLog.add(selected.getName() + " - Rp" + selected.getPrice());
    }
    public void showTransactionLog(){
        System.out.println("\n===== LOG =====");
        if(transactionLog.isEmpty()){
            System.out.println("Belum ada transaksi.");
        } else {
            for(String log : transactionLog){
                System.out.println(log);
            }
        }
        System.out.println("===========================");
    }
}

