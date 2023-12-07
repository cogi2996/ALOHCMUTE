package Dao;


import java.util.List;

import Entity.User;

public interface IUserDAO {
	User findUser(String userID);
	void insert(User user);
	void update(User user);
	List<User> searchUsersByKeyword(String keyword);
}
