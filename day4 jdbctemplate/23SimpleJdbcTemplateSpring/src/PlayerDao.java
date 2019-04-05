import java.util.List;

public interface PlayerDao {

	public int getTotalNumberOfPlayers();

	public Player getPlayerInfoById(int playerId);
	
	public String getPlayerClubById(int playerId);
	
	public String getPlayerGoalsClubCountryInfoById(int playerId);
	
	public Player getPlayerInfoByLastnameAndClub(String lastName, String club);
	
	public List<Player> getAllPlayers();
	
	public int addNewPlayer(int playerId, String firstName, String lastName, int age, int goals, String club, String country);
	
	public int deletePlayerById(int playerId);
	
	public int updatePlayerClubById(int playerId, String newClubName);

}
