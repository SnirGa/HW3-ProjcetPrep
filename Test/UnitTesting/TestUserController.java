package UnitTesting;

import DataAccess.UserDaoMongoDBStub;
import Domain.Controllers.UserController;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestUserController {

    @Test
    public void testUserControllerLogin() {
        UserController uc = new UserController(UserDaoMongoDBStub.getInstance());
        try {
            // User exist , correct password  - assert True
            assertTrue(uc.login("Admin", "Admin1"));
            // User exist , wrong password  - assert False
            assertFalse(uc.login("Admin", "Admin"));
            // User Not exist - assert False
            assertFalse(uc.login("Admi", "Admin1"));
        }catch(Exception e){
            assertFalse(e.getMessage().length() > 0);
        }

        try{
            assertFalse(uc.login("Admin", null));
        }catch(Exception e){
            assertTrue(e.getMessage().contains("password"));
        }

        try{
            assertFalse(uc.login(null, "Admin1"));
        }catch(Exception e){
            assertTrue(e.getMessage().contains("userName"));
        }

    }

}
