package Dao;

import Entity.User;

public interface IUserDAO {
	User findUser(int userID);
}
