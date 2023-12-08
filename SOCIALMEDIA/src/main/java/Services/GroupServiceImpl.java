package Services;

import java.util.List;

import Dao.GroupDAOImpl;
import Dao.iGroupDAO;
import Entity.Group;

public class GroupServiceImpl implements iGroupService{

	iGroupDAO groupDAO = new GroupDAOImpl();

	@Override
	public List<Group> findAllGroup() {
		return groupDAO.findAllGroup();
	}

	@Override
	public void insertGroup(Group group) {
		groupDAO.insertGroup(group);
	}

	@Override
	public Group findGroup(int groupID) {
		return groupDAO.findGroup(groupID);
	}

	@Override
	public void updateGroup(Group group) {
		groupDAO.updateGroup(group);
	}

	@Override
	public void deleteGroup(int groupID) {
		groupDAO.deleteGroup(groupID);
		
	}

}
