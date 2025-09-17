package services;

import models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;


@Service
public class CommentService {
    /**
     * A service class responsible for handling comments.
     * <p>
     * This class is a Spring singleton, meaning only one instance is created per application context.
     * This can create a conflict when injecting a prototype-scoped bean, as a new instance of
     * the prototype bean will not be created for each request. Instead, the singleton service
     * will only receive the initial instance, which can lead to unexpected state issues and
     * concurrency problems in a multithreaded environment.
     * <p>
     * <pre>{@code
     * private final CommentProcessor commentProcessor;
     *
     * @Autowired
     * public CommentService(CommentProcessor commentProcessor) {
     * this.commentProcessor = commentProcessor;
     * }
     * }</pre>
     * <p>
     * To resolve this, it is recommended to either use a different scope for the injected
     * bean or to inject the ApplicationContext
     * </p>
     */

    private final ApplicationContext context;

    @Autowired
    public CommentService(ApplicationContext context) {
        this.context = context;
    }

    public void sendComment(Comment comment) {
        CommentProcessor commentProcessor = context.getBean(CommentProcessor.class);
        commentProcessor.setComment(comment);
        commentProcessor.processComment();
        commentProcessor.validateComment();
        comment = commentProcessor.getComment();
        // process comment further later...

        System.out.println(commentProcessor); // Output different CommentProcessor
    }
}
