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
public class CinemaHall implements GeneralEntity {

    private Long cinemaHallID;
    private String name;
    private CinemaHallType type;
    private int numberOfSeats;

    @Override
    public boolean equals(Object o) {
        if (o instanceof CinemaHall) {
            CinemaHall ch = (CinemaHall) o;
            if (ch.getName().equalsIgnoreCase(this.name)) {
                return true;
            }
        }
        return false;
    }

    
    
    @Override
    public String toString() {
        return name + "-" + type;
    }

    public CinemaHall() {
    }

    public CinemaHall(Long cinemaHallID, String name, CinemaHallType type, int numberOfSeats) {
        this.cinemaHallID = cinemaHallID;
        this.name = name;
        this.type = type;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getCinemaHallID() {
        return cinemaHallID;
    }

    public void setCinemaHallID(Long cinemaHallID) {
        this.cinemaHallID = cinemaHallID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CinemaHallType getType() {
        return type;
    }

    public void setType(CinemaHallType type) {
        this.type = type;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String getTableName() {
        return "cinemahall";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            Long cinemaHallID = resultSet.getLong("CinemaHallID");
            String name = resultSet.getString("Name");
            String type = resultSet.getString("Type");
            int numberOfSeats = resultSet.getInt("NumberOfSeats");
            CinemaHall hall = new CinemaHall(cinemaHallID, name, CinemaHallType.valueOf(type), numberOfSeats);
            list.add(hall);
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
            return " WHERE CinemaHallID = " + cinemaHallID; // But also take care about structural constraints in database.
            // On DELETE cinemahall RESTRICT projection ?!
        }

        return " WHERE Name LIKE '%" + keyword + "%' OR Type LIKE '%" + keyword + "%'";
    }

    @Override
    public GeneralEntity getOne(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        return "" + cinemaHallID + ",'" + InputUtil.escape(name) + "','" + type.name() + "'," + numberOfSeats + "";
    }

    @Override
    public String getJoinedTables(boolean joined) {
        return "";
    }

}
