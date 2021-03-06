/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.*;
import java.awt.CardLayout;
import javax.swing.JPanel;
import UserInterface.AdminRole.ManagePerformance;
import UserInterface.AdminRole.SupplierWorkAreaJPanel;
import UserInterface.SalePerson.*;
import UserInterface.SupplierRole.*;
import UserInterface.AdminRole.ManageSalesperson;
/**
 *
 * @author james
 */
public class ManageArea extends javax.swing.JPanel {

    private  JPanel userProcessContainer;
    
    private Business business;

    ManageArea(JPanel userProcessContainer,Business business) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.business=business;
        
       
        userTF.setText(business.getID());
        
        
            
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
        jLabel1 = new javax.swing.JLabel();
        userTF = new javax.swing.JTextField();
        managepersonBtn = new javax.swing.JButton();
        masupBtn = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setText("UserID:");

        userTF.setEditable(false);

        managepersonBtn.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        managepersonBtn.setText("Manage SalesPerson");
        managepersonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managepersonBtnActionPerformed(evt);
            }
        });

        masupBtn.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        masupBtn.setText("Manage Supplier");
        masupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masupBtnActionPerformed(evt);
            }
        });

        btnLogout.setText("<<Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jButton1.setLabel("Performance");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLogout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(masupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managepersonBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(252, 252, 252))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(masupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(managepersonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void managepersonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managepersonBtnActionPerformed
        ManageSalesperson msp=new  ManageSalesperson(userProcessContainer,business);
        userProcessContainer.add("SalesPersonWorkAreaJPanel",msp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.show(userProcessContainer,"SalesPersonWorkAreaJPanel");
    }//GEN-LAST:event_managepersonBtnActionPerformed

    private void masupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masupBtnActionPerformed
         SupplierWorkAreaJPanel spwajp=new  SupplierWorkAreaJPanel(userProcessContainer,business);
        userProcessContainer.add("SupplierWorkAreaJPanel",spwajp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.show(userProcessContainer,"SupplierWorkAreaJPanel");
    }//GEN-LAST:event_masupBtnActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
         CardLayout layout = (CardLayout) userProcessContainer.getLayout();
         layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ManagePerformance mp=new  ManagePerformance(userProcessContainer,business);
        userProcessContainer.add("ManagePerformance",mp);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.show(userProcessContainer,"ManagePerformance");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton managepersonBtn;
    private javax.swing.JButton masupBtn;
    private javax.swing.JTextField userTF;
    // End of variables declaration//GEN-END:variables
}
