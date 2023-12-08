package Services;

import java.util.List;

import Entity.Group;

public interface iGroupService {
	List<Group> findAllGroup();
	void insertGroup(Group group);
	void updateGroup(Group group);
	void deleteGroup(int groupID);
	Group findGroup(int groupID);
}
