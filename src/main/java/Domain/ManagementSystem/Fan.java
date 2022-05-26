package Domain.ManagementSystem;

import Domain.NotificationSystem.FanNotification;
import Domain.RecommendationSystem.RecommendationSystem;
import Domain.SearchSystem.SearchHistory;
import java.util.ArrayList;

public class Fan extends EnrolledUser {
    private ArrayList<FanNotification> fanNotifications;
    private ArrayList<SearchHistory> searchHistories;
    private RecommendationSystem recommendationSystem;
    private ArrayList<UserComplaint> usersComplaints;

    public Fan(String userName, String password, String name,RecommendationSystem recommendationSystem) {
        super(userName, password, name);
        this.fanNotifications=new ArrayList<>();
        this.searchHistories=new ArrayList<>();
        this.recommendationSystem=recommendationSystem;
        this.usersComplaints=new ArrayList<>();
    }

    public ArrayList<FanNotification> getNotifications() {
        return fanNotifications;
    }

    public ArrayList<SearchHistory> getSearchHistories() {
        return searchHistories;
    }

    public RecommendationSystem getRecommendationSystem() {
        return recommendationSystem;
    }

    public ArrayList<UserComplaint> getUsersComplaints() {
        return usersComplaints;
    }

    public void subscribeToPersonalPage(PersonalPage personalPage){
        personalPage.addSubscriber(this);
    }

    public void addNotification(FanNotification notification){
        this.fanNotifications.add(notification);
    }

    public void addComplaint(UserComplaint userComplaint){
            this.usersComplaints.add(userComplaint);
        }

}