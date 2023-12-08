package Services;

import java.util.List;

import Entity.LikeUserPost;
import Entity.UserPost;

public interface IUserPostService {
	List<UserPost> paginationPage(int index, int numberOfPage);
	void insert(UserPost userPost);
	// hieu-begin
	void update(UserPost userPost);
	void delete(int userPostID);
	Long countAll();
	LikeUserPost findLikeUserPost(int userPostID);
	Long countLike(int userPostID);
	void insertUserLikePost(LikeUserPost likePost);
	// hieu-end
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
}
