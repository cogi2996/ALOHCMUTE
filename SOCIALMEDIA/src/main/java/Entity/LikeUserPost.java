//package Entity;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.persistence.UniqueConstraint;
//
//@Entity
//@Table(name = "LikeUserPost", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"userID", "userPostID"})
//})
//@NamedQuery(name = "LikeUserPost.findAll", query = "select l from LikeUserPost l")
//public class LikeUserPost implements Serializable{
//	private static final long serialVersionUID = 1L;
//
//	@Id
//    private LikeID id;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "likeTime")
//    private Date likeTime;
//
//    @ManyToOne
//    @JoinColumn(name = "userID", insertable = false, updatable = false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "userPostID", insertable = false, updatable = false)
//    private UserPost userPost;
//
//	public LikeUserPost(LikeID id, Date likeTime, User user, UserPost userPost) {
//		super();
//		this.id = id;
//		this.likeTime = likeTime;
//		this.user = user;
//		this.userPost = userPost;
//	}
//
//	public LikeUserPost() {
//		super();
//	}
//
//	public LikeID getId() {
//		return id;
//	}
//
//	public void setId(LikeID id) {
//		this.id = id;
//	}
//
//	public Date getLikeTime() {
//		return likeTime;
//	}
//
//	public void setLikeTime(Date likeTime) {
//		this.likeTime = likeTime;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public UserPost getUserPost() {
//		return userPost;
//	}
//
//	public void setUserPost(UserPost userPost) {
//		this.userPost = userPost;
//	}
//    
//	
//}
