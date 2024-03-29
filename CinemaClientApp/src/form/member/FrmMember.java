/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.member;

import controller.Controller;
import domain.Member;
import form.FrmMode;
import javax.swing.JOptionPane;
import session.Session;

/**
 *
 * @author Vladan Simonovic
 */
public class FrmMember extends javax.swing.JDialog {

    /**
     * Creates new form FrmMember
     */
    public FrmMember(java.awt.Frame parent, boolean modal, FrmMode mode) {
        super(parent, modal);
        initComponents();
        setCentered();

        adjustForm(mode);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCurrentUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblCurrentUser = new javax.swing.JLabel();
        pnlMember = new javax.swing.JPanel();
        lblMemberID = new javax.swing.JLabel();
        txtMemberID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlCurrentUser.setBorder(javax.swing.BorderFactory.createTitledBorder("User:"));

        jLabel1.setText("Current user:");

        lblCurrentUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCurrentUser.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout pnlCurrentUserLayout = new javax.swing.GroupLayout(pnlCurrentUser);
        pnlCurrentUser.setLayout(pnlCurrentUserLayout);
        pnlCurrentUserLayout.setHorizontalGroup(
            pnlCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblCurrentUser, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCurrentUserLayout.setVerticalGroup(
            pnlCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentUserLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblCurrentUser))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pnlMember.setBorder(javax.swing.BorderFactory.createTitledBorder("Member"));

        lblMemberID.setText("Member ID:");

        txtMemberID.setEditable(false);

        jLabel3.setText("Full name:");

        jLabel4.setText("Contact:");

        jLabel5.setText("Email:");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 153, 0));
        btnSave.setText("Save new member");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMemberLayout = new javax.swing.GroupLayout(pnlMember);
        pnlMember.setLayout(pnlMemberLayout);
        pnlMemberLayout.setHorizontalGroup(
            pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMemberID)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addGroup(pnlMemberLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMemberLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addComponent(txtMemberID)
                    .addComponent(txtFullName)
                    .addComponent(txtContact)
                    .addComponent(txtEmail))
                .addContainerGap())
        );
        pnlMemberLayout.setVerticalGroup(
            pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemberID)
                    .addComponent(txtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(pnlMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel)
                    .addComponent(btnClose))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCurrentUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit? Previous work won't be saved.", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String fullName = txtFullName.getText();
        String contact = txtContact.getText();
        String email = txtEmail.getText();
        if (fullName.isEmpty() || contact.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required! Check input.", "Save error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Member member = new Member(null, fullName, contact, email);
        try {
            Long createdMemberID = Controller.getInstance().saveMember(member);
            JOptionPane.showMessageDialog(this, "New member is created! Member ID: " + createdMemberID);

            int result = JOptionPane.showConfirmDialog(this, "New member?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                viewMember(new Member());
            } else {
                dispose();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Member not saved!", "Save error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JLabel lblMemberID;
    private javax.swing.JPanel pnlCurrentUser;
    private javax.swing.JPanel pnlMember;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtMemberID;
    // End of variables declaration//GEN-END:variables

    private void setCurrentUser() {
        lblCurrentUser.setText(Session.getInstance().getCurrentUser().toString());
    }

    private void setCentered() {
        setLocationRelativeTo(null);
    }

    private void adjustForm(FrmMode mode) {
        setCurrentUser();

        switch (mode) {
            case NEW:
                lblMemberID.setVisible(false);
                txtMemberID.setVisible(false);

                txtFullName.setEditable(true);
                txtContact.setEditable(true);
                txtEmail.setEditable(true);

                btnSave.setVisible(true);
                btnCancel.setVisible(true);
                btnClose.setVisible(false);

                setTitle("New member");
                break;
            case VIEW:
                lblMemberID.setVisible(true);
                txtMemberID.setVisible(true);

                txtFullName.setEditable(false);
                txtContact.setEditable(false);
                txtEmail.setEditable(false);

                btnSave.setVisible(false);
                btnCancel.setVisible(false);
                btnClose.setVisible(true);

                setTitle("View member");
                setMember();
                break;
        }
    }

    private void setMember() {
        Member member = (Member) Session.getInstance().getUseCaseParams().get("memberID");
        try {

            viewMember(member);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewMember(Member member) {
        txtMemberID.setText(String.valueOf(member.getMemberID()));
        txtFullName.setText(member.getFullName());
        txtContact.setText(member.getContact());
        txtEmail.setText(member.getEmail());

    }

}
