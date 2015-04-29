/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propsandcovariants;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import surfacesandregions.SurfaceManager;



/**
 *
 * @author henrypinkard
 */
public class SurfaceDataImportDialog extends javax.swing.JDialog {

    private Object selectionMade_ = new Object();
    
   /**
    * Creates new form SurfaceDataImportDialog
    */
   public SurfaceDataImportDialog(java.awt.Frame parent, boolean modal) {
      super(parent, modal);
      initComponents();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }

   public String getSurfaceDataType() {
       while(this.isVisible()) {
           try {
               synchronized (selectionMade_) {
                   selectionMade_.wait();
               }
           } catch (InterruptedException ex) {
               //nothing to do
           }
       }
           
      return SurfaceData.enumerateDataTypes()[typeCombo_.getSelectedIndex()];
   }
   
   public String[] getSurfaceNames() {      
      String[] names = new String[surfaceList_.getSelectedIndices().length];
      for (int i = 0; i < names.length; i++) {
         names[i] = SurfaceManager.getInstance().getSurface(i).toString();
      }
      return names;
   } 
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        surfaceList_ = new javax.swing.JList();
        okButton_ = new javax.swing.JButton();
        cancelButton_ = new javax.swing.JButton();
        typeCombo_ = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        surfaceList_.setModel(new SurfaceDataImportListModel());
        jScrollPane1.setViewportView(surfaceList_);

        okButton_.setText("Ok");
        okButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButton_ActionPerformed(evt);
            }
        });

        cancelButton_.setText("Cancel");
        cancelButton_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton_ActionPerformed(evt);
            }
        });

        typeCombo_.setModel(new DefaultComboBoxModel(SurfaceData.enumerateDataTypes()));
        typeCombo_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeCombo_ActionPerformed(evt);
            }
        });

        jLabel1.setText("Type");

        jLabel2.setText("Associate with surfaces");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 30, Short.MAX_VALUE)
                        .addComponent(cancelButton_)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton_)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCombo_, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeCombo_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton_)
                    .addComponent(cancelButton_)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void okButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButton_ActionPerformed
      this.setVisible(false);
       this.dispose();
       synchronized (selectionMade_) {
           selectionMade_.notifyAll();
       }
   }//GEN-LAST:event_okButton_ActionPerformed

   private void cancelButton_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton_ActionPerformed
      this.setVisible(false);
       this.dispose();
       synchronized (selectionMade_) {
           selectionMade_.notifyAll();
       }
   }//GEN-LAST:event_cancelButton_ActionPerformed

   private void typeCombo_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeCombo_ActionPerformed
   }//GEN-LAST:event_typeCombo_ActionPerformed

class SurfaceDataImportListModel extends AbstractListModel {

   @Override
   public int getSize() {
      return SurfaceManager.getInstance().getNumberOfSurfaces();
   }

   @Override
   public Object getElementAt(int index) {
      return SurfaceManager.getInstance().getSurface(index).toString();
   }
   
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton_;
    private javax.swing.JList surfaceList_;
    private javax.swing.JComboBox typeCombo_;
    // End of variables declaration//GEN-END:variables
}
