import config.ProjectConfig;
import models.Comment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = context.getBean(CommentService.class);

        commentService.publish(new Comment("For Publish", "hula@nm0"));
        commentService.delete(new Comment("For Delete", "hula@nm0"));
        commentService.edit(new Comment("For Edit", "hula@nm0"));
    }
}
