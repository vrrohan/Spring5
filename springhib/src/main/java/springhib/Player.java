package springhib;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="player")
public class Player {

	@Id
	@Column(name = "playerid")
	public int playerId;
	@Column(name = "firstname")
	public String firstName;
	@Column(name = "lastname")
	public String lastName;
	@Column(name = "age")
	public int age;
	@Column(name = "goals")
	public int goals;
	@Column(name = "club")
	public String club;
	@Column(name = "country")
	public String country;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(int playerId, String firstName, String lastName, int age, int goals, String club, String country) {
		super();
		this.playerId = playerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.goals = goals;
		this.club = club;
		this.country = country;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Player [" + playerId + ", " + firstName + ", " + lastName + ", " + age
				+ ", " + goals + ", " + club + ", " + country + "]";
	}

}
