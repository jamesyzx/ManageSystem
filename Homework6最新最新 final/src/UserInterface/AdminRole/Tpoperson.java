/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminRole;

import Business.Business;
import Business.Market;
import Business.MarketList;
import Business.MasterOrdercatalog;
import Business.Order;
import Business.SalesPersonCatalog;
import Business.Salesperson;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author james
 */
public class Tpoperson extends javax.swing.JPanel {

    /**
     * Creates new form Tpoperson
     */
    private Business business;
    private JPanel userProcessContainer;
    private MarketList marketList;
    private MasterOrdercatalog masterOrdercatalog;
    private Market market;
    private SalesPersonCatalog salesPersonCatalog;
    double total;

    Tpoperson(JPanel userProcessContainer, Business business, Market market) {
        initComponents();
        this.business=business;
        this.userProcessContainer=userProcessContainer;
        this.market=market;
        salesPersonCatalog=business.getSalesPersonCatalog();
      gap();
        marketTF.setText(market.getMarketname());
         tpo10();
    }
     public void showpersontpo(ArrayList<Salesperson>salespersoncatelog)
    {  
         ArrayList<Salesperson>findSalespersons=new ArrayList<Salesperson>();
          ArrayList<Salesperson>finalSalespersons=new ArrayList<Salesperson>();
         for(Salesperson salesperson:salespersoncatelog)
         {if(!findSalespersons.contains(salesperson))
         {findSalespersons.add(salesperson);}
         }
             Collections.sort(findSalespersons,new Comparator<Salesperson>()
                {
                    public int compare(Salesperson s1, Salesperson s2){
                        return Double.compare(s2.getMarketrevenue(), s1.getMarketrevenue());
                    }
                });
         
        DefaultTableModel jTable =(DefaultTableModel)personTB.getModel();
        jTable.setRowCount(0);
        int i=0;
        for (Salesperson salesperson:findSalespersons) {
        if(salesperson.getMarketrevenue()!=0){
            i++;
       Object row[]=new Object[3];
             row[0]=salesperson;
             row[1]=salesperson.getMarketrevenue();
             row[2]=salesperson.getGaprevenue();
           
        jTable.addRow(row);
        if(i ==10)
            return;
          }
        }
    }
      public void gap(){
         ArrayList<Salesperson>findSalespersons=new ArrayList<Salesperson>();
       double money=0.0;
        {
            for(Salesperson salesPerson:salesPersonCatalog.getSalesPersonList())
            {
            for(Order order:market.getOrderlist())
            {
                
               if(order.getSalesperson().equals(salesPerson))
                      
               {
                   money=money+order.getGaptarget();}
              
               
            }salesPerson.setGaprevenue(money); 
            findSalespersons.add(salesPerson);
            money=0.0;
            
        }
        }
     }
    
     public void tpo10(){
         ArrayList<Salesperson>findSalespersons=new ArrayList<Salesperson>();
       double money=0.0;
        {
            for(Salesperson salesPerson:salesPersonCatalog.getSalesPersonList())
            {
            for(Order order:market.getOrderlist())
            {
                
               if(order.getSalesperson().equals(salesPerson))
                      
               {
                   money=money+order.getOrderRevenue();}
              
               
            }salesPerson.setMarketrevenue(money); 
            findSalespersons.add(salesPerson);
            money=0.0;
            
        }showpersontpo(findSalespersons);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        personTB = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        marketTF = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        personTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "revenue", "gap"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(personTB);

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(marketTF, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(marketTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout =(CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField marketTF;
    private javax.swing.JTable personTB;
    // End of variables declaration//GEN-END:variables
}
