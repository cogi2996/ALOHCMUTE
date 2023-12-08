package Dao;

import java.util.List;

import Entity.User;
import Entity.UserPost;

public interface IUserPostDao {
	List<UserPost> paginationPage(int index, int numberOfPage);
//	 UserPost likeUserPost(int userPostID);
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
	//hieu-begin
	void update(UserPost userPost);
	void delete(int userPostID);
	Long countAll();//hieu them
	//hieu-end
	
}
