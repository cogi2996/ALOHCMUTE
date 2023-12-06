package Dao;

import java.util.List;

import Entity.User;

public interface IUserDAO {
	User findUser(int userID);
	User findUser(String id);
	void insert(User user);
	List<User> findAllChat();
	void insertUserChat(User user);
	void deleteChat(User user);
}
