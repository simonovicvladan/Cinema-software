/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vladan Simonovic
 */
public class Projection implements GeneralEntity {

    private Long projectionID;
    private Date projectionDateTime;

    private User user;
    private Movie movie;
    private CinemaHall cinemaHall;

    
    
    public Projection() {
    }

    public Projection(Long projectionID, Date projectionDateTime, User user, Movie movie, CinemaHall cinemaHall) {
        this.projectionID = projectionID;
        this.projectionDateTime = projectionDateTime;
        this.user = user;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Projection) {
            Projection p = (Projection) o;
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(p.getProjectionDateTime());
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(projectionDateTime);
            if (p.getCinemaHall().getCinemaHallID().equals(cinemaHall.getCinemaHallID())
                    && cal1.equals(cal2)) {
                System.out.println("EQUAL");
                return true;
            }
        }
        return false;
    }

    public Long getProjectionID() {
        return projectionID;
    }

    public void setProjectionID(Long projectionID) {
        this.projectionID = projectionID;
    }

    public Date getProjectionDateTime() {
        return projectionDateTime;
    }

    public void setProjectionDateTime(Date projectionDateTime) {
        this.projectionDateTime = projectionDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    @Override
    public String getTableName() {
        return "projection";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        boolean joinedList = false;
        while (resultSet.next()) {

            Long dbprojectionID = resultSet.getLong("ProjectionID");
            Date dbprojectionDateTime = resultSet.getTimestamp("ProjectionDateTime");

            Long userID = resultSet.getLong("UserID");
            Long movieID = resultSet.getLong("MovieID");
            Long cinemaHallID = resultSet.getLong("CinemaHallID");

            try {
                int i = resultSet.findColumn("Title"); // for example, if resultSet match this column
                joinedList = true;                     // it means that it is inner join
            } catch (Exception e) {
                if (e instanceof SQLException) {
                    joinedList = false;
                }
            }
            Projection projection = new Projection();

            Movie dbmovie = new Movie();
            CinemaHall dbcinemaHall = new CinemaHall();
            User dbuser = new User();

            if (joinedList) {
                String dbTitle = resultSet.getString("Title");
                String dbGenre = resultSet.getString("Genre");
                int dbReleasedYear = resultSet.getInt("ReleasedYear");
                String dbDescription = resultSet.getString("Description");
                String dbDirector = resultSet.getString("Director");
                int dbDuration = resultSet.getInt("Duration");
                dbmovie.setTitle(dbTitle);
                dbmovie.setDescription(dbDescription);
                dbmovie.setDirector(dbDirector);
                dbmovie.setDuration(dbDuration);
                dbmovie.setGenre(Genre.valueOf(dbGenre));
                dbmovie.setReleaseYear(dbReleasedYear);

                String dbName = resultSet.getString("Name");
                String dbType = resultSet.getString("Type");
                int dbNumberOfSeats = resultSet.getInt("NumberOfSeats");
                dbcinemaHall.setName(dbName);
                dbcinemaHall.setType(CinemaHallType.valueOf(dbType));
                dbcinemaHall.setNumberOfSeats(dbNumberOfSeats);

                String dbFullName = resultSet.getString("FullName");
                String dbUsename = resultSet.getString("Username");
                String dbPassword = resultSet.getString("Password");
                String dbEmail = resultSet.getString("Email");
                dbuser.setEmail(dbEmail);
                dbuser.setFullName(dbFullName);
                dbuser.setPassword(dbPassword);
                dbuser.setUsername(dbUsename);
            }

            dbcinemaHall.setCinemaHallID(cinemaHallID);
            dbmovie.setMovieID(movieID);
            dbuser.setUserID(userID);

            DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            String strDat = df.format(dbprojectionDateTime);
            System.out.println(strDat);

            projection.setProjectionID(dbprojectionID);
            projection.setProjectionDateTime(dbprojectionDateTime);
            projection.setCinemaHall(dbcinemaHall);
            projection.setMovie(dbmovie);
            projection.setUser(dbuser);

            list.add(projection);
        }
        System.out.println("PROJECTION LIST SELECTED.");
        return list;
    }

    @Override
    public String getConstraints(Object keyword) {
        if (keyword instanceof String) {
            keyword = (String) keyword;

            if (keyword.equals("m.Title")) {
                return " ORDER BY m.Title";
            } else if (keyword.equals("p.ProjectionDateTime")) {
                return " ORDER BY p.ProjectionDateTime";
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

//        return " WHERE Name LIKE '%" + keyword + "%' OR Type LIKE '%" + keyword + "%'";
    @Override
    public GeneralEntity getOne(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(projectionDateTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strProjectionDateTime = df.format(cal.getTime());

        System.out.println(strProjectionDateTime);
        return "" + projectionID + ", '" + strProjectionDateTime
                + "', " + user.getUserID() + ", " + movie.getMovieID() + ", " + cinemaHall.getCinemaHallID();
    }

    @Override
    public String getJoinedTables(boolean joined) {
        if (joined) {
            return " p INNER JOIN movie m ON p.MovieID = m.MovieID"
                    + " INNER JOIN cinemahall ch ON p.CinemaHallID = ch.CinemaHallID"
                    + " INNER JOIN cinema.user u ON p.UserID = u.UserID";
        } else {
            return "";
        }

    }

}
