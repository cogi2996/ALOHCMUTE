package Services;

import java.util.List;

import Entity.UserPost;

public interface IUserPostService {
	List<UserPost> paginationPage(int index, int numberOfPage);
	void insert(UserPost userPost);
	// hieu-begin
	void update(UserPost userPost);
	void delete(int userPostID);
	Long countAll();
//	UserPost findLikeUserPost(int userPostID);
//	Long countLike(int userPostID);
//	void insertUserLikePost(LikeUserPost likePost);
//	void deleteUserLike(String userID, int userPostID);
	List<UserPost> paginationPageSearchUserPost(int index, int numberOfPage,String keyword);
	Long countSearchUserPost(String keyword);
	// hieu-end
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
}
