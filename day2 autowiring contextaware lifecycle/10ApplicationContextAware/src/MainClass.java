import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
ApplicationContext is an interface for providing configuration information to an application. There are multiple classes provided by springframework that implements this interface and helps us use configuration information in applications. 
ApplicationContext provides standard bean factory lifecycle capabilities. An important capability which we will be using in below code 
Example is- class implementing ApplicationContext should scan for ApplicationContextAware beans and invoke setApplicationContext by passing an implementation of its instance. 

ApplicationContext vs BeanFactory
BeanFactory is a subset of ApplicaitonContext and provides lesser functionalities. When we need full capabilities with respect to configuration handling then we go for ApplicationContext.

How to access ApplicationContext inside a java bean?
To get access to ApplicationContext we should implement ApplicationContextAware interface in the respective java bean. It has a method -

	void setApplicationContext(ApplicationContext applicationContext) throws BeansException

The ApplicationContext implementation which we are using in our application will invoke this method and pass the concrete object for AppplicationContext. 
Using this we can get access to all the configuration information.
In the case of spring web application we have a utility class provided by spring framework called WebApplicationContextUtils.

	ServletContext servletContext = this.getServletContext();
	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

We can use this utility to get application context but we need to provide the respective servletcontext as parameter.
*/

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Triangle triA = (Triangle) appContext.getBean("tri");
		System.out.println(triA);
	}

}
