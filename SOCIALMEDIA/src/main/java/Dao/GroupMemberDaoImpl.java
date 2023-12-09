package Dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entity.GroupMember;
import JpaConfig.JPAConfig;

public class GroupMemberDaoImpl implements IGroupMemberDao{

	@Override
	public void insert(GroupMember groupMember) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(groupMember);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		
	}
	public static void main(String[] args) {
		IGroupMemberDao gm = new GroupMemberDaoImpl();
		// List<MyGroup> list = pro.findGroupsByUserId(2);
		// List<MyGroup> list = pro.findAll();
		// User user = new UserServiceImpl().findUser("user1");
		//List<User> user = pro.searchUsersByKeyword("John a doe");
		// Long user = pro.countSearchUsers("John");
		// System.out.println(list.getFollowers());
		// System.out.println(user.getFollowingUsers());
		//List<User> user = pro.paginationPageSearchUsers(0, 2, "Joh");
		//System.out.println(user);
	}

}
