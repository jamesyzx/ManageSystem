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
public class SalesPersonCatalog {
    private ArrayList<Salesperson> salesPersonList;
    
    public SalesPersonCatalog(){
        salesPersonList=new ArrayList<Salesperson>();
    }
    
    public ArrayList<Salesperson> getSalesPersonList() {
        return salesPersonList;
    }

    public void setSalesPersonList(ArrayList<Salesperson> salesPersonList) {
        this.salesPersonList = salesPersonList;
    }
    
    
   public Salesperson addSalesperson(){
        Salesperson salesperson=new Salesperson();
        salesPersonList.add(salesperson);
        return salesperson;
    }
   
   public void removeSalesperson(Salesperson s){
        salesPersonList.remove(s);
    }
   public Salesperson searchSalesperson(String name){
       for(Salesperson salesperson:salesPersonList){
           if(salesperson.getName().equals(name)){
               return salesperson;
           }
       }
       return null;
   }
   
}
