package com.sarkarSiddhant.developer;

public class Main {
private static StockList stockList=new StockList();
    public static void main(String[] args) {
	StockItem item=new StockItem("iPhone",1000.00,10);
	stockList.addStock(item);
         item=new StockItem("Samsung",975.00,150);
        stockList.addStock(item);
        item=new StockItem("Mi",100.00,150);
        stockList.addStock(item);

        System.out.println(stockList);
        Basket basket =new Basket("Sarkar's Basket");
        sellItem(basket,"iPhone",9);
        System.out.println(stockList);
        System.out.println(basket);

        sellItem(basket,"iPhone",9);
        sellItem(basket,"Samsung",2);
        sellItem(basket,"Mi",21);
        System.out.println(basket);

//        sellItem(basket,"iPhone",1);
//        sellItem(basket,"Xiaomi",5);


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
