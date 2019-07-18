/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.reservation;

import domain.GeneralEntity;
import domain.Projection;
import domain.Reservation;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Vladan Simonovic
 */
public class CreateReservationSO extends AbstractGenericOperation {

    private long id;

    @Override
    protected void validate(Object entity) throws Exception {
        List<Object> entities = (List<Object>) entity;
        for (Object object : entities) {
            if (!(object instanceof Reservation)) {
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
