/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.projection.model;

import domain.CinemaHall;
import domain.Movie;
import domain.Projection;
import form.projection.FrmNewProjectionList;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import session.Session;

/**
 *
 * @author Vladan Simonovic
 */
public class TableModelProjection extends AbstractTableModel {

    private List<Projection> projections;

    private String[] header = new String[]{"Movie", "Cinema hall", "Projection date&time"};

    FrmNewProjectionList frmNewProjectionList;

    public TableModelProjection(List<Projection> projections) {
        this.projections = projections;

    }

    public void setFrmNewProjectionList(FrmNewProjectionList frmNewProjectionList) {
        this.frmNewProjectionList = frmNewProjectionList;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int i) {
        return header[i];
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Projection projection = projections.get(i);
        switch (i1) {
            case 0:
                if (projection.getMovie() != null) {
                    return projection.getMovie();
                }
            case 1:
                if (projection.getCinemaHall() != null) {
                    return projection.getCinemaHall();
                }
            case 2:
                if (projection.getProjectionDateTime() != null) {
                    return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(projection.getProjectionDateTime());
                }
            default:
                return "";
        }

    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        Projection projection = projections.get(i);
        switch (i1) {
            case 0:
                projection.setMovie((Movie) o);
                break;
            case 1:
                projection.setCinemaHall((CinemaHall) o);
                break;
            case 2:
                try {
                    projection.setProjectionDateTime(new SimpleDateFormat("dd.MM.yyyy HH:mm").parse((String) o));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmNewProjectionList, "Projection date&time incorrect!",
                            "Add new projection error", JOptionPane.ERROR_MESSAGE);
                }
        }
    }

    public void add() {
        Projection projection = new Projection();
        projection.setProjectionID((long) projections.size() + 1);
        projection.setUser(Session.getInstance().getCurrentUser());
        projections.add(projection);
        fireTableDataChanged();
        System.out.println("New projection added to the table.");
    }

    public void remove(int selectedRow) {
        projections.remove(selectedRow);
        fireTableDataChanged();
        System.out.println("Projection removed from table.");
    }

    @Override
    public int getRowCount() {
        return projections.size();
    }
    
    public Projection getProjection(int selectedRow) {
        Projection projection = projections.get(selectedRow);
        return projection;
    }

}
