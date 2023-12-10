package Services;

import java.util.List;

import Dao.GroupDAOImpl;
import Dao.iGroupDAO;
import Entity.Group;
import Entity.User;
import Entity.UserPost;

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

	@Override
	public List<User> paginationPageListUsersGroup(int index, int numberOfPage, int groupID) {
		return groupDAO.paginationPageListUsersGroup(index, numberOfPage, groupID);
	}

	@Override
	public Long CountListUsersGroup(int groupID) {
		return groupDAO.CountListUsersGroup(groupID);
	}

	@Override
	public List<User> paginationPageSearchUsersGroup(int index, int numberOfPage, int groupID, String keyword) {
		return groupDAO.paginationPageSearchUsersGroup(index, numberOfPage, groupID, keyword);
	}

	@Override
	public Long CountSearchUsersGroup(int groupID, String keyword) {
		return groupDAO.CountSearchUsersGroup(groupID, keyword);
	}

	@Override
	public List<Group> searchGroupbygroupName(String groupName) {
		return groupDAO.searchGroupbygroupName(groupName);
	}

	@Override
	public List<Group> paginationPageSearchGroups(int index, int numberOfPage, String groupName) {
		return groupDAO.paginationPageSearchGroups(index, numberOfPage, groupName);
	}

	@Override
	public Long countSearchGroups(String groupName) {
		return groupDAO.countSearchGroups(groupName);
	}

	@Override
	public List<Group> paginationPageAllGroup(int index, int numberOfPage) {
		return groupDAO.paginationPageAllGroup(index, numberOfPage);
	}

	@Override
	public Long countAllGroup() {
		return groupDAO.countAllGroup();
	}

	
	
}
