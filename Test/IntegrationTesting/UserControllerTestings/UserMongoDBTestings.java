package IntegrationTesting.UserControllerTestings;

import DataAccess.*;
import Domain.ManagementSystem.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserMongoDBTestings {
    UserDaoMongoDB userDaoMongoDB = UserDaoMongoDB.getInstance();

    @Test
    public void SaveGetDeleteAllUser() {
        //Test
        TeamOwner teamOwner = new TeamOwner("teamOwner", "1234567", "TeamOwnerName");
        assertTrue(SaveGetDeleteUser(teamOwner));
        //Test
        TeamManager teamManager = new TeamManager("teamManger", "123456", "TeamManger", new ArrayList<String>(Arrays.asList("permission1", "permission2", "permission3")));
        assertTrue(SaveGetDeleteUser(teamManager));
        //Test
        Coach coach = new Coach("coach", "123456", "coachName", "mainCoach", "Football Academy");
        assertTrue(SaveGetDeleteUser(coach));
        //Test
        Player player = new Player("player", "123456", "playerName", new Date(), FilledRole.GoalKeeper);
        assertTrue(SaveGetDeleteUser(player));
        //Test
        Referee referee = new Referee("referee", "123456", "refereeName", "mainReferee");
        assertTrue(SaveGetDeleteUser(referee));
        //Test
        UnionRepresentative unionRepresentative = new UnionRepresentative("unionRepresentative", "123456", "URName");
        assertTrue(SaveGetDeleteUser(unionRepresentative));
        //Test
        Fan fan = new Fan("fan", "123456", "fanUser", null);
        assertTrue(SaveGetDeleteUser(fan));
    }

    public boolean SaveGetDeleteUser(EnrolledUser user) {
        saveUser(user);
        if (getUser(user))
            if (deleteUser(user))
                return true;
        return false;
    }

    public void saveUser(EnrolledUser user) {
        userDaoMongoDB.save(user);
    }

    public boolean getUser(EnrolledUser user) {
        try {
            EnrolledUser getUser = (EnrolledUser) userDaoMongoDB.get(user.getUserName()).get();
            assertNotNull(getUser);
            assertEquals(user.getUserName(), getUser.getUserName());
            assertEquals(user.getPassword(), getUser.getPassword());
            assertEquals(user.getName(), getUser.getName());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteUser(EnrolledUser user) {
        try {
            userDaoMongoDB.delete(user);
            Optional getUser = userDaoMongoDB.get(user.getUserName());
            assertTrue(getUser.isEmpty());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
