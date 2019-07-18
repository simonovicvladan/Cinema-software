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
public class SaveCinemaHallsSO extends AbstractGenericOperation {

    private List<GeneralEntity> halls;

    @Override
    protected void validate(Object entity) throws Exception {
        List<Object> entities = (List<Object>) entity;
        for (Object object : entities) {
            if (!(object instanceof CinemaHall)) {
                throw new Exception("Invalid entity parameter!");
            }
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        halls = databaseBroker.saveAll((List<GeneralEntity>) entity);

    }

    public List<GeneralEntity> getHalls() {
        return halls;
    }

}
