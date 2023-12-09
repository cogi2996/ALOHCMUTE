package Dao;

import java.util.List;

import Entity.User;
import Entity.UserPost;

public interface IUserPostDao {
	List<UserPost> paginationPage(int index, int numberOfPage);
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
	//hieu-begin
	void update(UserPost userPost);
	void delete(int userPostID);
	Long countAll();//hieu them
//	UserPost findLikeUserPost(int userPostID);
//	Long countLike(int userPostID);
//	void deleteUserLike(String userID, int userPostID);
	//hieu-end
	List<UserPost> paginationPageSearchUserPost(int index, int numberOfPage,String keyword);
	Long countSearchUserPost(String keyword);
	//void insertUserLikePost(LikeUserPost likePost);
}
