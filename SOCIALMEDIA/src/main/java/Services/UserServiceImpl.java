package Services;


import Dao.IUserDAO;
import Dao.UserDAOImpl;
import Entity.User;

public class UserServiceImpl implements IUserService{
	IUserDAO userDAO = new UserDAOImpl();
	@Override
	public User findUser(String userID) {
		return userDAO.findUser(userID);
	}
	@Override
	public void insert(User user) {
		userDAO.insert(user);
	}

}
