import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Circle cirOne = (Circle) appContext.getBean("cir");
		System.out.println(cirOne);
		cirOne.draw();

	}

}
