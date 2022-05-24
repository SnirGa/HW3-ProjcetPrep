package DataAccess;

import java.util.ArrayList;
import java.util.Optional;

public class LeagueDaoMongoDBStub implements Dao {
    @Override
    public Optional get(String username) {
        return Optional.empty();
    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
