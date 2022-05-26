package IntegrationTesting.UserControllerTestings;

import DataAccess.UserDaoMongoDB;
import Domain.ManagementSystem.*;
import Service.UserApplication;
import org.junit.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserMongoDBTestings {
    @Test
    public void saveUserAndLoadUserAndDelete(){
        UserDaoMongoDB userDaoMongoDB=UserDaoMongoDB.getInstance();
        Date date=new Date();
        Player player=new Player("Roni123","123456","Roni",date, FilledRole.GoalKeeper);
        userDaoMongoDB.save(player);
        Player user=(Player) userDaoMongoDB.get(player.getUserName()).get();
        String pass=user.getPassword();
        assertEquals(player.getPassword(),pass);
        userDaoMongoDB.delete(player);
    }
    @Test
    public void updateUser(){
        UserDaoMongoDB userDaoMongoDB=UserDaoMongoDB.getInstance();
        Date date=new Date();
        Player player=new Player("Roni123","123456","Roni",date, FilledRole.GoalKeeper);
        userDaoMongoDB.save(player);
        player.setName("Hodaya");
        userDaoMongoDB.update(player);
        EnrolledUser user=(EnrolledUser)userDaoMongoDB.get(player.getUserName()).get();
        assertTrue(user.getName().equals("Hodaya"));
        assertTrue(userDaoMongoDB.get("Roni").isEmpty());
    }
    }
