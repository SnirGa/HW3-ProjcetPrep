package DataAccess;

import java.util.ArrayList;
import java.util.Optional;

public class LeagueDaoMongoDB implements Dao{
    private static final LeagueDaoMongoDB instance = new LeagueDaoMongoDB();

    private LeagueDaoMongoDB(){
        // add default leagues
    }

    public static LeagueDaoMongoDB getInstance(){
        return instance;
    }

    @Override
    public Optional get(String name) {
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
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
