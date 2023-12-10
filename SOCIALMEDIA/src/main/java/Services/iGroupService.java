package Services;

import java.util.List;

import Entity.Group;
import Entity.User;
import Entity.UserPost;

public interface iGroupService {
	List<Group> findAllGroup();
	void insertGroup(Group group);
	void updateGroup(Group group);
	void deleteGroup(int groupID);
	Group findGroup(int groupID);
	// tin begin
	List<User> paginationPageListUsersGroup(int index, int numberOfPage,int groupID);
	Long CountListUsersGroup(int groupID);
	List<User> paginationPageSearchUsersGroup(int index, int numberOfPage,int groupID, String keyword);
	Long CountSearchUsersGroup(int groupID, String keyword);
	List<Group> searchGroupbygroupName(String groupName);
	List<Group> paginationPageSearchGroups(int index, int numberOfPage,String groupName);
	Long countSearchGroups(String groupName);
	// tin end
	// tin begin
	List<Group> paginationPageAllGroup(int index, int numberOfPage);
	Long countAllGroup();
	// tin end
	
	//hieu-them
	List<Group> paginationPage(int index, int numberOfPage);
	Long countAll();
	//hieu-end
}
