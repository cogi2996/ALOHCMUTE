package Services;

import Dao.FollowDAOImpl;
import Dao.IFollowDAO;
import Entity.Follow;

public class FollowServiceImpl implements IFollowService {
	IFollowDAO followDao = new FollowDAOImpl();
	@Override
	public void insert(Follow follow) {
		this.followDao.insert(follow);
	}

}
