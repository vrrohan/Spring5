import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PlayerNameGoalsClubCountryMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet resultSet, int columnNum) throws SQLException {
		// TODO Auto-generated method stub
		String playerInfo = "";
		playerInfo += "Player Name : " + resultSet.getString("firstname") + " " + resultSet.getString("lastname")
				+ "\nTotal Goals : " + resultSet.getInt("goals") + "\nClub : " + resultSet.getString("club")
				+ "\nCountry : " + resultSet.getString("country");
		return playerInfo;
	}

}
