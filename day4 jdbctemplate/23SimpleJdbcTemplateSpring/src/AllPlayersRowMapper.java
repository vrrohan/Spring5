import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class AllPlayersRowMapper implements ResultSetExtractor<List<Player>> {

	@Override
	public List<Player> extractData(ResultSet result) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		List<Player> allPlayers = new ArrayList<Player>();
		while(result.next()) {
			Player playerInfo = new Player();
			playerInfo.setPlayerId(result.getInt("playerid"));
			playerInfo.setFirstName(result.getString("firstname"));
			playerInfo.setLastName(result.getString("lastname"));
			playerInfo.setAge(result.getInt("age"));
			playerInfo.setGoals(result.getInt("goals"));
			playerInfo.setClub(result.getString("club"));
			playerInfo.setCountry(result.getString("country"));
			allPlayers.add(playerInfo);
		}
		return allPlayers;
	}

}
