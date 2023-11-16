package Dao;

import java.util.List;

import Entity.User;

public interface IUserDAO {
	List<User> findFollowersByUserId(int userId);
}
