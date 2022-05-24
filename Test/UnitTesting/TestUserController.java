package UnitTesting;

import DataAccess.UserDaoMongoDBStub;
import Domain.Controllers.UserController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TestUserController {

    @Test
    public void testUserControllerLogin() {
        UserController uc = new UserController(UserDaoMongoDBStub.getInstance());
        // User exist , correct password  - assert True
        assertTrue(uc.login("Admin", "Admin1"));
        // User exist , wrong password  - assert False
        assertFalse(uc.login("Admin", "Admin"));
        // User Not exist - assert False
        assertFalse(uc.login("Admi", "Admin1"));
    }

}
