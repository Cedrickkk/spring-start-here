package services;

import models.Comment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing '" + comment.getText() + "' by " + comment.getAuthor());
        return "SUCCESS";
    }
}
