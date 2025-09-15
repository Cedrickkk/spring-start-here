package proxies;

import models.Comment;
import org.springframework.stereotype.Component;

@Component
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification to '" +
                comment.getAuthor() + "' for comment '" +
                comment.getText() + "'");
    }
}
