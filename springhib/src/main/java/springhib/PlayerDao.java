package springhib;


import java.util.List;

public interface PlayerDao {

	public Player getPlayerInfoById(int playerId);

	public List<Player> getAllPlayers();

	public Player addNewPlayer(Player player);

	public void deletePlayerById(int playerId);

	public void updatePlayerClubById(int playerId, String clubName);

}
