/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.*;

import Business.SupplierDirectory;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wuyue
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
   private Business business;
   private SupplierDirectory supplierDirectory;
   private MarketList marketList;
   private Supplier supplier;

   private MasterOrdercatalog masterOrdercatalog;
   private SalesPersonCatalog salesPersonCatalog;
 
  
   //private Salesperson salesperson;
    public MainJFrame() {
        initComponents();
        business=new Business();
        marketList=business.getMarketList();
        salesPersonCatalog=new SalesPersonCatalog();
        supplierDirectory=business.getSupplierDirectory();
        read_csv3();
        read_csv();
        read_csv1();
        read_csv4();
        setSize(800, 600);
        
    }
    public void read_csv(){
        String[] st;
        int n,m,k;
        File csv =new File("Products.csv");
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader(csv));           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line="";
        try {
             n=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++ )
            { 
                supplier=supplierDirectory.addSupplier();
                supplier.setSupplyName(br.readLine()); 
                supplier.setUserId(br.readLine());
                supplier.setPassword(br.readLine());
                
           m=Integer.parseInt(br.readLine());
                for(int j=0;j<m;j++){
                    Product p=supplier.getProductCatalog().addProduct();
                     st=br.readLine().split(",");
                    p.setModelNumber(Integer.parseInt(st[0]));
                    p.setProdName(st[1]);
                    p.setFloorPrice(Double.parseDouble(st[2])); 
                    p.setTargetPrice(Double.parseDouble(st[3]));
                    p.setCeilingPrice(Double.parseDouble(st[4]));                    
                    p.setAvail(Integer.parseInt(st[5]));
                   
                    for(Market market:business.getMarketList().getMarketListcatelog()){
                        MarketOffer marketOffer=new MarketOffer(market, p);
                        business.getMarketOfferCatalog().getMarketOfferList().add(marketOffer); 
                    }
            }
            }
 } catch (IOException e) 
        {
            e.printStackTrace();
        }
        for(Supplier supplier:business.getSupplierDirectory().getSupplierlist())
        {
            for(Product product:supplier.getProductCatalog().getProductcatalog())
            {
               System.out.println(product.getProdName());
            }
        }
        
   }
    
     public void read_csv1(){
           String[] st;
         int n,m,k,l;
//         File csv =new File("orderItem11.csv");
         File csv =new File("orderItem.csv");
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader(csv));           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line="";
        try {
            
                 
             n=Integer.parseInt(br.readLine());
            
            for(int i=0;i<n;i++ )
            { 
               Order order=business.getMasterOrdercatalog().addorder();
                order.setOrderNumber(Integer.parseInt(br.readLine()));
                order.setSalesperson(business.getSalesPersonCatalog().searchSalesperson(br.readLine()));   
                order.setCustomer(business.getMarketList().searchCustomer(br.readLine())); 
//                 order.setOrderRevenue(Double.parseDouble(br.readLine()));
//                   order.setGaptarget(Double.parseDouble(br.readLine()));
                   
                   
               m=Integer.parseInt(br.readLine());
                for(int j=0;j<m;j++){
                    
                     st=br.readLine().split(",");
                   order.addorderitem(business.SearchProduct(Integer.parseInt(st[0]))
                           , Integer.parseInt(st[1]), Double.parseDouble(st[2]));
                   int q=0;
                   for(Product product:supplierDirectory.getSupplierlist().get(0).getProductCatalog().getProductcatalog())
                   {for(OrderItem orderItem:order.getOrderItemlist())
                    {
                        if(orderItem.getProduct().equals(product))
                        {q=product.getAvail()-orderItem.getQuantity();
                        product.setAvail(q);
                        }
                    }
                   
                   }
                }
                order.setOrderRevenue(order.renueve());
                   order.setGaptarget(order.gaprenueve());
                  
                business.getMarketList().getMarketListcatelog().get(0).getOrderlist().add(order);
            }
                 
            
 } catch (IOException e) 
        {
            e.printStackTrace();
        }    
   }
          public void read_csv4(){
           String[] st;
         int n,m,k,l;
         File csv =new File("orderItem2.csv");
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader(csv));           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line="";
        try {
           
             n=Integer.parseInt(br.readLine());
            
            for(int i=0;i<n;i++ )
            { 
               Order order=business.getMasterOrdercatalog().addorder();
                order.setOrderNumber(Integer.parseInt(br.readLine()));
                order.setSalesperson(business.getSalesPersonCatalog().searchSalesperson(br.readLine()));   
                order.setCustomer(business.getMarketList().searchCustomer(br.readLine())); 
//                order.setOrderRevenue(Double.parseDouble(br.readLine()));
//             order.setGaptarget(Double.parseDouble(br.readLine()));
                
               m=Integer.parseInt(br.readLine());
                for(int j=0;j<m;j++){
                    
                     st=br.readLine().split(",");
                   order.addorderitem(business.SearchProduct(Integer.parseInt(st[0]))
                           , Integer.parseInt(st[1]), Double.parseDouble(st[2]));
            }
                order.setOrderRevenue(order.renueve());
                   order.setGaptarget(order.gaprenueve());
                business.getMarketList().getMarketListcatelog().get(1).getOrderlist().add(order);
            }
                 
            
 } catch (IOException e) 
        {
            e.printStackTrace();
        }    
   }
     
    

     public void read_csv3(){
           String[] st;
         int n,m,k;
         File csv =new File("Customer.csv");
        BufferedReader br =null;
        try {
            br = new BufferedReader(new FileReader(csv));           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line="";
        try {
             n=Integer.parseInt(br.readLine());
            
            for(int i=0;i<n;i++ )
            { 
                Market market=marketList.addMarket();
                market.setMarketname(br.readLine());
                
          
                 m=Integer.parseInt(br.readLine());
                for(int j=0;j<m;j++){
                  
                     st=br.readLine().split(",");
                     Customer customer=market.addCustomer();
                     customer.setName(st[0]);
            }
            }
        
 } catch (IOException e) 
        {
            e.printStackTrace();
        }
        
   }
     
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        LeftJPanel = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        userProcessContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftJPanelLayout = new javax.swing.GroupLayout(LeftJPanel);
        LeftJPanel.setLayout(LeftJPanelLayout);
        LeftJPanelLayout.setHorizontalGroup(
            LeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LeftJPanelLayout.setVerticalGroup(
            LeftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftJPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnLogin)
                .addContainerGap(518, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(LeftJPanel);

        userProcessContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(userProcessContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        LoginArea la= new LoginArea(userProcessContainer,business);
        userProcessContainer.add("LoginArea",la);
        CardLayout layout=(CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftJPanel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
