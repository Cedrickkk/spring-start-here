package proxies;


import models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("emailCommentNotificationProxy")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending email notification to '" +
                comment.getAuthor() + "' for comment '" +
                comment.getText() + "'");
    }
}
