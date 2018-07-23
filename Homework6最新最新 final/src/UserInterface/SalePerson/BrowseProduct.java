/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SalePerson;

import Business.*;
import Business.MasterOrdercatalog;
import Business.Order;
import Business.OrderItem;
import Business.Product;
import Business.Salesperson;
import Business.Supplier;
import Business.SupplierDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yangjing
 */
public class BrowseProduct extends javax.swing.JPanel {
     private JPanel userProcessContainer;
    private SupplierDirectory supplierDirectory;
    private MasterOrdercatalog masterOrdercatalog;
    private Order order;
    private Business business;
    private boolean isCheckedOut=false;
    private Salesperson salesperson;
    private MarketList marketList;
    private MarketOfferCatalog marketOfferCatalog;
    private Customer customer;
    private Market market;
    private MarketOffer marketOffer;
    Double money;
    

    BrowseProduct(JPanel userProcessContainer, Customer customer, Business business, Salesperson salesperson, Market market) {
       initComponents();
        this.userProcessContainer=userProcessContainer;
        this.business=business;
        this.salesperson=salesperson;
        this.customer=customer;
        this.market=market;
        
        masterOrdercatalog=business.getMasterOrdercatalog();
        supplierDirectory=business.getSupplierDirectory();
        marketList=business.getMarketList();
        marketOfferCatalog=business.getMarketOfferCatalog();
        salesTF.setText(salesperson.getName());
        nameTF.setText(customer.getName());
        MarketTF.setText(market.getMarketname());
        marketOffer=new MarketOffer();
        populateSupplierCombo();
        populateTable();
         
        if(!isCheckedOut){
           order = new Order(); 
        }
    }
    
    
    public void populateSupplierCombo(){
        suppComboBox1.removeAllItems();
        
        for(Supplier supplier:supplierDirectory.getSupplierlist()){
            suppComboBox1.addItem(supplier);
            
        }
    }
   
        public void populateTable(){
         
        DefaultTableModel model = (DefaultTableModel)productTable.getModel();
        model.setRowCount(0);
       Supplier s=(Supplier) suppComboBox1.getSelectedItem();
        for(MarketOffer marketOffer: marketOfferCatalog.getMarketOfferList()) {
            if(marketOffer.getMarket().equals(market)){
                Product product=business.getProductbyname(marketOffer.getProduct().getProdName());
                
                for(Product p:s.getProductCatalog().getProductcatalog()){
                    if(p.equals(product)){
                       Object row[] = new Object[6];
            row[0] = marketOffer;
            row[1] = marketOffer.getProduct().getModelNumber();
            row[2] = marketOffer.getCeilingPrice();
            row[3] = marketOffer.getTargetPrice();
            row[4] = marketOffer.getFloorPrice();
            row[5] = product.getAvail();
            model.addRow(row); 
                    }
                }
            
            }
            
        }
     }

     
     public void refreshProductTable(String keyword){
         DefaultTableModel model = (DefaultTableModel)productTable.getModel();
        model.setRowCount(0);
       {
            for(MarketOffer marketOffer:marketOfferCatalog.getMarketOfferList()){
                if(market.equals(marketOffer.getMarket()))
                if(marketOffer.getProduct().getProdName().equalsIgnoreCase(keyword))
                {
                    Object row[] = new Object[6];
           row[0] = marketOffer;
            row[1] = marketOffer.getProduct().getModelNumber();
            row[2] = marketOffer.getCeilingPrice();
            row[3] = marketOffer.getTargetPrice();
            row[4] = marketOffer.getFloorPrice();
            row[5] = marketOffer.getProduct().getAvail();
            model.addRow(row);
                
            }
        }
       } 
     }
     
