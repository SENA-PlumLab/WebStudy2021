package Project_6th.JAVA.z0717_project;

public class restaurant {	
	private String restNum;
	private String restCorporNum;
	private String restTitle;
	private String restImage;
	private String restAddress;
	private String restPhoneNum;
	private String restPark;
	private String restHours;
	private String restText;
	private String restTag;
	private String restSite;
	private String genreLcate;
	private String genreScate;
	
	public restaurant() {
		super();
	}
	
	
	public restaurant(String restTitle) {
		super();
		this.restTitle = restTitle;
	}


	public restaurant(String restNum, String restCorporNum, String restTitle, String restImage, String restAddress,
			String restPhoneNum, String restPark, String restHours, String restText, String restTag, String restSite,
			String genreLcate, String genreScate) {
		super();
		this.restNum = restNum;
		this.restCorporNum = restCorporNum;
		this.restTitle = restTitle;
		this.restImage = restImage;
		this.restAddress = restAddress;
		this.restPhoneNum = restPhoneNum;
		this.restPark = restPark;
		this.restHours = restHours;
		this.restText = restText;
		this.restTag = restTag;
		this.restSite = restSite;
		this.genreLcate = genreLcate;
		this.genreScate = genreScate;
	}
	public String getRestNum() {
		return restNum;
	}
	public void setRestNum(String restNum) {
		this.restNum = restNum;
	}
	public String getRestCorporNum() {
		return restCorporNum;
	}
	public void setRestCorporNum(String restCorporNum) {
		this.restCorporNum = restCorporNum;
	}
	public String getRestTitle() {
		return restTitle;
	}
	public void setRestTitle(String restTitle) {
		this.restTitle = restTitle;
	}
	public String getRestImage() {
		return restImage;
	}
	public void setRestImage(String restImage) {
		this.restImage = restImage;
	}
	public String getRestAddress() {
		return restAddress;
	}
	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}
	public String getRestPhoneNum() {
		return restPhoneNum;
	}
	public void setRestPhoneNum(String restPhoneNum) {
		this.restPhoneNum = restPhoneNum;
	}
	public String getRestPark() {
		return restPark;
	}
	public void setRestPark(String restPark) {
		this.restPark = restPark;
	}
	public String getRestHours() {
		return restHours;
	}
	public void setRestHours(String restHours) {
		this.restHours = restHours;
	}
	public String getRestText() {
		return restText;
	}
	public void setRestText(String restText) {
		this.restText = restText;
	}
	public String getRestTag() {
		return restTag;
	}
	public void setRestTag(String restTag) {
		this.restTag = restTag;
	}
	public String getRestSite() {
		return restSite;
	}
	public void setRestSite(String restSite) {
		this.restSite = restSite;
	}
	public String getGenreLcate() {
		return genreLcate;
	}
	public void setGenreLcate(String genreLcate) {
		this.genreLcate = genreLcate;
	}
	public String getGenreScate() {
		return genreScate;
	}
	public void setGenreScate(String genreScate) {
		this.genreScate = genreScate;
	}
	
}
