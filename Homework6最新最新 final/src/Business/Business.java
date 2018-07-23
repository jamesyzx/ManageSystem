/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;
import  Business.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author james
 */
public class Business {
    SupplierDirectory supplierDirectory;
 
    SalesPersonCatalog salesPersonCatalog;
    MasterOrdercatalog masterOrdercatalog;
    MarketOfferCatalog marketOfferCatalog;
    MarketOffer marketOffer;
    MarketList marketList;
    private String Password ;
    private String ID;
    private ArrayList<String>UserIdList;
         

    public Business() {
       supplierDirectory=new SupplierDirectory();
      
        salesPersonCatalog=new SalesPersonCatalog();
        masterOrdercatalog=new MasterOrdercatalog();
        marketOfferCatalog=new MarketOfferCatalog();
        UserIdList=new ArrayList<>();
        marketOffer=new MarketOffer();
        marketList=new MarketList();
        Password="admin";
        ID="admin";
        read_csv2();
    }
    
    public Salesperson getSalesperson(String userid, String password){
        for(Salesperson salesperson:salesPersonCatalog.getSalesPersonList())
      {
       if((password.equals(salesperson.getPassword()))&&(userid.equals(salesperson.getUserId())))
           return salesperson;
      }
        return null;
    }
    
    public Supplier getSupplier(String userid, String password){
        for(Supplier supplier:supplierDirectory.getSupplierlist())
                      {
                      if((password.equals(supplier.getPassword()))&&(userid.equals(supplier.getUserId())))
                    return supplier;
    }return  null;
    }
    public Product getProductbyname(String name){
        for(Supplier supplier:supplierDirectory.getSupplierlist())
        {
            for(Product product:supplier.getProductCatalog().getProductcatalog())
            {
                if(product.getProdName().equals(name))
                {
                    return product;
                }
            }
        }
        return  null;
    }
    public ArrayList<MarketOffer>getMarketofferbyMarket(Market market)
    {
        ArrayList<MarketOffer>markets=new ArrayList<MarketOffer>();
        for(MarketOffer marketOffer:marketOfferCatalog.getMarketOfferList())
        {if(marketOffer.getMarket().equals(market))
        {
            markets.add(marketOffer);
        }
        }
        return null;
    }
     public Order getOrderbycustomer(Customer customer){
        
            for(Order order:masterOrdercatalog.getOrdercatelog())
            {
                if(order.getCustomer().equals(customer))
                {
                    return order;
                }
            }
        
        return  null;
    }
     public double salespersonreward(Salesperson salesperson){
         double money=0.0;
         double reward=0.0;
         for(Market market:marketList.getMarketListcatelog())
         {
         for(Order order:masterOrdercatalog.getOrdercatelog())
         {
             if(order.getSalesperson().equals(salesperson))
             { 
                 money=money+order.getOrderRevenue();
                 salesperson.setTotalrevenue(money);
             }
         }money=0.0;
         }
         
         if(salesperson.getTotalrevenue()>2000)
         {
         if(salesperson.getTotalrevenue()>5000)
         {
             if(salesperson.getTotalrevenue()>10000)
             {
                 reward=3000+(salesperson.getTotalrevenue()-10000)*0.1;
             }else reward=3000;
         }else reward=1000;
         }else reward=0.0;   
         
         return reward;
     }

            

    public ArrayList<String> getUserIdList() {
        return UserIdList;
    }

    public void setUserIdList(ArrayList<String> UserIdList) {
        this.UserIdList = UserIdList;
    }
    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
     
    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    

    public SalesPersonCatalog getSalesPersonCatalog() {
        return salesPersonCatalog;
    }

    public void setSalesPersonCatalog(SalesPersonCatalog salesPersonCatalog) {
        this.salesPersonCatalog = salesPersonCatalog;
    }

    public MasterOrdercatalog getMasterOrdercatalog() {
        return masterOrdercatalog;
    }

    public void setMasterOrdercatalog(MasterOrdercatalog masterOrdercatalog) {
        this.masterOrdercatalog = masterOrdercatalog;
    }

    public MarketOfferCatalog getMarketOfferCatalog() {
        return marketOfferCatalog;
    }

    public void setMarketOfferCatalog(MarketOfferCatalog marketOfferCatalog) {
        this.marketOfferCatalog = marketOfferCatalog;
    }

    public MarketList getMarketList() {
        return marketList;
    }

    public void setMarketList(MarketList marketList) {
        this.marketList = marketList;
    }

    
     public void read_csv2()
     {
         String[] st;
         int n,m,k;
         File csv =new File("SalesPerson.csv");
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader(csv));           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line="";
        try {
             m=Integer.parseInt(br.readLine());
            for(int j=0;j<m;j++){
            st=br.readLine().split(",");
            Salesperson salesperson=salesPersonCatalog.addSalesperson();
            salesperson.setName(st[0]);
            salesperson.setUserId(st[1]);
            salesperson.setPassword(st[2]);
           
            }
            
 } catch (IOException e) 
        {
            e.printStackTrace();
        }
       
      
     }

    public Product SearchProduct(int id){
        for(Supplier supplier:supplierDirectory.getSupplierlist()){
            for(Product product:supplier.getProductCatalog().getProductcatalog()){
                if(product.getModelNumber()==id)
                    return product;
            }
        }
        return  null;
        
      
    }
    
    

    
    
    
}
