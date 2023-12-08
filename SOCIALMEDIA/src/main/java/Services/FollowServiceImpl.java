package Services;

import java.util.List;

import Dao.FollowDAOImpl;
import Dao.IFollowDAO;
import Entity.Follow;
import Entity.User;

public class FollowServiceImpl implements IFollowService {
	IFollowDAO followDao = new FollowDAOImpl();
	@Override
	public void insert(Follow follow) {
		this.followDao.insert(follow);
	}
	@Override
	public List<User> suggestFollow(String uid) {
		return followDao.suggestFollow(uid);
	}

}
