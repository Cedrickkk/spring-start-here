package proxies;

import models.Comment;

public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification to '" +
                comment.getAuthor() + "' for comment '" +
                comment.getText() + "'");
    }
}
