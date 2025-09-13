import config.ProjectConfig;
import models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot koko = context.getBean("koko", Parrot.class);
        System.out.println(koko.getName());

        Parrot miki = context.getBean("miki", Parrot.class);
        System.out.println(miki.getName());

        Parrot riki = context.getBean("riki", Parrot.class);
        System.out.println(riki.getName());

        Parrot primary = context.getBean(Parrot.class);
        System.out.println(primary.getName());
    }
}
