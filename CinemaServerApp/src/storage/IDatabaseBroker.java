package storage;

import domain.GeneralEntity;
import java.util.List;

public interface IDatabaseBroker {

    List<GeneralEntity> getAll(GeneralEntity entity) throws Exception;

    List<GeneralEntity> getAll(GeneralEntity entity, String keyword) throws Exception;
    
    List<GeneralEntity> getAll(GeneralEntity entity, String keyword, boolean joined) throws Exception;
    

    GeneralEntity getOne(GeneralEntity entity) throws Exception;

    public long save(List<GeneralEntity> entities) throws Exception;

    public List<GeneralEntity> saveAll(List<GeneralEntity> entities) throws Exception;

    public boolean remove(GeneralEntity entity) throws Exception;

}
