package Model;

import java.util.Date;

public class FollowModel {
	private String userID;
	private String mobile;
	private Date createDate;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String biography;
	private String position;
	private String workPlace;
	private String avatar;
	
	
	
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public FollowModel() {
		super();
	}

	public FollowModel(String userID, String mobile, Date createDate, String firstName, String midName, String lastName,
			String address, String biography, String position, String workPlace, String avatar) {
		super();
		this.userID = userID;
		this.mobile = mobile;
		this.createDate = createDate;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.biography = biography;
		this.position = position;
		this.workPlace = workPlace;
		this.avatar = avatar;
	}
	
	
	
}
