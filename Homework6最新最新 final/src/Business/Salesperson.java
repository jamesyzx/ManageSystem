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
public class Salesperson {
    private String Name;
    private  String UserId;
    private  String Password;
    private   double totalrevenue; 
    private   double marketrevenue;
    private   double gaprevenue;
    private   double reward;
            
            
    
    public Salesperson(){
        totalrevenue=0.0;
        marketrevenue=0.0;
        gaprevenue=0.0;
        
    }

    public String getUserId() {
        return UserId;
    }
    
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }
    
    public double getTotalrevenue() {
        return totalrevenue;
    }

    public void setTotalrevenue(double totalrevenue) {
        this.totalrevenue = totalrevenue;
    }

    public double getGaprevenue() {
        return gaprevenue;
    }

    public void setGaprevenue(double gaprevenue) {
        this.gaprevenue = gaprevenue;
    }
     
    public double getMarketrevenue() {
        return marketrevenue;
    }

    public void setMarketrevenue(double marketrevenue) {
        this.marketrevenue = marketrevenue;
    }

   

    
    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
     
    @Override
    public String toString(){
        return Name;
        
    }
    

    

    
   
    
}