     public void refreshOrderTable(){
         DefaultTableModel model = (DefaultTableModel)orderTable.getModel();
        model.setRowCount(0);
        for(OrderItem oi:order.getOrderItemlist()){
           
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getSalesprice();
            row[2] = oi.getQuantity();
            row[3]=oi.getQuantity()*oi.getSalesprice();
            model.addRow(row);

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

        suppComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        addtoCartButton6 = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        btnSearchProduct = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        btnViewOrderItem = new javax.swing.JButton();
        btnModifyQuantity = new javax.swing.JButton();
        btnRemoveOrderItem = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        txtSearchKeyWord = new javax.swing.JTextField();
        txtNewQuantity = new javax.swing.JTextField();
        salesTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        nameTF = new javax.swing.JTextField();
        MarketTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        moneyTF = new javax.swing.JTextField();
        revenueTF = new javax.swing.JTextField();

        suppComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Supplier");

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        addtoCartButton6.setText("ADD TO CART");
        addtoCartButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoCartButton6ActionPerformed(evt);
            }
        });

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantity:");

        btnSearchProduct.setText("Search Product");
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        jLabel6.setText("Sales Price");

        jLabel7.setText("Item in cart");

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Price", "Quantity", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(orderTable);

        btnViewOrderItem.setText("View Item");
        btnViewOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrderItemActionPerformed(evt);
            }
        });

        btnModifyQuantity.setText("Modify Quantity");
        btnModifyQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyQuantityActionPerformed(evt);
            }
        });

        btnRemoveOrderItem.setText("Remove");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });

        btnCheckOut.setText("Check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        salesTF.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setText("SalesPerson:");

        productTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Product Id", "CeilingPrice", "TargetPrice", "FloorPrice", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(3).setResizable(false);
            productTable.getColumnModel().getColumn(4).setResizable(false);
            productTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("Customer:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel4.setText("Martket:");

        moneyTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyTFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MarketTF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(suppComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(txtSearchKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSearchProduct)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(12, 12, 12)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addtoCartButton6))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(salesTF, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(43, 43, 43)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(226, 226, 226)
                                    .addComponent(btnRemoveOrderItem)))
                            .addGap(175, 175, 175)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(moneyTF, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(revenueTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))))
                .addGap(22, 22, 22))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnViewOrderItem)
                            .addGap(5, 5, 5)
                            .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(140, 140, 140)
                                    .addComponent(btnCheckOut))
                                .addComponent(btnModifyQuantity)))
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 43, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salesTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MarketTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addtoCartButton6)
                    .addComponent(txtSalesPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(moneyTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(revenueTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRemoveOrderItem)
                        .addGap(14, 14, 14))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 270, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(14, 14, 14)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnViewOrderItem)
                        .addComponent(txtNewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCheckOut)
                        .addComponent(btnModifyQuantity))
                    .addGap(11, 11, 11)
                    .addComponent(btnBack)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void suppComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppComboBox1ActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_suppComboBox1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
         layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    private void addtoCartButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoCartButton6ActionPerformed
        // TODO add your handling code here:
        int selectedRow= productTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please Select a row");
            return;
        }
        MarketOffer marketOffer=(MarketOffer) productTable.getValueAt(selectedRow, 0);
        int fetchQty= (Integer)quantitySpinner.getValue();
        if(fetchQty<=0){
            JOptionPane.showMessageDialog(null, "Quatity connot be less than to 0");
            return;
        }
        double salesPrice= Double.parseDouble(txtSalesPrice.getText());
       try{

            if(salesPrice<=marketOffer.getFloorPrice()){
                JOptionPane.showMessageDialog(null, "Salesprice cannot be less than floor price");
                return;
            }
            if(salesPrice>=marketOffer.getCeilingPrice()){
                JOptionPane.showMessageDialog(null, "Salesprice cannot be more than ceiling price");
                return;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Invalid salesPrices");
            return;
        }
        if(fetchQty<=marketOffer.getProduct().getAvail()){
            boolean alreadyPresent =false;
            for(OrderItem oi:order.getOrderItemlist()){
                if(oi.getProduct()==marketOffer.getProduct()){
                    int oldAvail = marketOffer.getProduct().getAvail();
                    int newAvail =oldAvail-fetchQty;
                    marketOffer.getProduct().setAvail(newAvail);
                    oi.setQuantity(fetchQty+oi.getQuantity());
                    alreadyPresent= true;
                    populateTable();
                    refreshOrderTable();
                    break;
                }
            }
            if(!alreadyPresent){
                int oldAvail = marketOffer.getProduct().getAvail();
                int newAvail=oldAvail-fetchQty;
               marketOffer.getProduct().setAvail(newAvail);
                order.addorderitem(marketOffer.getProduct(),fetchQty,salesPrice);
                populateTable();
                refreshOrderTable();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Quatity>Availbility","Warining",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addtoCartButton6ActionPerformed

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        String prodName = txtSearchKeyWord.getText();
        refreshProductTable(prodName);
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnViewOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrderItemActionPerformed

        int row = orderTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        OrderItem orderItem = (OrderItem) orderTable.getValueAt(row, 0);
        ViewOrderItemDetailJPanel vpdjp = new ViewOrderItemDetailJPanel(userProcessContainer, orderItem);
        userProcessContainer.add("ViewOrderItemDetailJPanel ", vpdjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewOrderItemActionPerformed

    private void btnModifyQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyQuantityActionPerformed
        // TODO add your handling code here:
        int selectedRow =orderTable.getSelectedRow();
        if(selectedRow<0){

            return;
        }
        OrderItem oi =(OrderItem) orderTable.getValueAt(selectedRow, 0);
        int currentAvail =oi.getProduct().getAvail();
        int oldQty=oi.getQuantity();
        int newQty =Integer.parseInt(txtNewQuantity.getText());
        if(newQty>(currentAvail+oldQty)){
            JOptionPane.showMessageDialog(null, "Quantity is more than availbility");
           return;
        }
        else{
            if(newQty<=0){
                JOptionPane.showMessageDialog(null, "Quantiry should be greater than 0");
                return;
            }
            oi.setQuantity(newQty);
            oi.getProduct().setAvail(currentAvail+(oldQty-newQty));
            refreshOrderTable();
            populateTable();

        }

    }//GEN-LAST:event_btnModifyQuantityActionPerformed

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderItemActionPerformed

        int row = orderTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Pls select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        OrderItem orderItem = (OrderItem) orderTable.getValueAt(row, 0);
        int oldAvail =orderItem.getProduct().getAvail();
        int oldQty=orderItem.getQuantity();
        int newQty= oldAvail+oldQty;
        orderItem.getProduct().setAvail(newQty);
        order.removeorderitem(orderItem);
        JOptionPane.showMessageDialog(null, "OrderItem removed from the cart");
        refreshOrderTable();
        populateTable();
    }//GEN-LAST:event_btnRemoveOrderItemActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        if(order.getOrderItemlist().size()>0){
            market.getOrderlist().add(order);
          masterOrdercatalog.getOrdercatelog().add(order);
          order.setSalesperson(salesperson);
         
          order.setCustomer(customer);
            order.setOrderRevenue(order.renueve());
           order.setGaptarget(order.gaprenueve());
            moneyTF.setText(String.valueOf(order.getOrderRevenue()));
            revenueTF.setText(String.valueOf(order.gaprenueve()));
            JOptionPane.showMessageDialog(null, "order placed successfully");
            order = new Order();
            
            refreshOrderTable();
            populateTable();
            isCheckedOut= true;
        }else{
            JOptionPane.showMessageDialog(null, "No  order placed");
        }

    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void moneyTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyTFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MarketTF;
    private javax.swing.JButton addtoCartButton6;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnModifyQuantity;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnViewOrderItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField moneyTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable productTable;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField revenueTF;
    private javax.swing.JTextField salesTF;
    private javax.swing.JComboBox suppComboBox1;
    private javax.swing.JTextField txtNewQuantity;
    private javax.swing.JTextField txtSalesPrice;
    private javax.swing.JTextField txtSearchKeyWord;
    // End of variables declaration//GEN-END:variables
}
