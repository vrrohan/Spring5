import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Intern implements InitializingBean, DisposableBean{
	public String name;
	public String desig;
	public Company compName;
	public Address address;

	public Intern() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public Company getCompName() {
		return compName;
	}

	public void setCompName(Company compName) {
		this.compName = compName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Intern [name=" + name + ", desig=" + desig + ", compName=" + compName + ", address=" + address + "]";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Intern bean is cleaned up...");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Intern Bean is initiated...");
	}

}
