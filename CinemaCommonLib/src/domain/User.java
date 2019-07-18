/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Vladan Simonovic
 */
public class User implements GeneralEntity {

    private Long userID;
    private String fullName;
    private String username;
    private String password;
    private String email;

    @Override
    public String toString() {
        return fullName;
    }

    public User() {
    }

    public User(Long userID, String fullName, String username, String password, String email) {
        this.userID = userID;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            Long userID = resultSet.getLong("UserID");
            String fullName = resultSet.getString("FullName");
            String username = resultSet.getString("Username");
            String password = resultSet.getString("Password");
            String email = resultSet.getString("Email");

            User user = new User(userID, fullName, username, password, email);
            list.add(user);
        }
        return list;
    }

    @Override
    public String getConstraints(Object keyword) {
        return " WHERE Username = '" + username + "' AND Password = '" + password + "'";
    }

    @Override
    public GeneralEntity getOne(ResultSet resultSet) throws Exception {
        GeneralEntity entity = new User();
        if (resultSet.next()) {
            Long userID = resultSet.getLong("UserID");
            String fullName = resultSet.getString("FullName");
            String username = resultSet.getString("Username");
            String password = resultSet.getString("Password");
            String email = resultSet.getString("Email");

            entity = new User(userID, fullName, username, password, email);
            return entity;
        }
        throw new Exception("User not found!");
    }

    @Override
    public String getValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinedTables(boolean joined) {
        return "";
    }

}
