import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
The scope of a bean defines the life cycle and visibility of that bean in the contexts in which it is used.
The latest version of Spring framework defines 6 types of scopes:

singleton
prototype
request
session
application
websocket

The last four scopes mentioned request, session, application and websocket are only available in a web-aware application.
*/

/*
Defining a bean with singleton scope means the container creates a single instance of that bean, and all requests for that bean name will return the same object, which is cached. 
Any modifications to the object will be reflected in all references to the bean. This scope is the default value if no other scope is specified.
*/

public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Person pA = (Person) appContext.getBean("per");
		Person pB = (Person) appContext.getBean("per");
		Person pC = (Person) appContext.getBean("per");

		System.out.println(pA);
		System.out.println(pB);
		System.out.println(pC);

		//two objects referring to the same bean will have the same values, even if only one of them changes their state, as they are both referencing the same bean instance

		
		pC.setName("Elon");
		pC.setAge(44);

		System.out.println(pA);
		System.out.println(pB);
		System.out.println(pC);

	}

}
