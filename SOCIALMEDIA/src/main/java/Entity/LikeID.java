//package Entity;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//public class LikeID implements Serializable{
//	private static final long serialVersionUID = 1L;
//	@Column(name = "userID")
//    private String userId;
//
//    @Column(name = "userPostID")
//    private int userPostId;
//
//    
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public int getUserPostId() {
//		return userPostId;
//	}
//
//	public void setUserPostId(int userPostId) {
//		this.userPostId = userPostId;
//	}
//
//	public LikeID(String userId, int userPostId) {
//		super();
//		this.userId = userId;
//		this.userPostId = userPostId;
//	}
//
//	 @Override
//	    public boolean equals(Object o) {
//	        if (this == o) return true;
//	        if (o == null || getClass() != o.getClass()) return false;
//	        LikeID that = (LikeID) o;
//	        return Objects.equals(userId, that.userId) &&
//	               Objects.equals(userPostId, that.userPostId);
//	    }
//
//	    @Override
//	    public int hashCode() {
//	        return Objects.hash(userId, userPostId);
//	    }
//}
