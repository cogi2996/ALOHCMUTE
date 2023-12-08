package Dao;

import java.util.List;

import Entity.Group;
import Entity.User;

public interface iGroupDAO {
	List<Group> findAllGroup();
	void insertGroup(Group group);
	void updateGroup(Group group);
	void deleteGroup(int groupID);
	Group findGroup(int groupID);
	List<Group> searchGroupbygroupName(String groupName);
	List<Group> paginationPageSearchGroups(int index, int numberOfPage,String groupName);
	Long countSearchUsers(String groupName);
	// tin begin
	List<User> paginationPageListUsersGroup(int index, int numberOfPage,int groupID);
	Long CountListUsersGroup(int groupID);
	// tin end
}
