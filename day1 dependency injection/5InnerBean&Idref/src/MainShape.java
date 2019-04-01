import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * In the bean configuration file(beans.xml) there are four beans(ids are triangle, pointA, pointB and pointC) defined in the previous chapter suppose that beans (pointB and pointC) of the Point class are using only for triangle bean definition 
		 * then there no need to defined the Point been in separately in the  bean configuration file(spring.xml) and 
		 * pointA is the common point using by different shape as Circle, Rectangle etc si its defined separately in the  bean configuration file(spring.xml). 
		 * The best idea at this situation we have to defined Point bean ‘s definition as inner bean definition with in the Triangle bean.
		 */
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Line l1 = (Line) appContext.getBean("lin");
		System.out.println(l1);
		
		Triangle tr = (Triangle) appContext.getBean("tri");
		System.out.println(tr);
		
		Circle cr = (Circle) appContext.getBean("cir");
		System.out.println(cr);
		
		Circle cr2 = (Circle) appContext.getBean("myCircleAlias");
		System.out.println(cr2);
		
		//Difference between ref and idref: In ref can have the value of id of bean as well as name of the bean.
		//But the idref can have only and only id of the bean.
	}

}
