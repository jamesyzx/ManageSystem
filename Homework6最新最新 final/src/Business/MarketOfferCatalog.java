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
public class MarketOfferCatalog {
    private ArrayList<MarketOffer> marketOfferList;
    
     public MarketOfferCatalog(){
         marketOfferList=new ArrayList<MarketOffer>();
     }

    public ArrayList<MarketOffer> getMarketOfferList() {
        return marketOfferList;
    }

    public void setMarketOfferList(ArrayList<MarketOffer> marketOfferList) {
        this.marketOfferList = marketOfferList;
    }
     
}
