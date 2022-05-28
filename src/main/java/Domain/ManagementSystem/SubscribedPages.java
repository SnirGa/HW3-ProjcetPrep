package Domain.ManagementSystem;

import Domain.RecommendationSystem.NotificationSystem.FanNotification;
import java.io.Serializable;
import java.util.ArrayList;

public class SubscribedPages implements Serializable {
        FanNotification fanNotification;
        ArrayList<PersonalPage> lstPersonalPage;

        public SubscribedPages()
        {
            fanNotification = new FanNotification();
            lstPersonalPage = new ArrayList<>();
        }
    }
