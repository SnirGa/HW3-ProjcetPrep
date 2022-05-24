package Domain.ManagementSystem;

import Domain.NotificationSystem.FanNotification;

import java.util.ArrayList;

public class SubscribedPages {
        FanNotification fanNotification;
        PersonalPage personalPage;
        ArrayList<PersonalPage> lstPersonalPage;

        public SubscribedPages()
        {
            fanNotification = new FanNotification();
            lstPersonalPage = new ArrayList<>();
            //personalPage = new PersonalPage();
        }
    }
