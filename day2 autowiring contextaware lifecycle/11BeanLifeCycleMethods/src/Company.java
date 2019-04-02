
public class Company {
	public String compName;
	public String compLocation;
	public String compInfo;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String companyName) {
		this.compName = companyName;
	}

	public String getCompLocation() {
		return compLocation;
	}

	public void setCompLocation(String companyLocation) {
		this.compLocation = companyLocation;
	}

	public String getCompInfo() {
		return compInfo;
	}

	public void setCompInfo(String companyInfo) {
		this.compInfo = companyInfo;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + compName + ", companyLocation=" + compLocation + ", companyInfo="
				+ compInfo + "]";
	}

}
