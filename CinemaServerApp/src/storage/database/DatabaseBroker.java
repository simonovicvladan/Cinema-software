package storage.database;

import domain.CinemaHall;
import domain.GeneralEntity;
import domain.Member;
import domain.Movie;
import domain.Projection;
import domain.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import storage.IDatabaseBroker;
import storage.database.connection.DatabaseConnection;

public class DatabaseBroker implements IDatabaseBroker {

    @Override
    public List<GeneralEntity> getAll(GeneralEntity entity, String keyword) throws Exception {
        List<GeneralEntity> list;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();

            String query = "SELECT * FROM " + entity.getTableName() + entity.getConstraints(keyword);
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException ex) {
//            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<GeneralEntity> getAll(GeneralEntity entity) throws Exception {
        List<GeneralEntity> list;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();

            String query = "SELECT * FROM " + entity.getTableName();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException ex) {
//            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public List<GeneralEntity> getAll(GeneralEntity entity, String keyword, boolean joined) throws Exception {
        List<GeneralEntity> list;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();

            String query = "SELECT * FROM " + entity.getTableName() + entity.getJoinedTables(joined) + entity.getConstraints(keyword);
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = entity.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (SQLException ex) {
//            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public GeneralEntity getOne(GeneralEntity entity) throws Exception {
        GeneralEntity generalEntity;
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM " + entity.getTableName() + entity.getConstraints(null);
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            generalEntity = entity.getOne(resultSet);
            resultSet.close();
            statement.close();
            return generalEntity;
        } catch (SQLException ex) {
//            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public long save(List<GeneralEntity> entities) throws Exception {
//        List<GeneralEntity> entiteties = (List<GeneralEntity>) entities;
        List<GeneralEntity> dbEntities = getAll(entities.get(0), "", true);
        checkEquity(entities, dbEntities);
        long largestKey = getKey(dbEntities);
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            for (GeneralEntity entity : entities) {
                System.out.println(largestKey);
                largestKey++;
                entity = setId(entity, largestKey);
                String query = "INSERT INTO " + entity.getTableName() + " VALUES(" + entity.getValues() + ")";
                System.out.println(query);
                statement.addBatch(query);
            }
            int[] executed = statement.executeBatch();
            for (int i : executed) {
                if (i < 1) {
                    throw new Exception("Error while executing queries!");
                }
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            throw ex;
        }
        return largestKey;
    }

    @Override
    public List<GeneralEntity> saveAll(List<GeneralEntity> entities) throws Exception {
        List<GeneralEntity> dbEntities = getAll(entities.get(0), "");

        checkEquity(entities, dbEntities);
        long largestKey = getKey(dbEntities);
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            for (GeneralEntity entity : entities) {
                largestKey++;
                System.out.println(largestKey);
                entity = setId(entity, largestKey);
                String query = "INSERT INTO " + entity.getTableName() + " VALUES(" + entity.getValues() + ")";
                System.out.println(query);
                statement.addBatch(query);
            }
            int[] executed = statement.executeBatch();
            for (int i : executed) {
                if (i < 1) {
                    throw new Exception("Error while executing queries!");
                }
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            throw ex;
        }
        return entities;
    }

    private void checkEquity(List<GeneralEntity> entities, List<GeneralEntity> dbEntities) throws Exception {
        for (GeneralEntity dbEntity : dbEntities) {
            for (GeneralEntity generalEntity : entities) {

                if (generalEntity.equals(dbEntity)) {
                    throw new Exception("Entity already exists!");
                }
            }
        }
    }

    private long getKey(List<GeneralEntity> dbEntities) {
        long largestKey = 0;
        for (GeneralEntity generalEntity : dbEntities) {
            if (generalEntity instanceof Movie) {
                Movie movie = (Movie) generalEntity;
                if (movie.getMovieID() > largestKey) {
                    largestKey = movie.getMovieID();
                }
            }
            if (generalEntity instanceof CinemaHall) {
                CinemaHall hall = (CinemaHall) generalEntity;
                if (hall.getCinemaHallID() > largestKey) {
                    largestKey = hall.getCinemaHallID();
                }
            }
            if (generalEntity instanceof Member) {
                Member member = (Member) generalEntity;
                if (member.getMemberID() > largestKey) {
                    largestKey = member.getMemberID();
                }
            }
            if (generalEntity instanceof Projection) {
                Projection projection = (Projection) generalEntity;
                if (projection.getProjectionID() > largestKey) {
                    largestKey = projection.getProjectionID();
                }
            }
            if (generalEntity instanceof Reservation) {
                Reservation reservation = (Reservation) generalEntity;
                if (reservation.getReservationID() > largestKey) {
                    largestKey = reservation.getReservationID();
                }
            }
        }

        return largestKey;
    }

    private GeneralEntity setId(GeneralEntity entity, long largestKey) {
        if (entity instanceof Movie) {
            Movie movie = (Movie) entity;
            movie.setMovieID(largestKey);
            entity = movie;

        }
        if (entity instanceof CinemaHall) {
            CinemaHall hall = (CinemaHall) entity;
            hall.setCinemaHallID(largestKey);
            entity = hall;

        }
        if (entity instanceof Member) {
            Member member = (Member) entity;
            member.setMemberID(largestKey);
            entity = member;

        }
        if (entity instanceof Projection) {
            Projection projection = (Projection) entity;
            projection.setProjectionID(largestKey);
            entity = projection;
        }
        if (entity instanceof Reservation) {
            Reservation reservation = (Reservation) entity;
            reservation.setReservationID(largestKey);
            entity = reservation;
        }
        return entity;
    }

    @Override
    public boolean remove(GeneralEntity entity) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM " + entity.getTableName() + entity.getConstraints(new char[0]);
            System.out.println(query);
            Statement statement = connection.createStatement();
            String[] queryList = query.split(";");
            for (int i = queryList.length - 1; i >= 0; i--) {
                statement.addBatch(queryList[i]);
                System.out.println(queryList[i]);
            }
            int[] executed = statement.executeBatch();
            for (int i : executed) {
                if (i < 0) {
                    throw new Exception("Error while executing queries");
                }
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return true;
    }

}
