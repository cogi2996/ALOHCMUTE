package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@IdClass(GroupMemberId.class)
@Table(name = "GroupMember")
@NamedQuery(name = "GroupMember.findAll", query = "select gm from GroupMember gm")
public class GroupMember implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private int groupID;
	@Id
	private String  userID;

	private int permission;

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

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public GroupMember(int groupID, String userID, int permission) {
		super();
		this.groupID = groupID;
		this.userID = userID;
		this.permission = permission;
	}

	public GroupMember() {
		super();
	}

	@Override
	public String toString() {
		return "GroupMember [groupID=" + groupID + ", userID=" + userID + ", permission=" + permission + "]";
	}
	
	
}
