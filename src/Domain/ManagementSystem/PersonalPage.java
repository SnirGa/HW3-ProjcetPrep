package Domain.ManagementSystem;

import java.util.ArrayList;

public class PersonalPage {
    //TODO: add the other fields
    //fanSubscribers field not in the UML, but needed in order to subscribe new fans
    ArrayList<Fan> fanSubscribers;

    public PersonalPage() {
        //TODO: add more fields as showed in the class diagram
        this.fanSubscribers=new ArrayList<>();
    }

    public void addSubscriber(Fan fan){
        this.fanSubscribers.add(fan);
    }
}

