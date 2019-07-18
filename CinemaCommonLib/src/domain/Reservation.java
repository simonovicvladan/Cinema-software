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
public class Reservation implements GeneralEntity {

    private Long reservationID;
    private Date reservationDateTime;
    private int numberOfTickets;

    private Member member;
    private Projection projection;
    private User user;

    public Reservation() {
    }

    public Reservation(Long reservationID, Date reservationDateTime, int numberOfTickets, Member member, Projection projection, User user) {
        this.reservationID = reservationID;
        this.reservationDateTime = reservationDateTime;
        this.numberOfTickets = numberOfTickets;
        this.member = member;
        this.projection = projection;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Reservation) {
            Reservation r = (Reservation) o;
            if (r.getMember().equals(member)
                    && r.getProjection().equals(projection)) {
                 System.out.println("MEMBER: " + member + "\tProjection: " + projection.getProjectionID());
                return true;
            }
        }
        return false;
    }

    public Long getReservationID() {
        return reservationID;
    }

    public void setReservationID(Long reservationID) {
        this.reservationID = reservationID;
    }

    public Date getReservationDateTime() {
        return reservationDateTime;
    }

    public void setReservationDateTime(Date reservationDateTime) {
        this.reservationDateTime = reservationDateTime;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getTableName() {
        return "reservation";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        boolean joinedList = false;
        while (resultSet.next()) {

            Long dbReseravationID = resultSet.getLong("ReservationID");
            Date dbreservationDateTime = resultSet.getTimestamp("ReservationDateTime");

            Long dbuserID = resultSet.getLong("UserID");
            User dbuser = new User();
            user.setUserID(dbuserID);

            Long dbprojectionID = resultSet.getLong("ProjectionID");
            Projection projection = new Projection();
            projection.setProjectionID(dbprojectionID);
            Movie dbmovie = new Movie();
            CinemaHall dbcinemaHall = new CinemaHall();

            Long dbmemberID = resultSet.getLong("MemberID");
            Member member = new Member();
            member.setMemberID(dbmemberID);

            int dbnumberOfTickets = resultSet.getInt("NumberOfTickets");

            try {
                int i = resultSet.findColumn("Title"); // for example, if resultSet match this column
                joinedList = true;                     // it means that it is inner join
            } catch (Exception e) {
                if (e instanceof SQLException) {
                    joinedList = false;
                }
            }

            if (joinedList) {
                Date dbprojectionDateTime = resultSet.getTimestamp("ProjectionDateTime");
                projection.setProjectionDateTime(dbprojectionDateTime);

                String fullName = resultSet.getString("FullName");
                String contact = resultSet.getString("Contact");
                String email = resultSet.getString("Email");
                member.setFullName(fullName);
                member.setEmail(email);
                member.setContact(contact);

                Long movieID = resultSet.getLong("MovieID");
                Long cinemaHallID = resultSet.getLong("CinemaHallID");

                String dbTitle = resultSet.getString("Title");
                String dbGenre = resultSet.getString("Genre");
                int dbReleasedYear = resultSet.getInt("ReleasedYear");
                String dbDescription = resultSet.getString("Description");
                String dbDirector = resultSet.getString("Director");
                int dbDuration = resultSet.getInt("Duration");
                dbmovie.setMovieID(movieID);
                dbmovie.setTitle(dbTitle);
                dbmovie.setDescription(dbDescription);
                dbmovie.setDirector(dbDirector);
                dbmovie.setDuration(dbDuration);
                dbmovie.setGenre(Genre.valueOf(dbGenre));
                dbmovie.setReleaseYear(dbReleasedYear);

                String dbName = resultSet.getString("Name");
                String dbType = resultSet.getString("Type");
                int dbNumberOfSeats = resultSet.getInt("NumberOfSeats");
                dbcinemaHall.setCinemaHallID(cinemaHallID);
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

            projection.setCinemaHall(dbcinemaHall);
            projection.setMovie(dbmovie);
            projection.setUser(dbuser);

            Reservation reservation = new Reservation(dbReseravationID, dbreservationDateTime, dbnumberOfTickets, member, projection, dbuser);
            list.add(reservation);
        }
        return list;
    }

    @Override
    public String getConstraints(Object keyword) {
        return "";
    }

    @Override
    public GeneralEntity getOne(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(reservationDateTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String strReservationDateTime = df.format(cal.getTime());

        System.out.println(strReservationDateTime);
        return "" + reservationID + ", '" + strReservationDateTime + "', " + numberOfTickets + ", " + member.getMemberID()
                + ", " + projection.getProjectionID() + ", " + user.getUserID();
    }

    @Override
    public String getJoinedTables(boolean joined) {
        if (joined) {
            return " r\n"
                    + "	INNER JOIN member me ON r.MemberID = me.MemberID\n"
                    + "	INNER JOIN projection p ON r.ProjectionID = p.ProjectionID\n"
                    + "	INNER JOIN movie m ON p.MovieID = m.MovieID\n"
                    + "	INNER JOIN cinemahall ch ON p.CinemaHallID = ch.CinemaHallID\n"
                    + "	INNER JOIN cinema.user u ON r.UserID = u.UserID";
        } else {
            return "";
        }
    }

}
