package Dao;

import java.util.List;

import Entity.UserPost;

public interface IUserPostDao {
	List<UserPost> paginationPage(int index, int numberOfPage);
	 UserPost likeUserPost(int userPostID);
}
