package Model;

public class UserModel {
	private String gmail;
	private String password;
	private String mobile;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String position;
	private String workPlace;
	private String code;
	private int status;
	private String biography;
	private String avatar;
	private String userID;
	
	@Override
	public String toString() {
		return "User [gmail=" + gmail + ", password=" + password + ", mobile=" + mobile + ", firstName=" + firstName
				+ ", midName=" + midName + ", lastName=" + lastName + ", address=" + address + ", position=" + position
				+ ", workPlace=" + workPlace + ", code=" + code + ", status=" + status + "]";
	}

	public UserModel(String gmail, String password, String mobile, String firstName, String midName, String lastName,
			String address, String position) {
		super();
		this.gmail = gmail;
		this.password = password;
		this.mobile = mobile;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.position = position;
	}

	
	public UserModel(String mobile, String firstName, String midName, String lastName, String address, String position,
			String workPlace, String biography, String avatar, String userID) {
		super();
		this.mobile = mobile;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.position = position;
		this.workPlace = workPlace;
		this.biography = biography;
		this.avatar = avatar;
		this.userID = userID;
	}

	public UserModel(String mobile, String firstName, String midName, String lastName, String address, String position, String workPlace, String biography, String avatar) {
		this.mobile = mobile;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.position = position;
		this.workPlace = workPlace;
		this.biography = biography;
		this.avatar = avatar;
	}

	public UserModel(String mobile, String firstName, String midName, String lastName, String address, String position,
			String workPlace) {
		super();
		this.mobile = mobile;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.position = position;
		this.workPlace = workPlace;
	}
	
	
	public UserModel(String firstName, String midName, String lastName) {
		super();
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserModel() {
		super();
		this.status = 0; // chưa active
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
