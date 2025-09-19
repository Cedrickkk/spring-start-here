package services;

import annotations.ToLog;
import annotations.ToLogAfter;
import annotations.ToLogBefore;
import models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLogAfter
    public void publish(Comment comment) {
        logger.info("Publishing comment '" + comment.getText() + "' by " + comment.getAuthor());
    }

    @ToLog
    public void delete(Comment comment) {
        logger.info("Deleting comment '" + comment.getText() + "' by " + comment.getAuthor());
    }

    @ToLogBefore
    public void edit(Comment comment) {
        logger.info("Editing comment '" + comment.getText() + "' by " + comment.getAuthor());
    }
}
