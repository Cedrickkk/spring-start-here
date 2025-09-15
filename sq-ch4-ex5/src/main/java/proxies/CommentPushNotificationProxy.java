package proxies;

import models.Comment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CommentPushNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification to '" +
                comment.getAuthor() + "' for comment '" +
                comment.getText() + "'");
    }
}
