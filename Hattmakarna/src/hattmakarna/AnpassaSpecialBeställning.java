/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package hattmakarna;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;
//hej
/**
 * @author seansiik
 */
public class AnpassaSpecialBeställning extends javax.swing.JFrame {

    
    
    private static InfDB idb; 
    /**
     * Creates new form AnpassaSpecialBeställning
     */
    public AnpassaSpecialBeställning(InfDB idb) {
        this.idb = idb;
        initComponents();
        loadData();
        tableSpecialBeställningar.setAutoCreateRowSorter(true);
    }
    
        private void loadData() {
    try {
        String sql = "SELECT ProduktID, Namn, pris from produkt WHERE Specialbeställning = true";
        ArrayList<HashMap<String, String>> result = idb.fetchRows(sql);
        
        DefaultTableModel model = (DefaultTableModel) tableSpecialBeställningar.getModel();
        model.setRowCount(0);

        for (HashMap<String, String> rad : result) {
              ((DefaultTableModel) tableSpecialBeställningar.getModel()).addRow(new Object[]{
                    rad.get("ProduktID"), rad.get("Namn"), rad.get("pris")

              
            });
        }

    } catch (InfException e) {
        lblFelmed.setText("Fel vid hämtning av specialbeställningar.");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSpecialBeställningar = new javax.swing.JTable();
        BtnÄndra = new javax.swing.JButton();
        lblFelmed = new javax.swing.JLabel();
        lblAnpassaSpecBeställning = new javax.swing.JLabel();
        tfNyttPris = new javax.swing.JTextField();
        lblNyttPris = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableSpecialBeställningar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ProduktID", "Namn", "Pris"
            }
        ));
        jScrollPane1.setViewportView(tableSpecialBeställningar);
        if (tableSpecialBeställningar.getColumnModel().getColumnCount() > 0) {
            tableSpecialBeställningar.getColumnModel().getColumn(0).setMinWidth(0);
            tableSpecialBeställningar.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableSpecialBeställningar.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        BtnÄndra.setText("Ändra");
        BtnÄndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnÄndraActionPerformed(evt);
            }
        });

        lblAnpassaSpecBeställning.setText("Anpassa Specialbeställning");

        lblNyttPris.setText("Nytt pris ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAnpassaSpecBeställning, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(lblFelmed, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNyttPris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfNyttPris, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnÄndra)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblAnpassaSpecBeställning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFelmed)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblNyttPris)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnÄndra)
                    .addComponent(tfNyttPris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnÄndraActionPerformed


    int row = tableSpecialBeställningar.getSelectedRow();
    if (row != -1) {
        String produktID = (String) tableSpecialBeställningar.getValueAt(row, 0);
        String namn = (String) tableSpecialBeställningar.getValueAt(row, 1);
        String prisStr = tfNyttPris.getText();
        
        if (!validering.isValidDecimal(prisStr)) {
           lblFelmed.setText("Pris måste vara ett giltigt decimaltal.");
           return;
        }

        try {
            double nyttPris = Double.parseDouble(prisStr);
            
            String sql = "UPDATE produkt SET pris = " + nyttPris + " WHERE ProduktID = '" + produktID + "'";            
            idb.update(sql);
            
            lblFelmed.setText("Priset för " + namn + " har ändrats!");

            
            ((DefaultTableModel) tableSpecialBeställningar.getModel()).setRowCount(0);
            loadData();

       
        } catch (InfException e) {
            lblFelmed.setText("Fel vid uppdatering: " + e.getMessage());
        }
         
        } else {
            lblFelmed.setText("Välj en rad att ändra.");
    
    }  
    }//GEN-LAST:event_BtnÄndraActionPerformed

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
            java.util.logging.Logger.getLogger(AnpassaSpecialBeställning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnpassaSpecialBeställning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnpassaSpecialBeställning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnpassaSpecialBeställning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AnpassaSpecialBeställning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnÄndra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnpassaSpecBeställning;
    private javax.swing.JLabel lblFelmed;
    private javax.swing.JLabel lblNyttPris;
    private javax.swing.JTable tableSpecialBeställningar;
    private javax.swing.JTextField tfNyttPris;
    // End of variables declaration//GEN-END:variables
}
