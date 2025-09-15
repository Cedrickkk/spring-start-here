import models.Comment;
import proxies.CommentNotificationProxy;
import proxies.EmailCommentNotificationProxy;
import repositories.CommentRepository;
import repositories.DBCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        CommentRepository commentRepository = new DBCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();

        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);
        Comment comment = new Comment("This is a comment.", "hula@nm0");

        commentService.publishComment(comment);
    }
}
