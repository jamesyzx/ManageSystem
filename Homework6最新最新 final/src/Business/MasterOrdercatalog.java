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
public class MasterOrdercatalog {
    private ArrayList<Order>Ordercatelog;

    public MasterOrdercatalog() {
        Ordercatelog=new ArrayList<Order>();
    }

    public ArrayList<Order> getOrdercatelog() {
        return Ordercatelog;
    }

    public void setOrdercatelog(ArrayList<Order> Ordercatelog) {
        this.Ordercatelog = Ordercatelog;
    }
    public Order addorder(){
        Order order=new Order();
        Ordercatelog.add(order);
        return order;
    }
    
    public void removeorder(Order order){
        Ordercatelog.remove(order);
    }
    
}
