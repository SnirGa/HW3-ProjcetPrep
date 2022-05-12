package DataAccess;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(long id);

    ArrayList<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
