package doyourbestapp;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */
interface NotificationHandler {

    public String sendNotification(int userId);
}

class EmailNotificationHandler implements NotificationHandler{
    User user = new User();
    @Override
    public String sendNotification(int userId) {
        return null;
    }
}

class SMSNotificationHandler implements NotificationHandler{
    @Override
    public String sendNotification(int userId) {
        return null;
    }
}