/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.member;

import domain.GeneralEntity;
import domain.Member;
import domain.Movie;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Vladan Simonovic
 */
public class CreateMemberSO extends AbstractGenericOperation {

    private long id;

    @Override
    protected void validate(Object entity) throws Exception {
        List<Object> entities = (List<Object>) entity;
        for (Object object : entities) {
            if (!(object instanceof Member)) {
                throw new Exception("Invalid entity parameter!");
            }
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        id = databaseBroker.save((List<GeneralEntity>) entity);
    }

    public long getId() {
        return id;
    }

}
