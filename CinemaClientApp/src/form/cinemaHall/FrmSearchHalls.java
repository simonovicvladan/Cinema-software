/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.cinemaHall;

import form.movie.*;
import communication.Communication;
import controller.Controller;
import domain.CinemaHall;
import domain.Movie;
import form.FrmMode;
import form.cinemaHall.model.TableModelHall;
import form.movie.model.TableModelMovie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author Vladan Simonovic
 */
public class FrmSearchHalls extends javax.swing.JPanel {

    /**
     * Creates new form FrmSearchHalls
     */
    public FrmSearchHalls() {
        initComponents();
        setCurrentUser();
        prepareTableHalls();
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
        pnlMovies = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHalls = new javax.swing.JTable();
        btnDetails = new javax.swing.JButton();

        pnlCurrentUser.setBorder(javax.swing.BorderFactory.createTitledBorder("User"));

        jLabel1.setText("Current user:");

        lblCurrentUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCurrentUser.setForeground(new java.awt.Color(51, 0, 204));

        javax.swing.GroupLayout pnlCurrentUserLayout = new javax.swing.GroupLayout(pnlCurrentUser);
        pnlCurrentUser.setLayout(pnlCurrentUserLayout);
        pnlCurrentUserLayout.setHorizontalGroup(
            pnlCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentUserLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCurrentUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCurrentUserLayout.setVerticalGroup(
            pnlCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlCurrentUserLayout.createSequentialGroup()
                        .addComponent(lblCurrentUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pnlMovies.setBorder(javax.swing.BorderFactory.createTitledBorder("Cinema Halls"));

        jLabel2.setText("Keyword:");

        btnSearch.setText("Search for halls");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblHalls.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblHalls);

        btnDetails.setForeground(new java.awt.Color(0, 102, 0));
        btnDetails.setText("Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMoviesLayout = new javax.swing.GroupLayout(pnlMovies);
        pnlMovies.setLayout(pnlMoviesLayout);
        pnlMoviesLayout.setHorizontalGroup(
            pnlMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoviesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMoviesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtKeyword))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMoviesLayout.createSequentialGroup()
                        .addGap(0, 774, Short.MAX_VALUE)
                        .addGroup(pnlMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDetails, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        pnlMoviesLayout.setVerticalGroup(
            pnlMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoviesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoviesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDetails)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlMovies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCurrentUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMovies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String keyword = txtKeyword.getText().trim();
            Communication.getInstance().sendRequest(new Request(Operation.OPERATION_SEARCH_CINEMA_HALLS, keyword));
            Response response = Communication.getInstance().readResponse();
            if (response.getStatus() == ResponseStatus.OK) {
                TableModelHall model = (TableModelHall) tblHalls.getModel();
                List<CinemaHall> halls = (List<CinemaHall>) response.getData();
                model.setHalls(halls);
                for (CinemaHall hall : halls) {
                    System.out.println(hall);
                }
                if (halls.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Cinema halls with keyword " + keyword + " not found!",
                            "Search error", JOptionPane.ERROR_MESSAGE);
                    model.setHalls(new ArrayList<>());
                    return;
                }
                JOptionPane.showMessageDialog(this, "Cinema halls with keyword " + keyword + " are found!");
                model.fireTableDataChanged();
            } else {
                JOptionPane.showMessageDialog(this, "Cinema halls not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        TableModelHall model = (TableModelHall) tblHalls.getModel();
        int selectedRow = tblHalls.getSelectedRow();
        if (selectedRow != -1) {
            CinemaHall hall = model.getHalls().get(selectedRow);
            Session.getInstance().getUseCaseParams().clear();
            Session.getInstance().getUseCaseParams().put("hallID", hall);

            FrmCinemaHall frmCinemaHall = new FrmCinemaHall(null, true, FrmMode.VIEW);
            frmCinemaHall.setVisible(true);
            frmCinemaHall.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(this, "Cinema hall is not selected!", "Details error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JPanel pnlCurrentUser;
    private javax.swing.JPanel pnlMovies;
    private javax.swing.JTable tblHalls;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables

    private void setCurrentUser() {
        lblCurrentUser.setText(Session.getInstance().getCurrentUser().toString());
    }

    private void prepareTableHalls() {
        try {
            List<CinemaHall> allHalls = Controller.getInstance().getAllHalls();
            TableModelHall model = new TableModelHall(allHalls);
            tblHalls.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Table preparation failed.", JOptionPane.ERROR_MESSAGE);
        }
    }
}
