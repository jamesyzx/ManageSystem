/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author wuyue
 */
public class MarketList {
    private ArrayList <Market> marketListcatelog;
    
    public MarketList(){
        marketListcatelog=new ArrayList<Market>();
    }

    public ArrayList<Market> getMarketListcatelog() {
        return marketListcatelog;
    }

    public void setMarketListcatelog(ArrayList<Market> marketListcatelog) {
        this.marketListcatelog = marketListcatelog;
    }

    
    public Market addMarket(){
        Market market =new Market();
        marketListcatelog.add(market);
        return market;
    }
    public void removemarket(Market market ){
        marketListcatelog.remove(market);
    }
    
    public Market searchmarket(String name ){
        for(Market market1:marketListcatelog){
            if(market1.getMarketname().equals(name)){
                return market1;
            }
        }
        return null;
    }
     public Customer searchCustomer(String name){
         for(Market market:marketListcatelog){
             for(Customer customer:market.getCustomerlist()){
                if(customer.getName().equals(name)){
                 return customer;
             }
         }    
         
     }
     return null;
}
    
}