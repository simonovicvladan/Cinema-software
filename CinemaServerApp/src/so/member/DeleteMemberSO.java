/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.member;

import domain.Member;
import so.AbstractGenericOperation;

/**
 *
 * @author Vladan Simonovic
 */
public class DeleteMemberSO extends AbstractGenericOperation {

    private boolean successful;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof Member)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        successful = databaseBroker.remove((Member) entity);
    }

    public boolean isSuccessful() {
        return successful;
    }

}
