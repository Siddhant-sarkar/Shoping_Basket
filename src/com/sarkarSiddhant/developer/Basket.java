package com.sarkarSiddhant.developer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Basket {
    public final String Name;
    public  Map<StockItem,Integer>list;
    public  Map<StockItem,Integer>reservedList;

    public Basket(String name) {
        Name = name;
        this.list = new LinkedHashMap<>();
        this.reservedList=new LinkedHashMap<>();

    }
    public int addToBasket(StockItem item,int quantity){
        if (item!=null && quantity>0){
            int temp=list.getOrDefault(item,0);
            list.put(item,temp+quantity);
            return temp+quantity;
        }
        return 0;
    }

    public boolean reserveItem(StockItem item,int quantity){
        if (quantity<=item.getQuantityStock()-item.getReserved()){
            item.setQuantityReserved(quantity);
            System.out.println(quantity+" "+item.getName()+" are  reserved!!! ");
            this.reservedList.put(item,quantity);
            return true;
        }
        System.out.println("You are trying to reserve more than available to reserve ");
        return false;
    }
    public void checkout(){
        for (Map.Entry<StockItem,Integer> items:this.reservedList.entrySet()){
            items.getKey().setQuantityReserved(0);
            addToBasket( items.getKey(),items.getValue());
        }
        this.reservedList.clear();
        System.out.println("SucessFully  checkout");
    }
    public String resvedListVisualized(){
        String S ="\nReserved Basket "+Name+" Contains "+reservedList.size()+" items\n";
        System.out.println(S);
        double totalCost=0.0;
        for (Map.Entry<StockItem,Integer> item :this.reservedList.entrySet()){
            System.out.println("*Name of item : "+item.getKey().getName()+"|| quantity : "+item.getValue()+
                    " || Price : "+item.getKey().getPrice()+" || Subtotal : "+(item.getKey().getPrice())*(item.getValue()));
            totalCost+=(double)((item.getKey().getPrice())*(item.getValue()));
        }
       return "The total Cost is : "+totalCost ;
    }

    @Override
    public String toString() {
        String S ="\nShopping Basket "+Name+" Contains "+list.size()+" items\n";
        System.out.println(S);
        double Cost=0.0;
        for (Map.Entry<StockItem,Integer> item :this.list.entrySet()){
            System.out.println("*Name of item : "+item.getKey().getName()+"|| quantity : "+item.getValue()+
                    " || Price : "+item.getKey().getPrice()+" || Subtotal : "+(item.getKey().getPrice())*(item.getValue()));
            Cost+=(item.getKey().getPrice())*(item.getKey().getQuantityStock());
        }
        return "The total Cost is : "+Cost ;

    }
}
