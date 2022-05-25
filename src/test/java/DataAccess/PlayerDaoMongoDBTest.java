package DataAccess;

import Domain.ManagementSystem.FilledRole;
import Domain.ManagementSystem.Player;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDaoMongoDBTest {

    @Test
    void get() {
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        playerDaoMongoDB.save(player);
        Optional<Player> fromdb=playerDaoMongoDB.get(player.getUserName());
        assertNotNull(fromdb.get());
        Optional<Player> fromdb2=playerDaoMongoDB.get("notExist");
        assertTrue(fromdb2.isEmpty());
        //playerDaoMongoDB.delete(player);

    }
    @Test
    void getAll() {
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        Player player2=new Player("Roni123","123456","Roni Ronaldo",new Date(), FilledRole.GoalKeeper);

        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        playerDaoMongoDB.save(player);
        ArrayList<Player> players=playerDaoMongoDB.getAll();
        playerDaoMongoDB.save(player2);
        players=playerDaoMongoDB.getAll();
        assertTrue(players.size()==2);
        playerDaoMongoDB.delete(player);
        playerDaoMongoDB.delete(player2);
    }

    @Test
    void save() {
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        Player player2=new Player("Roni123","123456","Roni Ronaldo",new Date(), FilledRole.GoalKeeper);

        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        playerDaoMongoDB.save(player);
        playerDaoMongoDB.save(player2);

        Optional optional1=playerDaoMongoDB.get("Hodaya123");
        Optional optional2=playerDaoMongoDB.get("Roni123");
        assertNotNull(optional1.get());
        assertNotNull(optional2.get());
        playerDaoMongoDB.delete(player);
        playerDaoMongoDB.delete(player2);

    }

    @Test
    void update() {
        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        player.setName("Hodaya Taka");
        playerDaoMongoDB.update(player);
        Optional<Player> op=playerDaoMongoDB.get(player.getUserName());
        assertTrue(player.getName().equals(op.get().getName()));
        playerDaoMongoDB.delete(player);
    }

    @Test
    void delete() {
        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        Player player=new Player("Hodaya123","123456","Hodaya Messi",new Date(), FilledRole.GoalKeeper);
        playerDaoMongoDB.save(player);
        ArrayList<Player> players=playerDaoMongoDB.getAll();
        playerDaoMongoDB.delete(player);
        players=playerDaoMongoDB.getAll();
        assertTrue(players.size()==0);



    }
}