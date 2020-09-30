package com.sarkarSiddhant.developer;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem>shoppingList;

    public StockList() {
        this.shoppingList=new LinkedHashMap<>();
    }

    public Map<String, StockItem> getShoppingList() {
        return Collections.unmodifiableMap(shoppingList);
    }

    public int addStock(StockItem item){
        if (item != null) {
            StockItem newItem=shoppingList.getOrDefault(item.getName(),item);
            if (item!=newItem){
                item.adjustQuantity(newItem.getQuantityStock());
            }
            shoppingList.put(item.getName(),item);
            return item.getQuantityStock();
        }
        return 0;
    }
    public int sellStocks(StockItem item,int quantity){
        StockItem newItem= shoppingList.getOrDefault(item.getName(),null);
        if ((newItem != null) && (newItem.getQuantityStock() >= quantity&&quantity>0)){
            newItem.adjustQuantity(-quantity);
            return quantity;
        }
        System.out.println("The item "+item.getName()+" is out of stocks right now ");
        return 0;
    }
    public  StockItem getItem(String name){
        return getShoppingList().get(name);
    }

    @Override
    public String toString() {
        double totalCost=0.0;
        String s ="\nStock Item \n";
        for (Map.Entry<String,StockItem> items:shoppingList.entrySet()) {
                StockItem temp= items.getValue();
                double itemValue=temp.getPrice()*temp.getQuantityStock();
                s =s+temp+". There are "+temp.getQuantityStock()+" in stock. Value of items : ";
                s=s+itemValue+"\n";
                totalCost+=itemValue;
        }
        return s+ "Total Stock value "+ totalCost;
    }
}
