package Services;

import java.util.List;

import Dao.GroupPostImpl;
import Dao.IGroupPostDao;
import Entity.GroupPost;

public class GroupPostServiceImpl implements IGroupPostService {
	IGroupPostDao groupPostDao = new GroupPostImpl();
	@Override
	public List<GroupPost> searchgroupPostText(String keyword) {
		// TODO Auto-generated method stub
		return groupPostDao.searchgroupPostText(keyword);
	}

}
