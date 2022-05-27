package AcceptanceTesting;

import Service.UserApplication;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginUCTest {

    @Test
    public void loginAcceptanceTestSet(){
        UserApplication userApp = new UserApplication();
        // User exist , correct password  - assert True
        assertTrue(userApp.login("Admin", "Admin1").equals("Successful login"));
        // User exist , wrong password  - assert False
        assertTrue(userApp.login("Admin", "Admin").equals("userName or password are not valid"));
        // User Not exist - assert False
        assertTrue(userApp.login("Admi", "Admin1").equals("userName or password are not valid"));
    }
}
