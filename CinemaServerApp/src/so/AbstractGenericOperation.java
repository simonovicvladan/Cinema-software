package so;

import storage.IDatabaseBroker;
import storage.database.DatabaseBroker;
import storage.database.connection.DatabaseConnection;

public abstract class AbstractGenericOperation {

    protected IDatabaseBroker databaseBroker;

    public AbstractGenericOperation() {
        this.databaseBroker = new DatabaseBroker();
    }

    public final void templateExecute(Object entity, String keyword) throws Exception {
        try {
            validate(entity);
            startTransaction();
            execute(entity, keyword);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        }
    }

    protected abstract void validate(Object entity) throws Exception;

    protected abstract void execute(Object entity, String keyword) throws Exception;

    private void startTransaction() throws Exception {
        DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
    }

    private void commitTransaction() throws Exception {
        DatabaseConnection.getInstance().commit();
    }

    private void rollbackTransaction() throws Exception {
        DatabaseConnection.getInstance().rollback();
    }

}
