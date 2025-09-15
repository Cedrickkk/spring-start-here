package repositories;

import models.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
