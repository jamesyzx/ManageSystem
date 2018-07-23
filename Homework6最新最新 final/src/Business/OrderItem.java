/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author james
 */
public class OrderItem {
    private int Quantity;
    private double Salesprice;
    private double gaprevenue;
    private  Product product;
  
    

    public OrderItem() {
       
        product=new Product();
        
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
     
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getGaprevenue() {
        return gaprevenue;
    }

    public void setGaprevenue(double gaprevenue) {
        this.gaprevenue = gaprevenue;
    }
    

    public double getSalesprice() {
        return Salesprice;
    }

    public void setSalesprice(double Salesprice) {
        this.Salesprice = Salesprice;
    }
@Override
    public  String toString(){
        return product.getProdName();
    }
   
}
