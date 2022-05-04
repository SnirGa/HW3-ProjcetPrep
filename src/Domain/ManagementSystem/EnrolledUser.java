package Domain.ManagementSystem;

import javax.management.Notification;
import java.util.ArrayList;

abstract class EnrolledUser extends User {
    private int userId;
    private String userName;
    private String password;
    private String name;

    private ArrayList<Notification> notifications;


    public EnrolledUser(int userId, String userName, String password, String name) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.notifications=new ArrayList<>();

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Notification> getNotification() {
        return notifications;
    }

    public void addNotification(Notification notification) {
        this.notifications.add(notification);
    }
}




