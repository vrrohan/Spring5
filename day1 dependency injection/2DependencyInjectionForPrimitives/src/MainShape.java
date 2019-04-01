
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import setterinjection.Triangle;

public class MainShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Triangle tri = (Triangle) appContext.getBean("myTriangle");
		tri.drawn();
	}

}
