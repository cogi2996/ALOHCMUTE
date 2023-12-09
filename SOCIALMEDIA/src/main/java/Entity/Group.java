package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`Group`") // GROUP TRÙNG TÊN TỪ KHOÁ MYSQL NÊN PHẢI DÙNG `` ĐỂ BIỂU THỊ NÓ KHÔNG PHẢI KHOÁ
@NamedQuery(name = "Group.findGroupsByUserId", query = "SELECT g FROM Group g JOIN g.member m WHERE m.userID = :userId")
@NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupID;
	private String groupName;
	@Temporal(value = TemporalType.DATE)
	private Date createTime;
	// admin của group
	@ManyToOne
	@JoinColumn(name = "createrID", referencedColumnName="userID") // createID table group tham chieu toi column userId in table user
	private User admin;

	
	// các thành viên trong group
	@ManyToMany(mappedBy = "UserGroups")
	private List<User> member;
/*
	// 1 - n với grouppost
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "group")
	private List<GroupPost> listPost;*/

	@Override
	public String toString() {
		return "Group [groupID=" + groupID + ", groupName=" + groupName + ", createTime=" + createTime + "]";
	}

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	public Group(int groupID, String groupName, Date createTime, User admin, List<User> member,
			List<GroupPost> listPost) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.createTime = createTime;
		this.admin = admin;
		this.member = member;
		this.listPost = listPost;
	}*/

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

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public List<User> getMember() {
		return member;
	}

	public void setMember(List<User> member) {
		this.member = member;
	}
/*
	public List<GroupPost> getListPost() {
		return listPost;
	}

	public void setListPost(List<GroupPost> listPost) {
		this.listPost = listPost;
	}
*/
	
}
