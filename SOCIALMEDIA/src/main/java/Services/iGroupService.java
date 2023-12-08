package Services;

import java.util.List;

import Entity.Group;
import Entity.User;

public interface iGroupService {
	List<Group> findAllGroup();
	void insertGroup(Group group);
	void updateGroup(Group group);
	void deleteGroup(int groupID);
	Group findGroup(int groupID);
	// tin begin
	List<User> paginationPageListUsersGroup(int index, int numberOfPage,int groupID);
	Long CountListUsersGroup(int groupID);
	// tin end
}
