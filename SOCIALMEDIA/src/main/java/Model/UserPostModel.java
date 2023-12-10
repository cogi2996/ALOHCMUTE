package Model;

import java.util.Date;

public class UserPostModel {
	private String username;
	private String userid;
	private int postid;
	private String text;
	private Date createTime;
	private String img;
	private Date updateTime; // hiếu thêm
	private String userAvatar;

	@Override
	public String toString() {
		return "[username=" + username + ", userid=" + userid + ", postid=" + postid + ", text=" + text
				+ ", createTime=" + createTime + ", img=" + img + "]";
	}

	public UserPostModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPostModel(String username, String userid, int postid, String text, Date createTime, String img) {
		super();
		this.username = username;
		this.userid = userid;
		this.postid = postid;
		this.text = text;
		this.createTime = createTime;
		this.img = img;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
