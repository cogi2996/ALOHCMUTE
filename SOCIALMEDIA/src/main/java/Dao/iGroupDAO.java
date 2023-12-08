package Dao;

import java.util.List;

import Entity.Group;

public interface iGroupDAO {
	List<Group> findAllGroup();
	void insertGroup(Group group);
	void updateGroup(Group group);
	void deleteGroup(int groupID);
	Group findGroup(int groupID);
}
