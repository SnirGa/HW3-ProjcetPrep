package IntegrationTesting.UserControllerTestings;

import DataAccess.UserDaoMongoDB;
import Domain.Controllers.UserController;
import Domain.ManagementSystem.FilledRole;
import Domain.ManagementSystem.Player;
import org.junit.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
            assertTrue(!userController.login("NotExist", "123456"));
        }
        catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }
    }
}
