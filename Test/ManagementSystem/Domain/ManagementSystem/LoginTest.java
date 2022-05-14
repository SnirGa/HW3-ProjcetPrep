package Domain.ManagementSystem;

import Service.UserApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    void loginEventTestSet(){
        UserApplication userApp = new UserApplication();
        // User exist , correct password  - assert True
//        assertTrue(userApp.login("", ""));
        // User exist , wrong password  - assert False
//        assertFalse(userApp.login("", ""));
        // User Not exist - assert False
//        assertFalse(userApp.login("", ""));

    }

}
