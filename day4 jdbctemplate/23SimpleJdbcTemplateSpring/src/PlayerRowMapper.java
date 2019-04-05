import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayerRowMapper implements RowMapper<Player>{

	@Override
	public Player mapRow(ResultSet resultSet, int columnNumber) throws SQLException {
		// TODO Auto-generated method stub
		Player playerInfo = new Player();
		playerInfo.setPlayerId(resultSet.getInt("playerid"));
		playerInfo.setFirstName(resultSet.getString("firstname"));
		playerInfo.setLastName(resultSet.getString("lastname"));
		playerInfo.setAge(resultSet.getInt("age"));
		playerInfo.setGoals(resultSet.getInt("goals"));
		playerInfo.setClub(resultSet.getString("club"));
		playerInfo.setCountry(resultSet.getString("country"));
		return playerInfo;
	}

}
