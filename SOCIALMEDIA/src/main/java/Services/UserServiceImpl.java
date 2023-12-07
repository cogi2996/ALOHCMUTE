package Services;


import java.util.List;

import Dao.IUserDAO;
import Dao.UserDAOImpl;
import Entity.User;

public class UserServiceImpl implements IUserService{
	IUserDAO userDAO = new UserDAOImpl();
	
	@Override
	public User findUser(int userID) {
		return userDAO.findUser(userID);
	}
	@Override
	public void insert(User user) {
		userDAO.insert(user);
	}
	@Override
	public void update(User user) {
		userDAO.update(user);		
	}
	@Override
	public List<User> searchUsersByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return userDAO.searchUsersByKeyword(keyword);
	}
}
