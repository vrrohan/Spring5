import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeDrawn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Square sq = (Square) appContext.getBean("mySquare");
		Triangle tri = (Triangle) appContext.getBean("myTriangle");
		sq.drawn();
		tri.drawn();
	
	}

}
