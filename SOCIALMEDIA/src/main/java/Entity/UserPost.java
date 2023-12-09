package Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserPost")
@NamedQuery(name = "UserPost.findAll", query = "select uP from UserPost uP")
public class UserPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPostID;
	
	private String userPostText;
	private Date UserPostCreateTime;
	private boolean UserPostStatus;
	private Date userPostUpdateTime;
	private String userPostImage; // mới thêm
	// User đã đăng bài viết này.
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
//	@OneToMany(mappedBy = "userPost", cascade = CascadeType.ALL)
//    private List<LikeUserPost> likedByUsers;
//	
//	public List<LikeUserPost> getLikedByUsers() {
//		return likedByUsers;
//	}
//	public void setLikedByUsers(List<LikeUserPost> likedByUsers) {
//		this.likedByUsers = likedByUsers;
//	}
	@Override
	public String toString() {
		return "UserPost [userPostID=" + userPostID + ", userPostText=" + userPostText + ", UserPostCreateTime="
				+ UserPostCreateTime + ", UserPostStatus=" + UserPostStatus + ", userPostUpdateTime="
				+ userPostUpdateTime + ", userPostImg=" + userPostImage + "]";
	}
	public UserPost() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserPost(int userPostID, String userPostText, Date userPostCreateTime, boolean userPostStatus,
			Date userPostUpdateTime, String userPostImage, User user) {
		super();
		this.userPostID = userPostID;
		this.userPostText = userPostText;
		UserPostCreateTime = userPostCreateTime;
		UserPostStatus = userPostStatus;
		this.userPostUpdateTime = userPostUpdateTime;
		this.userPostImage = userPostImage;
		this.user = user;
	}
	public int getUserPostID() {
		return userPostID;
	}
	public void setUserPostID(int userPostID) {
		this.userPostID = userPostID;
	}
	public String getUserPostText() {
		return userPostText;
	}
	public void setUserPostText(String userPostText) {
		this.userPostText = userPostText;
	}
	public Date getUserPostCreateTime() {
		return UserPostCreateTime;
	}
	public void setUserPostCreateTime(Date userPostCreateTime) {
		UserPostCreateTime = userPostCreateTime;
	}
	public boolean isUserPostStatus() {
		return UserPostStatus;
	}
	public void setUserPostStatus(boolean userPostStatus) {
		UserPostStatus = userPostStatus;
	}
	public Date getUserPostUpdateTime() {
		return userPostUpdateTime;
	}
	public void setUserPostUpdateTime(Date userPostUpdateTime) {
		this.userPostUpdateTime = userPostUpdateTime;
	}
	public String getUserPostImg() {
		return userPostImage;
	}
	public void setUserPostImg(String userPostImage) {
		this.userPostImage = userPostImage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	

}
