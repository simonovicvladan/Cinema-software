package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public interface GeneralEntity extends Serializable {

    public String getTableName();
    public String getJoinedTables(boolean joined);

    public String getConstraints(Object keyword);

    public List<GeneralEntity> getList(ResultSet resultSet) throws Exception;

    public GeneralEntity getOne(ResultSet resultSet) throws Exception;

    public String getValues();
}
