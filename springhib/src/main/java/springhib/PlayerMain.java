package springhib;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext con = new ClassPathXmlApplicationContext("springhib/beans.xml");
		PlayerImpl p = (PlayerImpl) con.getBean("playerDao");
		List<Player> pl = p.getAllPlayers();
		pl.forEach(x -> System.out.println(x));
		
		Player newPlayer = new Player(110, "testFirstname", "testLastname", 18, 18, "testClub", "testCountry");
		Player pAdd = p.addNewPlayer(newPlayer);
		if(pAdd != null) {
			System.out.println("New Player added successfully");
		}
		else {
			System.out.println("Player already present");
		}
		p.displayAllPlayers();
	
		p.deletePlayerById(110);
		p.displayAllPlayers();
		
		p.updatePlayerClubById(105, "Arsenal");
		p.displayAllPlayers();
		
		
	}

}
