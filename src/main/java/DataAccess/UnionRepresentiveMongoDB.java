package DataAccess;

import java.util.ArrayList;
import java.util.Optional;

public class UnionRepresentiveMongoDB implements Dao {
    private static final UnionRepresentiveMongoDB instance = new UnionRepresentiveMongoDB();

    private  UnionRepresentiveMongoDB(){
        // add default UR users
    }

    public static UnionRepresentiveMongoDB getInstance(){
        return instance;
    }

    @Override
    public Optional get(String username) { return Optional.empty(); }

    @Override
    public ArrayList getAll() { return null; }

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
