/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hattmakarna;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;




/**
 *
 * @author Mohammed
 */
public class SkrivUtFraktsedel extends javax.swing.JFrame {
    
    private static InfDB idb;
    /**
     * Creates new form SkrivUtFraktsedel
     */
    public SkrivUtFraktsedel(InfDB idb) {
        initComponents();
        this.idb = idb;
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfFraktId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFrakt = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblFelmed = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Skriv ut fraktsedel");

        jLabel2.setText("Frakt id");

        tblFrakt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fraktid", "Avsändare", "Adress", "Vikt", "Beskrivning", "Mottagare", "Pris", "Order id"
            }
        ));
        jScrollPane2.setViewportView(tblFrakt);
        if (tblFrakt.getColumnModel().getColumnCount() > 0) {
            tblFrakt.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setText("Hämta data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Skriv ut");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tfFraktId, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFelmed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(tfFraktId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34)
                            .addComponent(jButton2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblFelmed)
                        .addComponent(jButton1)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String getFrakts = "SELECT * FROM frakt";
        
        ArrayList<HashMap<String, String>> frakts = new ArrayList<>();
        
        try{
            frakts = idb.fetchRows(getFrakts);
        } catch (InfException e){
            lblFelmed.setText("Problem med att hämta frakter.");
        }
        
        for (HashMap<String, String> row : frakts){
            String fraktId = row.get("FraktID");
            String avsändare = row.get("Avsändare");
            String adress = row.get("Adress");
            String vikt = row.get("vikt");
            String beskrivning = row.get("Beskrivning");
            String mott_id = row.get("Mottagare");
            String pris = row.get("Pris");
            String oid = row.get("OID");
            
            ((DefaultTableModel) tblFrakt.getModel()).addRow(new Object[]{fraktId, avsändare, adress, vikt, beskrivning, mott_id, pris, oid});

            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String fraktId = tfFraktId.getText();
        
        String getFrakt = "SELECT * FROM frakt WHERE fraktid = '" + fraktId + "'";
        
        HashMap<String, String> frakt = null;
        
        try{
            frakt = idb.fetchRow(getFrakt);
        } catch (InfException e){
            lblFelmed.setText("Problem med att hämta frakten från databasen.");
        }
        
        // Hämta kundens namn
        
        if (frakt == null){
            lblFelmed.setText("Frakten kunde inte hittas. Försök igen.");
            return;
        }
        
        String getNamn = "SELECT förnamn, efternamn FROM kund WHERE kundid = '" + frakt.get("Mottagare") + "'";
        HashMap<String, String> namn = null;
        
        try{
            namn = idb.fetchRow(getNamn);
        } catch (InfException e){
            lblFelmed.setText("Problem med att hämta kundens namn");
        }
        
        if (namn == null){
            lblFelmed.setText("Kundens namn finns inte i databasen.");
            return;
        }
        
        String förnamn = namn.get("Förnamn");
        String efternamn = namn.get("Efternamn");
        
        // Lägg in allt i en pdf
        try {
            // Skapa ett nytt dokument
            Document document = new Document();
            
            Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
            Font bodyFont = FontFactory.getFont(FontFactory.HELVETICA, 18);

            double d_pris = Double.parseDouble(frakt.get("Pris"));

            // Ange var du vill spara PDF-filen
            String path = System.getProperty("user.home") + "/Desktop/fraktinfo.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(path));


            // Öppna dokumentet för att börja skriva
            document.open();

            // Lägg till innehållet
            document.add(new Paragraph("Fraktinformation", headerFont));
            document.add(new Paragraph("--------------------------", bodyFont));
            document.add(new Paragraph("Frakt-ID: " + fraktId, bodyFont));
            document.add(new Paragraph("Avsändare: " + frakt.get("Avsändare"), bodyFont));
            document.add(new Paragraph("Adress: " + frakt.get("Adress"), bodyFont));
            document.add(new Paragraph("Vikt: " + frakt.get("vikt"), bodyFont));
            document.add(new Paragraph("Beskrivning: " + frakt.get("Beskrivning"), bodyFont));
            document.add(new Paragraph("Pris: " + frakt.get("Pris"), bodyFont));
            document.add(new Paragraph("Moms: " + d_pris * 0.25 , bodyFont));
            document.add(new Paragraph("Pris inkl. moms: " + d_pris * 1.25, bodyFont));
            document.add(new Paragraph("Mottagare: " + förnamn + " " + efternamn, bodyFont));
            document.add(new Paragraph("Export kod: " + frakt.get("exportkod"), bodyFont));
            // Stäng dokumentet
            document.close();

            // Bekräfta till användaren
            lblFelmed.setText("PDF skapad som 'fraktinfo.pdf'!");
        } catch (Exception e) {
            lblFelmed.setText("Fel vid skapandet av PDF: " + e.getMessage());
            e.printStackTrace();
        }


        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(SkrivUtFraktsedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SkrivUtFraktsedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SkrivUtFraktsedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SkrivUtFraktsedel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SkrivUtFraktsedel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFelmed;
    private javax.swing.JTable tblFrakt;
    private javax.swing.JTextField tfFraktId;
    // End of variables declaration//GEN-END:variables
}
