package AcceptanceTesting;
import Service.UserApplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginUCTest {
    @Test
    void loginAcceptanceTestSet(){
        UserApplication userApp = new UserApplication();
        // User exist , correct password  - assert True
        assertTrue(userApp.login("Admin", "Admin1"));
        // User exist , wrong password  - assert False
        assertFalse(userApp.login("Admin", "Admin"));
        // User Not exist - assert False
        assertFalse(userApp.login("Admi", "Admin1"));
    }
}
