import config.ProjectConfig;
import models.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = context.getBean(Person.class);
        person.setName("Cedrick");
        System.out.println("Person's name is " + person.getName());
        System.out.println("Person's parrot name is " + person.getParrot().getName());
    }
}
