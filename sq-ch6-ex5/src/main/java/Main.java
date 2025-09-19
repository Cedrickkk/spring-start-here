import config.ProjectConfig;
import models.Comment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = context.getBean(CommentService.class);

        Comment editedComment = commentService.edit(new Comment("For Editing", "hula@nm0"));

        System.out.println(editedComment);
    }
}
