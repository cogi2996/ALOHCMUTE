package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import Dao.IUserDAO;
import Dao.UserDAOImpl;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String userID;
	private String mobile;
	@Temporal(value = TemporalType.DATE)
	private Date createDate;
	@Temporal(value = TemporalType.DATE)
	private Date lastLogin;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String biography;
	private String position;
	private String workPlace;
	private String avatar;
	private int role;
	// Các group được tạo bởi user.
	@OneToMany(mappedBy = "admin")
	private List<Group> createdGroup;

	// Các group mà user là thành viên.
	@ManyToMany
	@JoinTable(name = "GroupMember", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "groupID"))
	private List<Group> UserGroups;

	// Những người user đã chat
	@ManyToMany
	@JoinTable(name = "Chat", joinColumns = @JoinColumn(name = "sourceID"), inverseJoinColumns = @JoinColumn(name = "targetID"))
	private List<User> chats;
	// Các bài viết ( cá nhân ) của user.
	@OneToMany(mappedBy = "user")
	private List<UserPost> userPosts;

	// Các bài viết ( group ) của user.
	@OneToMany(mappedBy = "user")
	private List<GroupPost> groupPosts;

	// Những người user đã gửi follow.
	@ManyToMany
	@JoinTable(name = "Follow", joinColumns = @JoinColumn(name = "sourceID"), inverseJoinColumns = @JoinColumn(name = "targetID"))
	private List<User> followingUsers;

	// Những người follow user
	@ManyToMany(mappedBy = "followingUsers")
	private List<User> followers;

	// Những bài viết mà user đã like
	@ManyToMany
	@JoinTable(name = "LikeUserPost", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "userPostID"))
	private List<UserPost> likePosts;

	@Override
	public String toString() {
		return "User [userID=" + userID + ", mobile=" + mobile + ", createDate=" + createDate + ", lastLogin="
				+ lastLogin + ", firstName=" + firstName + ", midName=" + midName + ", lastName=" + lastName
				+ ", address=" + address + ", biography=" + biography + ", position=" + position + ", workPlace="
				+ workPlace + ", avatar=" + avatar + "]";
	}

	public User(String userID, String mobile, Date createDate, Date lastLogin, String firstName, String midName,
			String lastName, String address, String biography, String position, String workPlace, String avatar,
			int role) {
		super();
		this.userID = userID;
		this.mobile = mobile;
		this.createDate = createDate;
		this.lastLogin = lastLogin;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.biography = biography;
		this.position = position;
		this.workPlace = workPlace;
		this.avatar = avatar;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
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

	public List<Group> getCreatedGroup() {
		return createdGroup;
	}

	public void setCreatedGroup(List<Group> createdGroup) {
		this.createdGroup = createdGroup;
	}

	public List<Group> getUserGroups() {
		return UserGroups;
	}

	public void setUserGroups(List<Group> userGroups) {
		UserGroups = userGroups;
	}

	/*
	 * public Account getAccount() { return account; }
	 * 
	 * public void setAccount(Account account) { this.account = account; }
	 */

	public List<UserPost> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<UserPost> userPosts) {
		this.userPosts = userPosts;
	}

	public List<GroupPost> getGroupPosts() {
		return groupPosts;
	}

	public void setGroupPosts(List<GroupPost> groupPosts) {
		this.groupPosts = groupPosts;
	}

	public List<User> getFollowingUsers() {
		return followingUsers;
	}

	public void setFollowingUsers(List<User> followingUsers) {
		this.followingUsers = followingUsers;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	// Contructor của tạo user ChatAPI
	public User(String userID, Date lastLogin, String firstName, String midName, String lastName, String position,
			String avatar) {
		super();
		this.userID = userID;
		this.lastLogin = lastLogin;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.position = position;
		this.avatar = avatar;
	}

	public List<UserPost> getLikePosts() {
		return likePosts;
	}

	public void setLikePosts(List<UserPost> likePosts) {
		this.likePosts = likePosts;
	}

}
