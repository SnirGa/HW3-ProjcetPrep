package Domain.ManagementSystem;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonalPage implements Serializable {
    private EnrolledUser pageOwner;
    private int age;
    private double height;
    private String city;
    private String aboutMe;
    private ArrayList<Fan> fanSubscribers;

    public PersonalPage(EnrolledUser pageOwner, int age, double height, String city, String aboutMe) {
        this.pageOwner = pageOwner;
        this.age = age;
        this.height = height;
        this.city = city;
        this.aboutMe = aboutMe;
        this.fanSubscribers = new ArrayList<>();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getCity() {
        return city;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void addSubscriber(Fan fan){
        this.fanSubscribers.add(fan);
    }
}

