
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hattmakarna;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author minna
 */
public class NySkapaOrder extends javax.swing.JFrame {
 private InfDB idb;
 private String pid;
    /**
     * Creates new form NySkapaOrder
     */
    public NySkapaOrder(InfDB idb, String pid) {
        initComponents();
         this.idb = idb; 
         this.pid = pid;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboExpress = new javax.swing.JComboBox<>();
        tfID = new javax.swing.JTextField();
        tfStatus = new javax.swing.JTextField();
        tfDatum = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        btnLaggTill = new javax.swing.JButton();
        btnTillbaka = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOrder = new javax.swing.JTable();
        btnAndra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Skapa order");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("order-ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Datum");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Express");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Email");

        ComboExpress.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ja", "Nej" }));

        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        btnLaggTill.setText("Lägg till ");
        btnLaggTill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillActionPerformed(evt);
            }
        });

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        TableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Status", "Datum", "Email", "Express"
            }
        ));
        jScrollPane1.setViewportView(TableOrder);

        btnAndra.setText("Ändra");
        btnAndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ComboExpress, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfStatus)
                    .addComponent(tfDatum)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(127, 127, 127)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnAndra, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnLaggTill, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ComboExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLaggTill, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAndra, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTillbaka, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDActionPerformed

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
            new GuiHuvudmeny(idb, pid).setVisible(true);
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnLaggTillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillActionPerformed
    
        //Hämtar data från textfälten
        String ID = tfID.getText();
        String Status = tfStatus.getText();
        String Datum = tfDatum.getText();
        String Email= tfEmail.getText();
        
        String expressStr = (String) ComboExpress.getSelectedItem();
        boolean Express = expressStr.equals("Ja");        
        
        // Kontroll: alla fält måste vara ifyllda
        if (ID.isEmpty() || Status.isEmpty() || Datum.isEmpty()|| Email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fyll i alla fält!", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!validering.isNumerisk(ID)) {
        JOptionPane.showMessageDialog(this, "ID måste vara numeriskt.", "Fel", JOptionPane.ERROR_MESSAGE);
        return;
        }

        if (!validering.isNotEmpty(Status)) {
        JOptionPane.showMessageDialog(this, "Status får inte vara tomt.", "Fel", JOptionPane.ERROR_MESSAGE);
        return;
        }

        if (!validering.isValidDatum(Datum)) {
        JOptionPane.showMessageDialog(this, "Datum måste vara i formatet ÅÅÅÅ-MM-DD.", "Fel", JOptionPane.ERROR_MESSAGE);
        return;
}

        try {
        
        String kontrollFraga = "SELECT KundID FROM kund WHERE Email = '" + Email + "'";
        
        HashMap<String, String> kund = null;
        
        kund = idb.fetchRow(kontrollFraga);

        if (kund == null || kund.isEmpty()) {
         new GuiValFönster(idb, pid).setVisible(true);
        this.dispose(); 
        return;
          
        }
        String KundID= kund.get("KundID");
        String sql = "INSERT INTO ordrar (OID, Status, Datum, express, KundID)" + 
                     "VALUES ('" + ID + "', '" + Status + "', '" + Datum + "', " + Express + ",'" + KundID + "')";

        idb.insert(sql);
        
                         

        // Lägger till raden i tabellen i GUI:t
        DefaultTableModel tableModel = (DefaultTableModel) TableOrder.getModel();
        tableModel.addRow(new Object[]{ID, Status, Datum, Email, Express});

         // Rensar textfälten efter insättning
        tfID.setText("");
        tfStatus.setText("");
        tfDatum.setText("");
        tfEmail.setText(""); 
        ComboExpress.setSelectedIndex(0);        
       
    } catch (InfException e) {
         JOptionPane.showMessageDialog(this, "Fel vid databasinsättning: " + e.getMessage(), "Fel", JOptionPane.ERROR_MESSAGE);
        
      }    // TODO add your handling code here:
    }//GEN-LAST:event_btnLaggTillActionPerformed

    private void btnAndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraActionPerformed
        //Hämtar vald rad i tabellen
        int selectedRow = TableOrder.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) TableOrder.getModel();

        if (selectedRow != -1) { //Kontrollerar om en rad blivit vald

            // Hämtar nya värden från textFälten, men behåller den gamla infon om fältet är tomt
            String nyttID = tfID.getText().isEmpty() ? model.getValueAt(selectedRow, 0).toString() : tfID.getText();
            String nyStatus = tfStatus.getText().isEmpty() ? model.getValueAt(selectedRow, 1).toString() : tfStatus.getText();
            String nyttDatum = tfDatum.getText().isEmpty() ? model.getValueAt(selectedRow, 2).toString() : tfDatum.getText();
            String nyttKundID = tfEmail.getText().isEmpty() ? model.getValueAt(selectedRow, 3).toString() : tfEmail.getText();
            String nyExpressStr = (String) ComboExpress.getSelectedItem();
            boolean nyExpress = nyExpressStr.equals("Ja");
            

        if (!tfDatum.getText().isEmpty() && !validering.isValidDatum(nyttDatum)) {
            JOptionPane.showMessageDialog(this, "Datum måste vara i formatet ÅÅÅÅ-MM-DD.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!tfEmail.getText().isEmpty() && !validering.isNumerisk(nyttKundID)) {
            JOptionPane.showMessageDialog(this, "KundID måste vara numeriskt.", "Fel", JOptionPane.ERROR_MESSAGE);
            return;
        }

            // Uppdaterar tabellens modell med de nya värdena
            model.setValueAt(nyttID, selectedRow, 0);
            model.setValueAt(nyStatus, selectedRow, 1);
            model.setValueAt(nyttDatum, selectedRow, 2);
            model.setValueAt(nyttKundID, selectedRow, 3);
            model.setValueAt(nyExpress, selectedRow, 4);
      
            // Bekräftelsemeddelande
            JOptionPane.showMessageDialog(null, "Ordern har uppdaterats!", "Ändrat", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Om ingen rad är vald
            JOptionPane.showMessageDialog(null, "Välj en order att ändra!", "Fel", JOptionPane.WARNING_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAndraActionPerformed

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
            java.util.logging.Logger.getLogger(NySkapaOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NySkapaOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NySkapaOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NySkapaOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NySkapaOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboExpress;
    private javax.swing.JTable TableOrder;
    private javax.swing.JButton btnAndra;
    private javax.swing.JButton btnLaggTill;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfDatum;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfStatus;
    // End of variables declaration//GEN-END:variables
}

