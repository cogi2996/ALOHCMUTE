package Services;

import java.util.List;

import Dao.IUserDAO;
import Dao.UserDAOImpl;
import Entity.User;

public class UserServiceImpl implements IUserService{
	IUserDAO userDAO = new UserDAOImpl();
	@Override
	public List<User> findFollowersByUserId(int userId) {
		return userDAO.findFollowersByUserId(userId);
	}

}
