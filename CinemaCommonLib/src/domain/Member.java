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
public class Member implements GeneralEntity {

    private Long memberID;
    private String fullName;
    private String contact;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Member) {
            Member m = (Member) o;
            if (m.getEmail().equals(this.email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return fullName;
    }

    public Member() {
    }

    public Member(Long memberID, String fullName, String contact, String email) {
        this.memberID = memberID;
        this.fullName = fullName;
        this.contact = contact;
        this.email = email;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTableName() {
        return "member";
    }

    @Override
    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception {
        List<GeneralEntity> list = new LinkedList<>();
        while (resultSet.next()) {
            Long memberID = resultSet.getLong("MemberID");
            String fullName = resultSet.getString("FullName");
            String contact = resultSet.getString("Contact");;
            String email = resultSet.getString("Email");
            Member member = new Member(memberID, fullName, contact, email);
            list.add(member);
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
            return " WHERE MemberID = " + memberID; // But also take care about structural constraints in database.
            // On DELETE movie RESTRICT projection ?!
        }

        return " WHERE FullName LIKE '%" + keyword + "%' OR Email LIKE '%" + keyword + "%';";

    }

    @Override
    public GeneralEntity getOne(ResultSet resultSet) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValues() {
        return "" + memberID + ",'" + fullName + "', '" + contact + "', '" + email + "'";
    }

    @Override
    public String getJoinedTables(boolean joined) {
        return "";
    }

}
