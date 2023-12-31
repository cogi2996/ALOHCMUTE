package Model;

import java.util.Date;

import Entity.User;

public class GroupModel {
	private int groupID;
	private String groupName;
	private Date createTime;
	private String createrID;
	private int numberOfFollower; 
	
	public GroupModel(int groupID, String groupName, Date createTime, String createrId) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.createTime = createTime;
		this.createrID = createrId;
	}

	public GroupModel(int groupID, String groupName, Date createTime, String createrID, int numberOfFollower) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.createTime = createTime;
		this.createrID = createrID;
		this.numberOfFollower = numberOfFollower;
	}

	@Override
	public String toString() {
		return "GroupModel [groupID=" + groupID + ", groupName=" + groupName + ", createTime=" + createTime
				+ ", createrId=" + createrID + "]";
	}

	public GroupModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreaterId() {
		return createrID;
	}
	public void setCreaterId(String createrId) {
		this.createrID = createrId;
	}

	public int getNumberOfFollower() {
		return numberOfFollower;
	}

	public void setNumberOfFollower(int numberOfFollower) {
		this.numberOfFollower = numberOfFollower;
	}
	
	
}
