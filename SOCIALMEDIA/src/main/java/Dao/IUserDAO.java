package Dao;

import java.util.List;

import Entity.User;

public interface IUserDAO {
	User findUser(int userID);
	List<User> SortUserByName(List<User> list);
	List<User> SortUserByWorkplace(List<User> list);
}
