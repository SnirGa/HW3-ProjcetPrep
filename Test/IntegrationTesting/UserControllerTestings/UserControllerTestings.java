package IntegrationTesting.UserControllerTestings;

import DataAccess.UserDaoMongoDB;
import Domain.Controllers.UserController;
import Domain.ManagementSystem.FilledRole;
import Domain.ManagementSystem.Player;
import org.junit.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTestings {
    @Test
    public void loginTesting(){
        UserController userController=new UserController();
        UserDaoMongoDB userDaoMongoDB=UserDaoMongoDB.getInstance();
        Player player=new Player("someName","123456","some name",new Date(), FilledRole.Defender);
        userDaoMongoDB.save(player);
        try {
            //Exist player
            assertTrue(userController.login("someName", "123456"));
            //Non-Exist player
            assertFalse(userController.login("NotExist", "123456"));
            // Name = null
            assertEquals("userName have to be entered",userController.login(null, "123456"));
            // Password = null
            assertEquals("password have to be entered",userController.login("someName", null));
        }
        catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }
    }
}
