import config.ProjectConfig;
import models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot[] parrots = {
                new Parrot("Koko", "red"),
                new Parrot("Riki", "green"),
                new Parrot("Cotton", "green"),
                new Parrot("Copper", "white"),
        };


        for (Parrot parrot : parrots) {
            if (parrot.getColor().equals("green")) {
                context.registerBean(parrot.getName().toLowerCase(), Parrot.class, () -> parrot);
            }
        }

        Parrot riki = context.getBean("riki", Parrot.class);
        System.out.println(riki);

        Parrot cotton = context.getBean("cotton", Parrot.class);
        System.out.println(cotton);
    }
}
