package ru.otus.students.testing;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.students.testing.service.PrintService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        PrintService printService = context.getBean(PrintService.class);

        printService.print();
    }
}
