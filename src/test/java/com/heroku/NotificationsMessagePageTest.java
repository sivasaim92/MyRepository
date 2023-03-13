package com.heroku;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationsMessagePageTest extends BaseTest {

    @Test
    public void getNotificationsMessageTest() {
        setUpLocalBrowser();
        NotificationMessagesPage notificationMessagesPage = PageFactory.initElements(driver, NotificationMessagesPage.class);
        Assert.assertTrue(notificationMessagesPage.getNotificationMessage());
    }
}
