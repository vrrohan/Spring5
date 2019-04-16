package springhib;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerImpl implements PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public PlayerImpl() {
	}

	public Player getPlayerInfoById(int playerId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Player player = (Player) session.get(Player.class, new Integer(playerId));
		tr.commit();
		session.close();
		return player;
	}

	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Player> employeeList = session.createQuery("from Player").list();
		session.close();
		return employeeList;
	}

	public Player addNewPlayer(Player player) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try {
			trans = session.beginTransaction();
			session.persist(player);
			trans.commit();
			return player;
		} catch (HibernateException hibe) {
			return null;
		} finally {
			session.close();
		}
	}

	public void deletePlayerById(int playerId) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Player p = new Player();
		p.setPlayerId(playerId);
		session.delete(p);
		tr.commit();
		session.close();
	}

	@Override
	public void updatePlayerClubById(int playerId, String clubName) {
		// TODO Auto-generated method stub
		Session session = getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Player pl = (Player) session.get(Player.class, playerId);
		pl.setClub(clubName);
		session.update(pl);
		tr.commit();
		session.close();
	}

	public void displayAllPlayers() {
		List<Player> allPlayers = getAllPlayers();
		allPlayers.forEach(x -> System.out.println(x));
	}

}
