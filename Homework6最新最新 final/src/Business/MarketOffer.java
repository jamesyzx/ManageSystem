/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author wuyue
 */
public class MarketOffer {
    private Market market;
    private Product product;
    private double CeilingPrice;
    private double TargetPrice;
    private double FloorPrice;
    
    public MarketOffer(){
        product=new Product();
        market=new Market();
    }

    public MarketOffer(Market market,Product product) {
        this.market = market;
        this.product=product;
        
        if(market.getMarketname().equals("Education")){
            TargetPrice=product.getTargetPrice();
            FloorPrice=product.getFloorPrice();
            CeilingPrice=market.getPrice(FloorPrice, product.getCeilingPrice(), TargetPrice);
        }
        else if(market.getMarketname().equals("Financial")){
            CeilingPrice=product.getCeilingPrice();
            TargetPrice=product.getTargetPrice();
            FloorPrice=market.getPrice(product.getFloorPrice(), CeilingPrice, TargetPrice);
        }
    }
    
    

    public Double getCeilingPrice() {
        return CeilingPrice;
    }

    public void setCeilingPrice(Double CeilingPrice) {
        this.CeilingPrice = CeilingPrice;
    }

    public Double getTargetPrice() {
        return TargetPrice;
    }

    public void setTargetPrice(Double TargetPrice) {
        this.TargetPrice = TargetPrice;
    }

    public Double getFloorPrice() {
        return FloorPrice;
    }

    public void setFloorPrice(Double FloorPrice) {
        this.FloorPrice = FloorPrice;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
    
     @Override
    public String toString() {
        return product.getProdName();
    }
    
    
}
