package Dao;

import java.sql.Date;
import java.util.List;

import Entity.UserPost;

public interface IUserPostDao {
	List<UserPost> paginationPage(int index, int numberOfPage);
//	 UserPost likeUserPost(int userPostID);
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
	public List<UserPost> paginationPostProfile(int index, int numberOfPage, String uid);

	//hieu-begin
	void update(UserPost userPost);
	void delete(int userPostID);
	Long countAll();//hieu them
	//hieu-end
	List<UserPost> paginationPageSearchUserPost(int index, int numberOfPage,String keyword);
	Long countSearchUserPost(String keyword);
	// tuan - begin - like post
	void insertLikePost(String userID,int userPostID,Date likeTime);
	//tuan -end - like post
	UserPost findOne(int userPostID);
	// tin begin
	List<UserPost> GroupPostBygroupID(int groupID);
	// tin end
	void unlikePost(int userPostID,String userID);
	boolean liked (int userPostID,String userID);
	List<UserPost> findAllImg(String uid);

}
