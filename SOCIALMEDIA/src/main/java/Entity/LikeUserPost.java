package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity

@Table(name = "likeUserPost")
@NamedQuery(name = "LikeUserPost.findAll", query = "select l from LikeUserPost l")
public class LikeUserPost implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int userPostID;

	private Date likeTime;

	@ManyToMany
    @JoinColumn(name = "userID") // Xác định cột trên bảng LikeUserPost tham chiếu đến cột userID của bảng User
    private List<User> user;
	
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public LikeUserPost(int userPostID, Date likeTime, List<User> user) {
		super();
		this.userPostID = userPostID;
		this.likeTime = likeTime;
		this.user = user;
	}

	public LikeUserPost( int userPostID, Date likeTime) {
		super();
		this.userPostID = userPostID;
		this.likeTime = likeTime;
	}

	public LikeUserPost() {
		super();
	}

	public int getUserPostID() {
		return userPostID;
	}

	public void setUserPostID(int userPostID) {
		this.userPostID = userPostID;
	}

	public Date getLikeTime() {
		return likeTime;
	}

	public void setLikeTime(Date likeTime) {
		this.likeTime = likeTime;
	}	
}
