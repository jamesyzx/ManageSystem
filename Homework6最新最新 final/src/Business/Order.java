/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author james
 */
public class Order {
     private ArrayList<OrderItem> OrderItemlist;
    private  int  OrderNumber;
    private  double OrderRevenue;
    private  double gaptarget;
    private  static int count=0;
    Salesperson salesperson;
    Customer customer;
    public Order() {
        count++;
        OrderNumber=count;
        OrderItemlist=new ArrayList<OrderItem>();
        salesperson=new Salesperson();
        customer=new Customer();
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getGaptarget() {
        return gaptarget;
    }

    public void setGaptarget(double gaptarget) {
        this.gaptarget = gaptarget;
    }
    
    public double getOrderRevenue() {
        return OrderRevenue;
    }

    public void setOrderRevenue(double OrderRevenue) {
        this.OrderRevenue = OrderRevenue;
    }
     
    public ArrayList<OrderItem> getOrderItemlist() {
        return OrderItemlist;
    }

    public void setOrderItemlist(ArrayList<OrderItem> OrderItemlist) {
        this.OrderItemlist = OrderItemlist;
    }

    public int getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(int OrderNumber) {
        this.OrderNumber = OrderNumber;
    }
     public OrderItem addorderitem(Product product,int q,Double price){
         OrderItem orderItem=new OrderItem();
         orderItem.setProduct(product);
         orderItem.setQuantity(q);
         orderItem.setSalesprice(price);
         
         OrderItemlist.add(orderItem);
         return orderItem;
         
         
     }
     public void  removeorderitem(OrderItem orderItem){
         OrderItemlist.remove(orderItem);
     }
     public String toString(){
         return String.valueOf(OrderNumber);
     }
     
     public double renueve(){
        double money=0.0;
        for(OrderItem orderItem:OrderItemlist){
            money=money+(orderItem.getQuantity()*orderItem.getSalesprice());
        }
        return money; 
         
    }
     public double gaprenueve(){
        double money=0.0;
        
        for(OrderItem orderItem:OrderItemlist){
            money=money+(orderItem.getQuantity()*(orderItem.getSalesprice()-orderItem.getProduct().getTargetPrice()));
        }
        return money; 
         
    }
      
  
}
