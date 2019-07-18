/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.movie.model;

import domain.Movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vladan Simonovic
 */
public class TableModelMovie extends AbstractTableModel {

    private List<Movie> movies;

    private String[] header = new String[]{"Title", "Genre", "Released year", "Director"};

    public TableModelMovie(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getRowCount() {
        return movies.size();
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
        Movie movie = movies.get(i);
        switch (i1) {
            case 0:
                return movie.getTitle();
            case 1:
                return movie.getGenre().name();
            case 2:
                return movie.getReleaseYear();
            case 3:
                return movie.getDirector();
            default:
                return "N/A";
        }
    }

    public void remove(int selectedRow) {
       movies.remove(selectedRow);
       fireTableDataChanged();
        System.out.println("Movie removed from table.");
    }

}
