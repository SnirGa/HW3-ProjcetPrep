package Domain.ManagementSystem;

import Domain.NotificationSystem.FanNotification;

    public class SubscribedPages {
        FanNotification fanNotification;
        PersonalPage personalPage;
        public SubscribedPages()
        {
            fanNotification = new FanNotification();
            personalPage = new PersonalPage();
        }
    }
