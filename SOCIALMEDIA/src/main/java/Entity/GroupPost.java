package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GroupPost")
@NamedQuery(name = "GroupPost.findAll", query = "select p from GroupPost p")

public class GroupPost implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupPostID;
	private String groupPostText;
	private Date groupPostCreateTime;
	private boolean groupPostStatus;
	private Date groupPostUpdateTime;

	// Các bài viết của user đã đăng
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;

	// 1 - n với group
	@ManyToOne
	@JoinTable(name = "GroupMember", joinColumns = @JoinColumn(name = "groupPostID"), inverseJoinColumns = @JoinColumn(name = "groupID"))
	private Group group;

	@Override
	public String toString() {
		return "GroupPost [groupPostID=" + groupPostID + ", groupPostText=" + groupPostText + ", groupPostCreateTime="
				+ groupPostCreateTime + ", groupPostStatus=" + groupPostStatus + ", groupPostUpdateTime="
				+ groupPostUpdateTime + "]";
	}

	public GroupPost(int groupPostID, String groupPostText, Date groupPostCreateTime, boolean groupPostStatus,
			Date groupPostUpdateTime, User user, Group group) {
		super();
		this.groupPostID = groupPostID;
		this.groupPostText = groupPostText;
		this.groupPostCreateTime = groupPostCreateTime;
		this.groupPostStatus = groupPostStatus;
		this.groupPostUpdateTime = groupPostUpdateTime;
		this.user = user;
		this.group = group;
	}

	public GroupPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGroupPostID() {
		return groupPostID;
	}

	public void setGroupPostID(int groupPostID) {
		this.groupPostID = groupPostID;
	}

	public String getGroupPostText() {
		return groupPostText;
	}

	public void setGroupPostText(String groupPostText) {
		this.groupPostText = groupPostText;
	}

	public Date getGroupPostCreateTime() {
		return groupPostCreateTime;
	}

	public void setGroupPostCreateTime(Date groupPostCreateTime) {
		this.groupPostCreateTime = groupPostCreateTime;
	}

	public boolean isGroupPostStatus() {
		return groupPostStatus;
	}

	public void setGroupPostStatus(boolean groupPostStatus) {
		this.groupPostStatus = groupPostStatus;
	}

	public Date getGroupPostUpdateTime() {
		return groupPostUpdateTime;
	}

	public void setGroupPostUpdateTime(Date groupPostUpdateTime) {
		this.groupPostUpdateTime = groupPostUpdateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
