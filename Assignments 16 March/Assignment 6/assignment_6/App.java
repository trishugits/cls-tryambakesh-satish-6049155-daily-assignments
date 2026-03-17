package assignment_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String args[]) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("assignment6.xml");
		Employee e=(Employee)ac.getBean("emp1");
		System.out.println("Employee details\n" +
	           "--------------------------");
		System.out.println(e);
		((AbstractApplicationContext) ac).close();
	}
}
