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
public class Product {
    private String prodName;
    private double FloorPrice;
    private double TargetPrice;
    private double CeilingPrice;
    private int modelNumber;
    private int avail;
    private double gap;

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }
    private static int count1 =0;
    private double revenue;
    public Product() {
    count1++;
    modelNumber = count1;
    }
    
    
    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getFloorPrice() {
        return FloorPrice;
    }

    public void setFloorPrice(double FloorPrice) {
        this.FloorPrice = FloorPrice;
    }

    public double getTargetPrice() {
        return TargetPrice;
    }

    public void setTargetPrice(double TargetPrice) {
        this.TargetPrice = TargetPrice;
    }

    public double getCeilingPrice() {
        return CeilingPrice;
    }

    public void setCeilingPrice(double CeilingPrice) {
        this.CeilingPrice = CeilingPrice;
    }


    

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }
    @Override
    public String toString() {
        return prodName; //To change body of generated methods, choose Tools | Templates.
    }
    
}
