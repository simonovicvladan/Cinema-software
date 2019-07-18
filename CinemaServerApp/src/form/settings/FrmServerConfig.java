/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.settings;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import util.SettingsLoader;

/**
 *
 * @author Vladan Simonovic
 */
public class FrmServerConfig extends javax.swing.JDialog {

    /**
     * Creates new form FrmServerConfig
     */
    public FrmServerConfig(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setCentered();
        populateSettings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSettings = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDatabaseName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDatabaseUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDatabasePassword = new javax.swing.JPasswordField();
        btnSaveChanges = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlSettings.setBorder(javax.swing.BorderFactory.createTitledBorder("Server settings"));

        jLabel1.setText("Database name:");

        jLabel2.setText("Database user:");

        jLabel3.setText("Database password:");

        javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
        pnlSettings.setLayout(pnlSettingsLayout);
        pnlSettingsLayout.setHorizontalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDatabaseUser)
                            .addComponent(txtDatabaseName)))
                    .addGroup(pnlSettingsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtDatabasePassword)))
                .addContainerGap())
        );
        pnlSettingsLayout.setVerticalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDatabaseUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatabasePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        btnSaveChanges.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSaveChanges.setForeground(new java.awt.Color(0, 153, 51));
        btnSaveChanges.setText("Save changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                        .addComponent(btnSaveChanges)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        String databaseName = txtDatabaseName.getText().trim();
        String databaseUser = txtDatabaseUser.getText().trim();
        String databasePassword = new String(txtDatabasePassword.getPassword());
        if (databaseName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Database name is required.", "Save changes error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String url = "jdbc:mysql://localhost:3306/" + databaseName;
            System.out.println(url);
            SettingsLoader.getInstance().setProperty("url", url);
            SettingsLoader.getInstance().setProperty("user", databaseUser);
            SettingsLoader.getInstance().setProperty("password", databasePassword);

            SettingsLoader.getInstance().getProps().store(new FileOutputStream("settings.properties"), null);

            JOptionPane.showMessageDialog(this, "Server configuration saved!");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occured while changing server configuration..",
                    "Save changes error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JTextField txtDatabaseName;
    private javax.swing.JPasswordField txtDatabasePassword;
    private javax.swing.JTextField txtDatabaseUser;
    // End of variables declaration//GEN-END:variables

    private void setCentered() {
        setLocationRelativeTo(null);
    }

    private void populateSettings() {
        String url = SettingsLoader.getInstance().getProperty("url");
        String[] url_parts = url.split("/");
        String databaseName = url_parts[url_parts.length - 1];
        String user = SettingsLoader.getInstance().getProperty("user");
        String pass = SettingsLoader.getInstance().getProperty("password");
    
        txtDatabaseName.setText(databaseName);
        txtDatabaseUser.setText(user);
        txtDatabasePassword.setText(pass);
    }
}
