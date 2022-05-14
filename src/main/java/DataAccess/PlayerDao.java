package DataAccess;

import Domain.ManagementSystem.Player;

import java.util.ArrayList;
import java.util.Optional;

public class PlayerDao implements Dao<Player>{
    @Override
    public Optional<Player> get(String username) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Player> getAll() {
        return null;
    }

    @Override
    public void save(Player player) {

    }

    @Override
    public void update(Player player, String[] params) {

    }

    @Override
    public void delete(Player player) {

    }
}
