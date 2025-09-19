package services;

import annotations.ToLogAfterReturning;
import models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public void publish(Comment comment) {
        logger.info("Publishing comment '" + comment.getText() + "' by " + comment.getAuthor());
    }

    public void delete(Comment comment) {
        logger.info("Deleting comment '" + comment.getText() + "' by " + comment.getAuthor());
    }

    @ToLogAfterReturning
    public Comment edit(Comment comment) {
        logger.info("Editing comment '" + comment.getText() + "' by " + comment.getAuthor());
        return new Comment("Edited comment", comment.getAuthor());
    }
}
