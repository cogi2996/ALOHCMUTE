package Services;


import java.util.List;

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
	@Override
	public void update(User user) {
		userDAO.update(user);		
	}
	@Override
	public List<User> searchUsersByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return userDAO.searchUsersByKeyword(keyword);
	}
	@Override
	public void delete(String userID) {
		userDAO.delete(userID);
	}
	//hieu them
	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}
	@Override
	public Long countAll() {
		return userDAO.countAll();
	}
	@Override
	public List<User> paginationPage(int index, int numberOfPage) {
		return userDAO.paginationPage(index, numberOfPage);
	}
	@Override
	public List<User> paginationPageSearchUsers(int index, int numberOfPage, String keyword) {
		return userDAO.paginationPageSearchUsers(index, numberOfPage, keyword);
	}
	@Override
	public Long countSearchUsers(String keyword) {
		return userDAO.countSearchUsers(keyword);
	}
}
