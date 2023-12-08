package Dao;

import java.util.List;

import Entity.LikeUserPost;
import Entity.UserPost;

public interface IUserPostDao {
	List<UserPost> paginationPage(int index, int numberOfPage);
	//hieu-begin
	void update(UserPost userPost);
	void delete(int userPostID);
	Long countAll();//hieu them
	LikeUserPost findLikeUserPost(int userPostID);
	Long countLike(int userPostID);
	//hieu-end
	
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
	void insertUserLikePost(LikeUserPost likePost);
}
