import config.ProjectConfig;
import models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        String hello = context.getBean(String.class);
        System.out.println(hello);

        Integer ten = context.getBean(Integer.class);
        System.out.println(ten);
    }
}
