/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.projection;

import domain.GeneralEntity;
import domain.Projection;
import java.util.List;
import so.AbstractGenericOperation;

/**
 *
 * @author Vladan Simonovic
 */
public class SaveProjectionsSO extends AbstractGenericOperation {

     private List<GeneralEntity> projections;

    @Override
    protected void validate(Object entity) throws Exception {
        List<Object> entities = (List<Object>) entity;
        for (Object object : entities) {
            if (!(object instanceof Projection)) {
                throw new Exception("Invalid entity parameter!");
            }
        }
    }

    @Override
    protected void execute(Object entity, String keyword) throws Exception {
        projections = databaseBroker.saveAll((List<GeneralEntity>) entity);

    }

    public List<GeneralEntity> getProjections() {
        return projections;
    }
}
