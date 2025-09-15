package proxies;

import models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("commentPushNotificationProxy")
public class CommentPushNotificationProxy implements CommentNotificationProxy {
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification to '" +
                comment.getAuthor() + "' for comment '" +
                comment.getText() + "'");
    }
}
