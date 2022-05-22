package Domain.Controllers;
import DataAccess.UserDaoMongoDB;
import Domain.ManagementSystem.EnrolledUser;


public class UserController {
    static UserDaoMongoDB udMDB;

    public UserController(){
        udMDB = UserDaoMongoDB.getInstance();
    }


    public void viewInformation(){

    }

    public boolean login(String userName,String password){
        if (udMDB.get(userName) != null){
            EnrolledUser user = (EnrolledUser)(Object)udMDB.get(userName);
            return user.getPassword().equals(password);
        }
        return false;
    }

    public static EnrolledUser getUser(String userName){
        return (EnrolledUser)(Object)udMDB.get(userName);
    }

    public void logout(){

    }

}
