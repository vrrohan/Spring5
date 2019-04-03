import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Circle cirOne = (Circle) appContext.getBean("cir");
		System.out.println(cirOne);
		cirOne.draw();

		/*
		 * WARNING: Exception encountered during context initialization -
		 * cancelling refresh attempt:
		 * org.springframework.beans.factory.BeanCreationException: Error
		 * creating bean with name 'cir' defined in class path resource
		 * [beans.xml]: Initialization of bean failed; nested exception is
		 * org.springframework.beans.factory.BeanInitializationException:
		 * Property 'center' is required for bean 'cir' Exception in thread
		 * "main" org.springframework.beans.factory.BeanCreationException: Error
		 * creating bean with name 'cir' defined in class path resource
		 * [beans.xml]: Initialization of bean failed; nested exception is
		 * org.springframework.beans.factory.BeanInitializationException:
		 * Property 'center' is required for bean 'cir'
		 */
	}

}
