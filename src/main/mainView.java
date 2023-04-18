/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import sorting.MezclaN;
import java.io.*;

/**
 *
 * @author Alexandra
 */
public class mainView extends javax.swing.JFrame {

    /**
     * Creates new form mainView
     */
    public mainView() {
        initComponents();
        this.setLocationRelativeTo(null);
        sumaBtn.setEnabled(false);
        ordenamientoBtn.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ordenamientoTitle = new javax.swing.JLabel();
        idiomaLbl = new javax.swing.JLabel();
        idiomaList = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        sumaTitle = new javax.swing.JLabel();
        sumaBtn = new javax.swing.JButton();
        ordenamientoBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ordenamientoTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ordenamientoTitle.setText("Ordenamiento de fastText");

        idiomaLbl.setText("Selecciona un idioma:");

        idiomaList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Español", "Ingles", "Item 3", "Item 4" }));
        idiomaList.setSelectedIndex(-1);
        idiomaList.setRenderer(new PromptComboBoxRenderer("Default"));
        idiomaList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idiomaListItemStateChanged(evt);
            }
        });

        sumaTitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sumaTitle.setText("Suma vectorial");

        sumaBtn.setText("Sumar");
        sumaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sumaBtnMousePressed(evt);
            }
        });

        ordenamientoBtn.setText("Ordenar");
        ordenamientoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ordenamientoBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(ordenamientoTitle)
                    .addComponent(jSeparator1)
                    .addComponent(sumaTitle)
                    .addComponent(sumaBtn)
                    .addComponent(ordenamientoBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idiomaLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(idiomaList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(ordenamientoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idiomaLbl)
                    .addComponent(idiomaList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(ordenamientoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sumaTitle)
                .addGap(18, 18, 18)
                .addComponent(sumaBtn)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idiomaListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_idiomaListItemStateChanged
        idioma = (String) idiomaList.getSelectedItem();
        switch (idioma) {
            case "Español":
                file = new File("src/resources/dummyFile1.txt").getAbsolutePath();
                break;
            case "Ingles":
                file = new File("src/resources/dummyFile2.txt").getAbsolutePath();
                break;
            case "Italiano":
                file = new File("src/resources/dummyFile3.txt").getAbsolutePath();
                break;
            case "French":
                file = new File("src/resources/dummyFile3.txt").getAbsolutePath();
            default:
                System.out.println("No valid language");
                break;
        }
        System.out.println("idioma: " + idioma);
        ordenamientoBtn.setEnabled(true);

    }//GEN-LAST:event_idiomaListItemStateChanged

    private void ordenamientoBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordenamientoBtnMousePressed
        pane.showMessageDialog(this, "click");
        mezcla = new MezclaN();
        mezcla.MezclaNatural(file);
        sumaBtn.setEnabled(true);
    }//GEN-LAST:event_ordenamientoBtnMousePressed

    private void sumaBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sumaBtnMousePressed
        pane.showMessageDialog(this, "click");
    }//GEN-LAST:event_sumaBtnMousePressed

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
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new mainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idiomaLbl;
    private javax.swing.JComboBox<String> idiomaList;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton ordenamientoBtn;
    private javax.swing.JLabel ordenamientoTitle;
    private javax.swing.JButton sumaBtn;
    private javax.swing.JLabel sumaTitle;
    // End of variables declaration//GEN-END:variables
    private String idioma = "";
    private javax.swing.JOptionPane pane;
    private String file;
    private MezclaN mezcla;
}
