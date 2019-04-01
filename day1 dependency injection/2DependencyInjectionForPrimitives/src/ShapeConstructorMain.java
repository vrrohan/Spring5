import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import constructorinjection.Circle;

public class ShapeConstructorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cont = new ClassPathXmlApplicationContext("springbeans.xml");
		Circle c = (Circle) cont.getBean("myCircle");
		c.drawn();
		
		Circle c2 = (Circle) cont.getBean("myCircle2");
		c2.drawn();
		
		Circle c3 = (Circle) cont.getBean("myCircle3");
		c3.drawn();
		
		Circle c4 = (Circle) cont.getBean("myCircle4");
		c4.drawn();
		
	/*	Circle c5 = (Circle) cont.getBean("myCircle5");
		c5.drawn();*/
	}

}
