package repositories;

import models.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
    public void performDatabaseOperationsOnComment(Comment comment) {
        System.out.println("Performing some database operations on comment: '" + comment.getText() + "'");
    }
}
