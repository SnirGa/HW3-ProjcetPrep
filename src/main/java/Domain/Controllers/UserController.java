package Domain.Controllers;
import DataAccess.Dao;
import DataAccess.UserDao;
import DataAccess.UserDaoMongoDB;
import Domain.ManagementSystem.EnrolledUser;


public class UserController {
    static Dao udMDB;

    public UserController() {
        udMDB = UserDaoMongoDB.getInstance();
    }
    // For test only
    public UserController(Dao ud){
        udMDB = ud;
    }

    public void viewInformation(){

    }


    public boolean login(String userName,String password){
        if (udMDB.get(userName) != null){
            EnrolledUser user = (EnrolledUser)(Object)udMDB.get(userName).get();
            return user.getPassword().equals(password);
        }
        return false;
    }

//    public static EnrolledUser getUser(String userName){
//        return (EnrolledUser)(Object)udMDB.get(userName);
//    }

    public void logout(){

    }

}
