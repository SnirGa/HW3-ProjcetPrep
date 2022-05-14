package Domain.ManagementSystem;

import Service.UserApplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    void loginEventTestSet(){
        UserApplication userApp = new UserApplication();
        // User exist , correct password  - assert True
//        assertEquals(true, userApp.login("", ""));
        // User exist , wrong password  - assert False
//        assertEquals(false, userApp.login("", ""));
        // User Not exist - assert False
//        assertEquals(false, userApp.login("", ""));

    }

}
