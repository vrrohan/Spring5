import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class PlayerImpl implements PlayerDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	@Qualifier(value = "jdbcTemplate")
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int getTotalNumberOfPlayers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from player", Integer.class);
	}

	@Override
	public Player getPlayerInfoById(int playerId) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("select * from player where playerid = ?", new Object[] { playerId },
					new PlayerRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public String getPlayerClubById(int playerId) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("select club from player where playerid = ?", new Object[] { playerId },
					String.class);
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public String getPlayerGoalsClubCountryInfoById(int playerId) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject(
					"select firstname, lastname, goals, club, country from player where playerid = ?",
					new Object[] { playerId }, new PlayerNameGoalsClubCountryMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public Player getPlayerInfoByLastnameAndClub(String lastName, String club) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.queryForObject("select * from player where lastname = ? and club = ?",
					new Object[] { lastName, club }, new PlayerRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.query("select * from player", new AllPlayersRowMapper());
		} catch (EmptyResultDataAccessException exception) {
			return null;
		}
	}

	@Override
	public int addNewPlayer(int playerId, String firstName, String lastName, int age, int goals, String club,
			String country) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.update("insert into player values (?, ?, ?, ?, ?, ?, ?)", playerId, firstName, lastName,
					age, goals, club, country);
		} catch (Exception exception) {
			return -1;
		}
	}

	@Override
	public int deletePlayerById(int playerId) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.update("delete from player where playerid = ?", playerId);
		}
		catch(Exception exception) {
			return -1;
		}
	}

	@Override
	public int updatePlayerClubById(int playerId, String newClubName) {
		// TODO Auto-generated method stub
		try {
			return jdbcTemplate.update("update player set club = ? where playerid = ?", newClubName, playerId);
		}
		catch(Exception exception) {
			return -1;
		}
	}

}
