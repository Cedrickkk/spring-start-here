package services;

import annotations.ToLog;
import models.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publish(Comment comment) {
        logger.info("Publishing comment '" + comment.getText() + "' by " + comment.getAuthor());
        return "SUCCESS";
    }
}
