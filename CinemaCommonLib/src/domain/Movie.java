/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import transfer.util.InputUtil;

/**
 *
 * @author Vladan Simonovic
 */
public class Movie implements GeneralEntity {

    private Long movieID;
    private String title;
    private Genre genre;
    private int releasedYear;
    private String description;
    private String director;
    private int duration;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Movie) {
            Movie m = (Movie) o;
            if (m.getTitle().equalsIgnoreCase(this.title) && m.getReleaseYear() == this.releasedYear) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return title + " (" + releasedYear + ")";
    }

    public Movie() {
    }

    public Movie(Long movieID, String title, Genre genre, int releaseYear, String description, String director, int duration) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.releasedYear = releaseYear;
        this.description = description;
        this.director = director;
        this.duration = duration;
    }

    public Long getMovieID() {
        return movieID;
    }

    public void setMovieID(Long movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releasedYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releasedYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getTableName() {
        return "movie";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            Long movieID = resultSet.getLong("MovieID");
            String title = resultSet.getString("Title");
            String genre = resultSet.getString("Genre");
            int releasedYear = resultSet.getInt("ReleasedYear");
            String description = resultSet.getString("Description");
            String director = resultSet.getString("Director");
            int duration = resultSet.getInt("Duration");

            Movie movie = new Movie(movieID, title, Genre.valueOf(genre), releasedYear, description, director, duration);
            list.add(movie);
        }

        return list;
    }

    @Override
    public String getConstraints(Object keyword) {
        if (keyword instanceof String) {
            keyword = (String) keyword;
            if (keyword.equals("")) {
                return "";
            }
        }
        if (keyword instanceof char[]) {
            return " WHERE MovieID = " + movieID; // But also take care about structural constraints in database.
            // On DELETE movie RESTRICT projection ?!
        }

        return " WHERE Title LIKE '%" + keyword + "%' OR Genre LIKE '%" + keyword + "%' OR Director LIKE '%" + keyword + "%';";
    }

    @Override
    public GeneralEntity getOne(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        return "" + movieID + ",'" + InputUtil.escape(title) + "','" + genre + "'," + releasedYear + ",'"
                + InputUtil.escape(description) + "','" + InputUtil.escape(director) + "'," + duration;

    }

    @Override
    public String getJoinedTables(boolean joined) {
        return "";
    }

}
