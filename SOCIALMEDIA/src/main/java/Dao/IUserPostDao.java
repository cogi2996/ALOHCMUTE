package Dao;

import java.util.List;

import Entity.User;
import Entity.UserPost;

public interface IUserPostDao {
	List<UserPost> paginationPage(int index, int numberOfPage);
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid);
}
