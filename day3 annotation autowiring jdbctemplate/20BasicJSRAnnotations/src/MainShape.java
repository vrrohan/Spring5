import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		appContext.registerShutdownHook();
		Circle cirOne = (Circle) appContext.getBean("cir");
		System.out.println(cirOne);
		cirOne.draw();

	}

}
