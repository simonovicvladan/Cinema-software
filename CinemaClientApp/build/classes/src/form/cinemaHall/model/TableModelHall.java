/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.cinemaHall.model;

import domain.CinemaHall;
import domain.Movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vladan Simonovic
 */
public class TableModelHall extends AbstractTableModel {

    private List<CinemaHall> halls;

    private String[] header = new String[]{"Name", "Type", "Number of seats"};

    public TableModelHall(List<CinemaHall> halls) {
        this.halls = halls;
    }

    public List<CinemaHall> getHalls() {
        return halls;
    }

    public void setHalls(List<CinemaHall> halls) {
        this.halls = halls;
    }

    @Override
    public int getRowCount() {
        return halls.size();
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
        CinemaHall hall = halls.get(i);
        switch (i1) {
            case 0:
                return hall.getName();
            case 1:
                return hall.getType().name();
            case 2:
                return hall.getNumberOfSeats();
            default:
                return "N/A";
        }
    }

    public void add(CinemaHall hall) {
        halls.add(hall);
        fireTableDataChanged();
        System.out.println("Hall added to the table.");
    }
    
    public void remove(int selectedRow) {
        halls.remove(selectedRow);
        fireTableDataChanged();
        System.out.println("Hall removed from table.");
    }

}
