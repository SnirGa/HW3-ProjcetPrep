package AcceptanceTesting;

import Service.UserApplication;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginUCTest {

    @Test
    public void loginAcceptanceTestSet(){
        UserApplication userApp = new UserApplication();
        // User exist , correct password  - assert True
        assertEquals(userApp.login("Admin", "Admin1"), "Successful login");
        // User exist , wrong password  - assert False
        assertEquals(userApp.login("Admin", "Admin"), "userName or password are not valid");
        // User Not exist - assert False
        assertEquals(userApp.login("Admi", "Admin1"), "userName or password are not valid");
        // User = null
        assertEquals(userApp.login(null, "Admin1"), "userName have to be entered");
        // Password = null
        assertEquals(userApp.login("Admi", null), "password have to be entered");
    }
}
