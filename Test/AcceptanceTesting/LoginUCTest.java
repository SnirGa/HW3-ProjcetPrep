package AcceptanceTesting;
import DataAccess.UserDaoMongoDB;
import Domain.Controllers.UserController;
import Domain.ManagementSystem.UnionRepresentive;
import Service.UserApplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginUCTest {
    public void setUp(){
        UnionRepresentive user = new UnionRepresentive("Admin", "Admin1","AdminosBalev");
        UserDaoMongoDB umdb = UserDaoMongoDB.getInstance();
        umdb.save(user);
    }

    @Test
    void loginAcceptanceTestSet(){
        setUp();
        UserApplication userApp = new UserApplication();
        // User exist , correct password  - assert True
        assertTrue(userApp.login("Admin", "Admin1"));
        // User exist , wrong password  - assert False
        assertFalse(userApp.login("Admin", "Admin"));
        // User Not exist - assert False
        assertFalse(userApp.login("Admi", "Admin1"));
    }
}
