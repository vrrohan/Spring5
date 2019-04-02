import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		//This bean is initialized & cleanup using xml configurations
		Employee empOne = (Employee) appContext.getBean("empBean");
		System.out.println(empOne);
		
	}

}
