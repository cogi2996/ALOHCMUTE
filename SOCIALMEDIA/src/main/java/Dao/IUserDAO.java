package Dao;

import java.util.List;

import Entity.User;

public interface IUserDAO {
	User findUser(int userID);
	List<User> SortUserByCreateDate(List<User> list);
}
