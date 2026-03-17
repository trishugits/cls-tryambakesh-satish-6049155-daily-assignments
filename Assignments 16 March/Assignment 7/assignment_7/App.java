package assignment_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

//        System.out.println("Starting Application...");

        ApplicationContext context =
                new ClassPathXmlApplicationContext("assignment7.xml");

        SBU sbu = (SBU) context.getBean("sbu1");

        System.out.println(sbu);
    }
}