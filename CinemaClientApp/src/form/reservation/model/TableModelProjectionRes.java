/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.reservation.model;

import domain.Projection;
import form.projection.FrmNewProjectionList;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vladan Simonovic
 */
public class TableModelProjectionRes extends AbstractTableModel {

    private List<Projection> projections;

    private String[] header = new String[]{"Projection date&time", "Movie", "Cinema hall"};

    FrmNewProjectionList frmNewProjectionList;

    public TableModelProjectionRes(List<Projection> projections) {
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
            case 1:
                if (projection.getMovie() != null) {
                    return projection.getMovie();
                }
            case 2:
                if (projection.getCinemaHall() != null) {
                    return projection.getCinemaHall();
                }
            case 0:
                if (projection.getProjectionDateTime() != null) {
                    return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(projection.getProjectionDateTime());
                }
            default:
                return "";
        }

    }

    @Override
    public int getRowCount() {
        return projections.size();
    }

}
