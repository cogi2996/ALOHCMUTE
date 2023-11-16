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
	public List<User> SortUserByName(List<User> list) {
		return userDAO.SortUserByName(list);
	}

}
