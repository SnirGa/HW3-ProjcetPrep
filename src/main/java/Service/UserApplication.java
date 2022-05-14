package Service;

import Domain.Controllers.UserController;

public class UserApplication {
    UserController userController=new UserController();

    public boolean login(String userName,String password){
        return userController.login(userName,password);
    }

}
