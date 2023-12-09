package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Entity.Group;
import Entity.User;
import Entity.UserPost;

public class GroupPostModel {
	private String username;
	private String userid;
	private int postid;
	private String text;
	private Date createTime;
	private String img;
	private Date updateTime; //hiếu thêm
	private int  groupID;
	/*
	public void creategroupPost(HttpServletRequest req, HttpServletResponse resp)
			throws JsonSyntaxException, JsonIOException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		//UserPostModel newPost = gson.fromJson(req.getReader(), UserPostModel.class);
		GroupPostModel newgroupPost = gson.fromJson(req.getReader(), GroupPostModel.class);
		System.out.println("grouppost da post: " + newgroupPost);
		UserPost userPost = new UserPost();
		userPost.setUserPostText(newgroupPost.getText());
		userPost.setUserPostCreateTime(new Date());
		User user = new User();
		user.setUserID(newgroupPost.getUserid());
		userPost.setUser(user);
		Group group = new Group();
		group.setGroupID(newgroupPost.getGroupID());
		userPost.setGroup(group);
		// còn thiếu dữ liệu hình ảnh
		userPost.setUserPostImg(newgroupPost.getImg());
		userPostService.insert(userPost);
		PrintWriter out = resp.getWriter();
		out.println("Đã thêm group post thành công");
		out.close();
	}*/
	
	public GroupPostModel() {
		super();
	}
	
	public GroupPostModel(String username, String userid, int postid, String text, Date createTime, String img,
			Date updateTime, int groupID) {
		super();
		this.username = username;
		this.userid = userid;
		this.postid = postid;
		this.text = text;
		this.createTime = createTime;
		this.img = img;
		this.updateTime = updateTime;
		this.groupID = groupID;
	}
	
	public GroupPostModel(String userid, String text, String img, int groupID) {
		super();
		this.userid = userid;
		this.text = text;
		this.img = img;
		this.groupID = groupID;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	
}
