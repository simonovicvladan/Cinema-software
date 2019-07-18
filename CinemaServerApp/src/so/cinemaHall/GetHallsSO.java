/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.cinemaHall;

import domain.CinemaHall;
import domain.GeneralEntity;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Vladan Simonovic
 */
public class GetHallsSO extends AbstractGenericOperation {

    private List<GeneralEntity> list;

    @Override
    protected void validate(Object entity) throws Exception {
        if (!(entity instanceof CinemaHall)) {
            throw new Exception("Invalid entity parameter!");
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        list = databaseBroker.getAll((CinemaHall) entity);
    }

    public List<GeneralEntity> getList() {
        return list;
    }

}
