import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        UserService userService = context.getBean(UserService.class);
        CommentService commentService = context.getBean(CommentService.class);

        System.out.println(userService.getCommentRepository() == commentService.getCommentRepository());
    }
}
