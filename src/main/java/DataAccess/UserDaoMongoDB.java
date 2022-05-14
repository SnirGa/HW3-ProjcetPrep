package DataAccess;

import java.util.ArrayList;
import java.util.Optional;

public class UserDaoMongoDB implements Dao {
    private static final UserDaoMongoDB instance = new UserDaoMongoDB();

    private UserDaoMongoDB(){
        // add default users
    }

    public static UserDaoMongoDB getInstance(){
        return instance;
    }

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
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
