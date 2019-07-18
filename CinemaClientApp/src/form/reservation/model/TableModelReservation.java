/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.reservation.model;

import domain.Reservation;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vladan Simonovic
 */
public class TableModelReservation extends AbstractTableModel {

    private List<Reservation> reservations;
    private String[] header = new String[]{"Member", "Reservation Date&Time", "Projection Date&Time", "Movie", "Cinema Hall"};

    public TableModelReservation(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    @Override
    public int getRowCount() {
        return reservations.size();
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
        Reservation reservation = reservations.get(i);
        switch (i1) {
            case 0:
                return reservation.getMember();
            case 1:
                if (reservation.getReservationDateTime() != null) {
                    return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(reservation.getReservationDateTime());

                }
            case 2:
                if (reservation.getProjection() != null) {
                    return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(reservation.getProjection().getProjectionDateTime());
                }
            case 3:
                if (reservation.getProjection() != null) {
                    return reservation.getProjection().getMovie();

                }
            case 4:
                if (reservation.getProjection() != null) {
                    return reservation.getProjection().getCinemaHall();

                }

            default:
                return "N/A";
        }
    }

    public void add(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("New reservation added to the table.");
        fireTableDataChanged();
    }

}
