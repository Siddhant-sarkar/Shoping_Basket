package com.sarkarSiddhant.developer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    public final String Name;
    public final Map<StockItem,Integer>list;

    public Basket(String name) {
        Name = name;
        this.list = new LinkedHashMap<>();
    }
    public int addToBasket(StockItem item,int quantity){
        if (item!=null && quantity>0){
            int temp=list.getOrDefault(item,0);
            list.put(item,temp+quantity);
        }
        return 0;
    }
    @Override
    public String toString() {
        String S ="\nShopping Basket "+Name+" Contains "+list.size()+"items\n";
        double totalCost=0.0;
        for (Map.Entry<StockItem,Integer> item :this.list.entrySet()){
            System.out.println("*Name of item : "+item.getKey().getName()+"|| quantity : "+item.getKey().getQuantityStock()+
                    " || Price : "+item.getKey().getPrice()+" || Subtotal : "+(item.getKey().getPrice())*(item.getKey().getQuantityStock()));
            totalCost+=(item.getKey().getPrice())*(item.getKey().getQuantityStock());
        }
        return S +"\nThe total Cost is "+totalCost;



        
    }
}
