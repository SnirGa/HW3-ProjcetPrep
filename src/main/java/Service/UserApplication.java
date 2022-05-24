package Service;

import DataAccess.UserDaoMongoDB;
import Domain.Controllers.UserController;

public class UserApplication {
    UserController userController = new UserController();

    public UserApplication(){

    }
    public boolean login(String userName,String password){
        return userController.login(userName,password);
    }

}
