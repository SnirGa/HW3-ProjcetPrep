package Domain.Controllers;

import DataAccess.Dao;
import DataAccess.UserDaoMongoDB;
import Domain.ManagementSystem.EnrolledUser;
import Domain.ManagementSystem.User;

public class UserController {
    private final Dao<User> udMDB;

    public UserController() {
        udMDB = UserDaoMongoDB.getInstance();
    }

    // For test only
    public UserController(Dao ud){
        udMDB = ud;
    }

    public boolean login(String userName,String password) throws Exception {
        if(userName == null)
            throw new Exception("userName have to be entered");
        if(password == null)
            throw new Exception("password have to be entered");
        if(udMDB.get(userName).isPresent()) {
            EnrolledUser user = (EnrolledUser)udMDB.get(userName).get();
            return user.getPassword().equals(password);
        }
        return false;
    }

}
