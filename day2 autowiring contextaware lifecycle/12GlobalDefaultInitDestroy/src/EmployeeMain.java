import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		appContext.registerShutdownHook();
		//This bean is initialized & cleanup using xml configurations
		Employee empOne = (Employee) appContext.getBean("empBean");
		System.out.println(empOne);
		
		//This bean is initialed & cleaned up using interfaces - InitializingBean & DisposableBean
		Intern intOne = (Intern) appContext.getBean("intBean");
		System.out.println(intOne);
	}

}
