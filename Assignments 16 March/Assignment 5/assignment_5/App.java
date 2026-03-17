package assignment_5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String args[]) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("assignment5.xml");
		Employee e=(Employee)ac.getBean("emp1");
		System.out.println(e);
		((AbstractApplicationContext) ac).close();
	}
}
