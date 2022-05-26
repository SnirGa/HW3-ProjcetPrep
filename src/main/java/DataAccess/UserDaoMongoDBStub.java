package DataAccess;

import Domain.ManagementSystem.UnionRepresentative;

import java.util.ArrayList;
import java.util.Optional;

public class UserDaoMongoDBStub implements Dao {
    private static final UserDaoMongoDBStub instance = new UserDaoMongoDBStub();

    private UserDaoMongoDBStub(){
        // add default users
    }

    public static UserDaoMongoDBStub getInstance(){
        return instance;
    }

    @Override
    public Optional get(String username) {
        if (username.equals("Admin")){
            UnionRepresentative user = new UnionRepresentative("Admin", "Admin1", "admin");
            return Optional.of(user);
        }
        return null;
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
