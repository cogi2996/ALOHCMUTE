package Entity;

import java.io.Serializable;
import java.util.Objects;

public class LikeID implements Serializable{
	private static final long serialVersionUID = 1L;
	protected String userID;
	protected int userPostID;
	
	public LikeID() {

	}
	
	public LikeID(String userID, int userPostID) {
		super();
		this.userID = userID;
		this.userPostID = userPostID;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getUserPostID() {
		return userPostID;
	}
	public void setUserPostID(int userPostID) {
		this.userPostID = userPostID;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LikeID))
			return false;
		LikeID likeID = (LikeID) o;
		return Objects.equals(getUserID(), likeID.getUserID())
				&& Objects.equals(getUserPostID(), likeID.getUserPostID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserID(), getUserPostID());
	}
}
