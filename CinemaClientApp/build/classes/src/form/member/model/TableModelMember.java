/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.member.model;

import domain.CinemaHall;
import domain.Member;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vladan Simonovic
 */
public class TableModelMember extends AbstractTableModel {

    private List<Member> members;

    private String[] header = new String[]{"Full name", "Contact", "Email"};

    public TableModelMember(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public int getRowCount() {
        return members.size();
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
        Member member = members.get(i);
        switch (i1) {
            case 0:
                return member.getFullName();
            case 1:
                return member.getContact();
            case 2:
                return member.getEmail();
            default:
                return "N/A";
        }
    }

    public void remove(int selectedRow) {
        members.remove(selectedRow);
        fireTableDataChanged();
        System.out.println("Member removed from table.");

    }

}
