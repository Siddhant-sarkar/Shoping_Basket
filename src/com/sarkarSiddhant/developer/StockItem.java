package com.sarkarSiddhant.developer;

import java.util.Map;
import java.util.TreeMap;

public class StockItem implements Comparable<StockItem> {
    private final String  name;
    private  Double price;
    private int quantityStock;
    private int reserved;

    public StockItem(String name, Double price,int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.reserved=0;
    }


    public String getName() {
        return name;
    }

    public int getReserved() {
        return reserved;
    }
    public int getQuantityStock() {
        return quantityStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price>0){
            this.price = price;
        }
    }

    public void setQuantityStock(int quantityStock) {
        int newStock=this.quantityStock+quantityStock;
        if (newStock < 0) {
            this.quantityStock=newStock;
        }
    }
    public void setQuantityReserved(int toBeReserved) {
            this.quantityStock=reserved;
    }
    /*
    The method to increase the quantity of Qualtity Stock
     */
    public void adjustQuantity(int quantityStock){

            this.quantityStock+=quantityStock;

    }
    /*
    Overriding the equals method
    to return true is object's name is equal to the name
    of the this.name;
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName=((StockItem)obj).getName();
        return this.getName().equals(objName);
    }
    /*
    *We are overriding the hashcode
    * method to return
    * hashcode of the feild name
    * of this class
     */
    @Override
    public int hashCode() {
        return this.name.hashCode()+56;
    }

    /**
     * @param o
     * @return 0 if the objects are equal 1,-1 if the string is Lexadecially geater or smaller than this.Name;
     */
    @Override
    public int compareTo(StockItem o) {
        if (o==this){
            return 0;
        }
        if (o != null) {
            return this.getName().compareTo(o.getName());
        }
        throw new NullPointerException();
    }

    /***
     * @return noting but string consisting the name and price
     */
    @Override
    public String toString() {
        return "Name : "+this.name+" Price : "+this.price+" Reserved : "+getReserved();
    }
}
