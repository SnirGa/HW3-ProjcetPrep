package Service;

import DataAccess.UserDaoMongoDB;
import Domain.Controllers.UserController;

public class UserApplication {
    UserController userController = new UserController();

    public UserApplication(){

    }
    public String login(String userName,String password){
        try {
            if (userController.login(userName, password))
                return("Successful login");
            else{
                return("userName or password are not valid");
            }
        }catch(Exception e){
            return e.getMessage();
        }
    }

}
