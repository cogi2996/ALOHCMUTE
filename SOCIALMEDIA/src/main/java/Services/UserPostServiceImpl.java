package Services;

import java.util.List;

import Dao.IUserPostDao;
import Dao.UserPostDaoImpl;
import Entity.UserPost;

public class UserPostServiceImpl implements IUserPostService {
	IUserPostDao userPostDao = new UserPostDaoImpl();
	@Override
	public List<UserPost> paginationPage(int index, int numberOfPage) {
		return userPostDao.paginationPage(index, numberOfPage);
	}

}
