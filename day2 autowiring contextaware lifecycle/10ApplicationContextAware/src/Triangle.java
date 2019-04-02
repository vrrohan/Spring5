import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware {
	public Point pointA;
	public Point pointB;
	public Point pointC;

	private static ApplicationContext appContext = null;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public ApplicationContext getAppContext() {
		return appContext;
	}

	public void setAppContext(ApplicationContext appContext) {
		this.appContext = appContext;
	}

	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + ", appContext="
				+ appContext.getDisplayName() + "]";
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Spring Bean ApplicationContext " + context.getDisplayName());
		System.out.println("Calling our bean here : ");
		Triangle t = (Triangle) context.getBean("tri");
		System.out.println("{" + t.getPointA().getPointX() + "," + t.getPointA().getPointY() + "}, {"
				+ t.getPointB().getPointX() + "," + t.getPointB().getPointY() + "}, {" + t.getPointC().getPointX() + ","
				+ t.getPointC().getPointY() + "}");
		this.appContext = context;
	}

	public static ApplicationContext getApplicationContext() {
		return appContext;
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("Bean name is " + beanName);
	}

}
