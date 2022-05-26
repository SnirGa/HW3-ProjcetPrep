package Domain.ManagementSystem;

import Domain.NotificationSystem.Notification;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class EnrolledUser extends User implements Serializable {
    private String userName;
    private String password;
    private String name;
    private ArrayList<Notification> notifications;

    public EnrolledUser(String userName, String password, String name) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.notifications=new ArrayList<>();
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




