package processors;

import models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import repositories.CommentRepository;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    private Comment comment;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentProcessor(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void processComment() {
        System.out.println("Processing '" + comment.getText() + "' comment by ' " + comment.getAuthor() + "'");
        commentRepository.performDatabaseOperationsOnComment(comment);
    }

    public void validateComment() {
        System.out.println("Validating '" + comment.getText() + "' comment by ' " + comment.getAuthor() + "'");
    }
}
