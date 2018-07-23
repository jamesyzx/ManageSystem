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
public class Market {
    private String Marketname;
    private  ArrayList<Customer> Customerlist;
    private ArrayList<Order>Orderlist; 
    
    public Market(){
        Customerlist=new ArrayList<Customer>();
        Orderlist=new ArrayList<Order>();
         
    }
    public double getPrice(double floor, double ceiling ,double target){
        if(Marketname.equals("Financial")){
            return (floor+target)/2;
        }else if(Marketname.equals("Education"))
        {  return  (ceiling+target)/2;}
        return -1;
        
    }

    public String getMarketname() {
        return Marketname;
    }

    public void setMarketname(String Marketname) {
        this.Marketname = Marketname;
    }

    public ArrayList<Customer> getCustomerlist() {
        return Customerlist;
    }

    public void setCustomerlist(ArrayList<Customer> Customerlist) {
        this.Customerlist = Customerlist;
    }

    public ArrayList<Order> getOrderlist() {
        return Orderlist;
    }

    public void setOrderlist(ArrayList<Order> Orderlist) {
        this.Orderlist = Orderlist;
    }
     public Customer addCustomer(){
        Customer customer=new Customer();
        Customerlist.add(customer);
        return customer;
    }
     public Customer searchCustomer(String name){
         for(Customer customer:Customerlist)
             if(customer.getName().equals(name)){
                 return customer;
             }
         return null;
     }
     public Order addOrder(){
        Order order=new Order();
        Orderlist.add(order);
        return order;
    }

   
     @Override
    public String toString() {
        return Marketname;
    }
//     public double revenuebymarket(){
//        double money=0.0;
//            for(Order order:Orderlist){
//                for(OrderItem orderItem:order.getOrderItemlist()){
//                    money=money+(orderItem.getSalesprice()-orderItem.getProduct().getTargetPrice());
//                }
//            }
//        System.out.println(money);
//        return money;
//    }
    
}
