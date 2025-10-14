import java.util.ArrayList;
import java.util.Scanner;
class Coffee {
    private String name;
    private int price;
    private int stock; 

    Coffee(String name, int price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public void reduceStock(){
        if(stock > 0) stock--;
    }
}

