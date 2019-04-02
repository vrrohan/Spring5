
public class Developer {
	public Language langName;

	public Developer(Language langName) {
		System.out.println("constructor autowiring");
		this.langName = langName;
	}

	public Language getLangName() {
		return langName;
	}

	public void setLangName(Language langName) {
		System.out.println("setter autowiring by Type");
		this.langName = langName;
	}

	public Developer() {

	}

	@Override
	public String toString() {
		return "Developer working on " + langName;
	}

}
