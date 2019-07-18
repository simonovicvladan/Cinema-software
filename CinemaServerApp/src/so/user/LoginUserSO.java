/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.user;

import domain.GeneralEntity;
import domain.User;
import so.AbstractGenericOperation;

/**
 *
 * @author Vladan Simonovic
 */
public class LoginUserSO extends AbstractGenericOperation {

    
      private GeneralEntity entity;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof User)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        this.entity = databaseBroker.getOne((User) entity);
    }

    public GeneralEntity getOne() {
        return entity;
    }

    
}
