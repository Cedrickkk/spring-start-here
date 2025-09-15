import config.ProjectConfig;
import models.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment("Demo comment", "hul@anm0");

        CommentService commentService = context.getBean(CommentService.class);

        commentService.publishComment(comment);
    }
}
