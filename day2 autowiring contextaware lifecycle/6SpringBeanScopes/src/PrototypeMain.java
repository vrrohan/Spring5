import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
A bean with prototype scope will return a different instance every time it is requested from the container. It is defined by setting the value of scope="prototype" in xml.
link - https://docs.spring.io/spring/docs/3.0.0.M3/reference/html/ch04s04.html
*/

public class PrototypeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Person pA = (Person) appContext.getBean("protoPer");
		Person pB = (Person) appContext.getBean("protoPer");
		Person pC = (Person) appContext.getBean("protoPer");
		
		System.out.println(pA);
		System.out.println(pB);
		System.out.println(pC);

		pB.setName("steve");
		pB.setAge(77);

		System.out.println(pA);
		System.out.println(pB);
		System.out.println(pC);
		
		pC.setName("mark");
		pC.setAge(50);
		
		//two objects requesting the same bean name with scope prototype will have different states, as they are no longer referring to the same bean instance
		System.out.println(pA);
		System.out.println(pB);
		System.out.println(pC);
	}

}
