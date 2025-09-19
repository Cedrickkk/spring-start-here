import config.ProjectConfig;
import models.Comment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Will get a "proxy" object
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(new Comment("Demo Aspect Oriented Programming", "hula@nm0"));
    }
}
