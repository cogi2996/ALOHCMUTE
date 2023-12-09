package Entity;

import java.io.Serializable;
import java.util.Objects;

public class GroupMemberId implements Serializable{

	private static final long serialVersionUID = 1L;
	protected int groupID;
	protected String  userID;
	
	
	public GroupMemberId() {
		super();
	}
	public GroupMemberId(int groupID, String userID) {
		super();
		this.groupID = groupID;
		this.userID = userID;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof GroupMemberId))
			return false;
		GroupMemberId groupMemberId = (GroupMemberId) o;
		return Objects.equals(getUserID(), groupMemberId.getUserID())
				&& Objects.equals(getGroupID(), groupMemberId.getGroupID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getGroupID(), getUserID());
	}
}
