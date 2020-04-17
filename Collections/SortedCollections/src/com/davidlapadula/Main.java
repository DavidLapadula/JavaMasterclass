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

        Basket basket = new Basket("Customer");
        sellItem(basket, "Cup", 100);
        sellItem(basket, "Juice", 10);

        removeItem(basket, "Cup", 40);

        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    // Selling item, puts it in the basket AND reserves the stock of the stock item via the stocklist class
    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell this");
            return 0;
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }

        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We do not sell this");
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }

        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }

}
