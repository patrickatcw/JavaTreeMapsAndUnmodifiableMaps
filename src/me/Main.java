package me;
//http://www.baeldung.com/java-treemap
//https://www.programcreek.com/java-api-examples/?class=java.util.Collections&method=unmodifiableMap
import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        //adding more cups
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        //new instance to make a Basket object
        Basket myBasket = new Basket("Patrick");
        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        //could do this for every item
        if(sellItem(myBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(myBasket, "ramen noodles", 5);  //ramen noodles not in list
        System.out.println(myBasket);

        sellItem(myBasket, "juice", 4);
        sellItem(myBasket, "cup", 12);
        sellItem(myBasket, "bread", 1);
        System.out.println(myBasket);

        System.out.println(stockList);

        //temp = new StockItem("pen", 1.12);
        //stockList.Items().put(temp.getName(), temp);
        stockList.Items().get("car").adjustStock(2000); //returning the item, or
        stockList.get("car").adjustStock(-1000);        //returning the get directly
        System.out.println(stockList);
        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }

    }

    //static selling method
    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {     //test
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {  //test not equal to 0
            basket.addToBasket(stockItem, quantity);
            return quantity;  //how many were effectively sold
        }
        return 0;
    }
}

