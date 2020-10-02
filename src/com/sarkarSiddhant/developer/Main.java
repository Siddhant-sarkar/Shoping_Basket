package com.sarkarSiddhant.developer;

public class Main {
private static StockList stockList=new StockList();
    public static void main(String[] args) {
        /*
         *adding the diffrent items to this.stocklist
         */
	    StockItem item=new StockItem("iPhone",1000.00,10);
	    stockList.addStock(item);
	    item=new StockItem("Samsung",975.00,12);
	    stockList.addStock(item);
	    item=new StockItem("Mi",100.00,12);
        stockList.addStock(item);
        //printing out the stocklist
//        System.out.println(stockList);
        // declaring the basket of items.
        Basket basket =new Basket("Sarkar's Basket");
        /**
         * Selling the items
         * iPhone :7
         *Samsung : 2
         *Mi : 6
         */
        sellItem(basket,"iPhone",7);
        sellItem(basket,"Samsung",2);
        sellItem(basket,"Mi",6);
        //printing the stocklist
//        System.out.println(stockList);
        //printing the basket
        System.out.println(basket);//i=7,s=2,mi=6
        //printing the reserved items
        System.out.println(basket.resvedListVisualized());//everything is zero...
        /**
         *Reserveing the items
         */
       basket.reserveItem(stockList.getItem("iPhone"),2);
       basket.reserveItem(stockList.getItem("Samsung"),10);
       basket.reserveItem(stockList.getItem("Mi"),3);
       System.out.println(basket.resvedListVisualized());//i=2,s=10,mi=3


        basket.checkout();
       System.out.println(basket);//i=9,s=12,mi=9
        System.out.println(basket.resvedListVisualized());


    }
    public static int sellItem(Basket basket,String string,int quantity){
        StockItem stockItem=stockList.getItem(string);
        if (stockItem==null){
            System.out.println("Sorry we don't sell  "+string );
            return 0;
        }else {
            if (stockList.sellStocks(stockItem, quantity) != 0) {
                basket.addToBasket(stockItem, quantity);
                return quantity;
            }
            else{
                System.out.println("Sorry bro the item "+string +" is out of Stock ");
                return 0;
            }
        }
    }
}
