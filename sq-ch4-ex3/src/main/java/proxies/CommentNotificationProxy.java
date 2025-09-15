package proxies;

import models.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
