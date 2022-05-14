package DataAccess;

import Domain.ManagementSystem.FilledRole;
import Domain.ManagementSystem.Player;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDaoMongoDBTest {

    @Test
    void get() {
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        PlayerDaoMongoDB playerDaoMongoDB=new PlayerDaoMongoDB();
        playerDaoMongoDB.save(player);
        Optional<Player> fromdb=playerDaoMongoDB.get(player.getUserName());
        assertNotNull(fromdb.get());
        Optional<Player> fromdb2=playerDaoMongoDB.get("notExist");
        assertTrue(fromdb2.isEmpty());
    }
    @Test
    void getAll() {
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        Player player2=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);

        PlayerDaoMongoDB playerDaoMongoDB=new PlayerDaoMongoDB();
        playerDaoMongoDB.save(player);
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}