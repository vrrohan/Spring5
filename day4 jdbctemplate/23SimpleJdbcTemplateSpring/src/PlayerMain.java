import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlayerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		appContext.registerShutdownHook();
		PlayerImpl plyOne = (PlayerImpl) appContext.getBean("ply");

		// getting total number of players
		System.out.println("Total number of players are : " + plyOne.getTotalNumberOfPlayers());

		// getting player info by id
		Player playerInfoById = plyOne.getPlayerInfoById(105);
		System.out.println(playerInfoById);

		// getting player club by id
		int playerClubId = 107;
		System.out.println("Player club with id " + playerClubId + " is : " + plyOne.getPlayerClubById(107));
		
		//getting player name, goal, club & country by id
		System.out.println(plyOne.getPlayerGoalsClubCountryInfoById(101));
		
		//get player info by lastname & club by passing id
		if (plyOne.getPlayerInfoByLastnameAndClub("mesi", "barcelona") != null) {
			System.out.println(plyOne.getPlayerInfoByLastnameAndClub("messi", "barcelona"));
		}
		else {
			System.out.println("Incorrect lastname or clubname");
		}
		
		//List & display all players
		List<Player> p = plyOne.getAllPlayers();
		p.forEach(x -> System.out.println(x));
		
		//Add a new player
		int rowsInserted = plyOne.addNewPlayer(105, "gareth", "bale", 32, 140, "real madrid", "wales");
		if (rowsInserted > 0) {
			System.out.println("New player inserted");
		}
		else {
			System.out.println("unable to insert new player");
		}
		
		//delete player by id
		int playerIdDelete = 1099;
		int rowsDeleted = plyOne.deletePlayerById(playerIdDelete);
		if (rowsDeleted > 0) {
			System.out.println("Player with id " + playerIdDelete + " deleted.");
		}
		else {
			System.out.println("No player with id " + playerIdDelete + " exists. Unable to delete...");
		}
		
		//update player club by id
		int rowsUpdated = plyOne.updatePlayerClubById(199, "bayern");
		if (rowsUpdated > 0) {
			System.out.println("player with id 109 updated. New club is bayern");
		}
		else {
			System.out.println("Incorrect id or clubname, unable to update.");
		}
	}

}
