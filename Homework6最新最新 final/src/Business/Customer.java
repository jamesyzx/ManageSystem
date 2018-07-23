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
public class Customer {
    String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     @Override
    public String toString() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
}
