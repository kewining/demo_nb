/*
 * vista conultar ususario
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.model.user;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author kewining
 */
public class consultar_usuario extends javax.swing.JFrame {

    /**
     * Creates new form consultar_usuario
     */
    public consultar_usuario() {
        initComponents();
        setTitle("Consultar Usuario");
        actualizarBusqueda();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        cboParametroBusq = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtusuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("BUSCAR :");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbuscarKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
        });

        cboParametroBusq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Email" }));
        cboParametroBusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboParametroBusqActionPerformed(evt);
            }
        });

        jtusuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "EMAIL", "USERNAME", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtusuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtusuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboParametroBusq, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cboParametroBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyTyped
        // TODO add your handling code here:
        //ingresar 30 caracteres en txtbuscar
        if (txtbuscar.getText().length() == 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtbuscarKeyTyped

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        // TODO add your handling code here:
        //reconoce enter al pulsarlo sobre txtbuscar
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            actualizarBusqueda();
        }
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void cboParametroBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboParametroBusqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboParametroBusqActionPerformed

    private void jtusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtusuarioMouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jtusuarioMouseClicked

    private void actualizarBusqueda() {
        ArrayList<user> result = null;
        if (String.valueOf(cboParametroBusq.getSelectedItem()).equalsIgnoreCase("ID")) {
            result = app.controller.user.buscar_user_id(txtbuscar.getText());
        } else if (String.valueOf(cboParametroBusq.getSelectedItem()).equalsIgnoreCase("Name")) {
            result = app.controller.user.buscar_user_nombre(txtbuscar.getText());
        } else if (String.valueOf(cboParametroBusq.getSelectedItem()).equalsIgnoreCase("Email")) {
            result = app.controller.user.buscar_user_email(txtbuscar.getText());
        }
        recargarTable(result);
    }

    public void recargarTable(ArrayList<user> list) {
        Object[][] datos = new Object[list.size()][5];
        int i = 0;
        for (user us : list) {
            datos[i][0] = us.getid_user();
            datos[i][1] = us.getname();
            datos[i][2] = us.getemail();
            datos[i][3] = us.getusername();
            datos[i][4] = us.getid_status();

            i++;
        }
        
        jtusuario.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                new String[]{
                    "ID", "NAME", "EMAIL", "USERNAME", "STATUS"
                }) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new consultar_usuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboParametroBusq;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtusuario;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}