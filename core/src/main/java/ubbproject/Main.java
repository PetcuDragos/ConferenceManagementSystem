package ubbproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ubbproject.ui.Console;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ubbproject/configuration");

        context.getBean(Console.class).run();

        System.out.println("Bye");
    }
}
