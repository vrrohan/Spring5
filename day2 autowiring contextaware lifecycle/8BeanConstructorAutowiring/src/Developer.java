
public class Developer {
	public Language langName;
	public String developerName;

	public Developer(Language langName, String developerName) {
		this.langName = langName;
		this.developerName = developerName;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public Language getLangName() {
		return langName;
	}

	public void setLangName(Language langName) {
		System.out.println("setter method runs");
		this.langName = langName;
	}

	@Override
	public String toString() {
		return "Developer working on " + langName + " , Name is " + developerName;
	}

}
