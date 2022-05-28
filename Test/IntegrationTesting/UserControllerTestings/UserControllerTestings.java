package IntegrationTesting.UserControllerTestings;

import Domain.Controllers.UserController;
import org.junit.Test;
import SetUpDB.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTestings {
    @Test
    public void loginTesting(){
        SetUp.SetUpDB();
        UserController userController=new UserController();
        // True/False
        try {
            //Exist player
            assertTrue(userController.login("someName", "123456"));
            //Non-Exist player
            assertFalse(userController.login("NotExist", "123456"));
        }catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }
        // Name = null
        try {
            userController.login(null, "123456");
        }catch (Exception e){
            assertEquals(e.getMessage(),"userName have to be entered");
        }
        // Password = null
        try {
            userController.login("someName", null);
        }catch (Exception e){
            assertEquals(e.getMessage(),"password have to be entered");
        }
    }
}
