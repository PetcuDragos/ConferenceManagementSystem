import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.Console;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("configuration");

        context.getBean(Console.class).run();

        System.out.println("Bye");
    }
}
