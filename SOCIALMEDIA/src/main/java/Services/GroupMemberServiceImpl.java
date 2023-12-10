package Services;

import Dao.GroupMemberDaoImpl;
import Dao.IGroupMemberDao;
import Entity.GroupMember;

public class GroupMemberServiceImpl implements IGroupMemberService{
	//IGroupMemberService groupDAO = new GroupMemberServiceImpl();
	IGroupMemberDao groupMemberDao = new GroupMemberDaoImpl();
	@Override
	public void insert(GroupMember groupMember) {
		groupMemberDao.insert(groupMember);
	}
	
}
