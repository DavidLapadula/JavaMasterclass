package com.davidlapadula;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // If item is already there, will return something different from item passed in
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If item was already there, just add quantity to current stock
            if(inStock != item) {
                item.adjustStock(inStock.availableQuantity());
            }

            // If already exists put() will override item that is already there
            list.put(item.getName(), item);

            return item.availableQuantity();
        }
        return 0;
    }

    public StockItem get(String item) {
        return list.get(item);
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if (
            (inStock != null) &&
            (quantity > 0)
        ) {
            inStock.finalizeStock(quantity);
            return quantity;
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) &&  (quantity > 0)) {
            return inStock.reserveStock(quantity);
        }

        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if ((inStock != null) &&  (quantity > 0)) {
            return inStock.unreserveStock(quantity);
        }

        return 0;
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            s = s + stockItem + ". There are : " + stockItem.availableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }

}
