package com.davidlapadula;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 5);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 0.45, 5);
        stockList.addStock(temp);

        temp = new StockItem("Orange", 1.50, 8);
        stockList.addStock(temp);

        System.out.println(stockList.toString());

        Basket davidBasket = new Basket("David");
        sellItem(davidBasket, "cake", 1);

        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    // Selling item, puts it in the basket
    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell this");
            return 0;
        }

        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }
}
