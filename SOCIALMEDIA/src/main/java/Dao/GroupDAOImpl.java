package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.Group;
import Entity.User;
import JpaConfig.JPAConfig;

public class GroupDAOImpl implements iGroupDAO{
	//iGroupDAO groupDao = new GroupDAOImpl();
	@Override
	public List<Group> findAllGroup() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Group> query = enma.createNamedQuery("Group.findAll", Group.class);
		// trả về ds
		return query.getResultList();
	}

	public static void main(String[] args) {
		/*
		IUserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findUser("2");
		System.out.println(user);
		
		iGroupDAO pro = new GroupDAOImpl();
		Group list = pro.findGroup(2);
		//List<MyGroup> list = pro.findAll();
		System.out.println(list);*/
		// List<MyGroup> list = pro.findGroupsByUserId(2);
				// List<MyGroup> list = pro.findAll();
				// User user = new UserServiceImpl().findUser("user1");
				//List<User> user = pro.searchUsersByKeyword("John a doe");
				// Long user = pro.countSearchUsers("John");
				// System.out.println(list.getFollowers());
				// System.out.println(user.getFollowingUsers());
		iGroupDAO pro = new GroupDAOImpl();
		//List<Group> user = pro.paginationPageSearchGroups(0, 2, "Group");
		//List<User> user = pro.paginationPageListUsersGroup(0,5,1);
		//Long sl = pro.CountListUsersGroup(5);
		//List<Group> user = pro.paginationPageSearchGroups(0,5,"Group");
		//List<User> user = pro.paginationPageSearchUsersGroup(0,5,1,"a");
		Long sl = pro.CountSearchUsersGroup(1,"a");
		List<Group> user = pro.searchGroupbygroupName("học");
		//Long sl = pro.countSearchUsers("Group");
		System.out.println(user);
		System.out.println(sl);
	}

	@Override
	public void insertGroup(Group group) {
		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(group);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public Group findGroup(int groupID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Group> query = entityManager.createQuery("SELECT g FROM Group g WHERE g.groupID = :groupID", Group.class);
        query.setParameter("groupID", groupID);
        
        return query.getSingleResult();
	}

	@Override
	public void updateGroup(Group group) {
		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(group);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void deleteGroup(int groupID) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Group group = enma.find(Group.class, groupID);
			if (group != null) {
				enma.remove(group);
			} else {
				throw new Exception("Not found");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}
	}

	@Override
	public List<Group> searchGroupbygroupName(String groupName) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Group> query = entityManager.createQuery(
				"SELECT g FROM Group g WHERE g.groupName LIKE :groupName ",
				Group.class);
		query.setParameter("groupName", "%" + groupName + "%");
		List<Group> groups = query.getResultList();
		entityManager.close();
		return groups;
	}

	@Override
	public List<Group> paginationPageSearchGroups(int index, int numberOfPage, String groupName) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Group> list = entityManager.createQuery(
				"SELECT g FROM Group g WHERE g.groupName LIKE :groupName ",
				Group.class);
		    
		list.setParameter("groupName", "%" + groupName + "%");
		list.setFirstResult(index * numberOfPage);
		list.setMaxResults(numberOfPage);
		List<Group> groups = list.getResultList();
		entityManager.close();
		return groups;
	}

	@Override
	public Long countSearchGroups(String groupName) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<Long> query = entityManager.createQuery( "SELECT COUNT(g) FROM Group g WHERE g.groupName LIKE :groupName",
	            Long.class);
		query.setParameter("groupName", "%" + groupName + "%");

		Long count = query.getSingleResult();
		entityManager.close();

		return count;
	}

	@Override
	public List<User> paginationPageListUsersGroup(int index, int numberOfPage, int groupID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u JOIN u.UserGroups g WHERE g.groupID = :groupID";
		TypedQuery<User> list = entityManager.createQuery(jpql, User.class);
		list.setParameter("groupID", groupID);
		list.setFirstResult(index * numberOfPage);
		list.setMaxResults(numberOfPage);
		List<User> users = list.getResultList();
		System.out.println(users);
		entityManager.close();
		return users;
	}

	@Override
	public Long CountListUsersGroup(int groupID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpql = "SELECT COUNT(u) FROM User u JOIN u.UserGroups g WHERE g.groupID = :groupID";
		TypedQuery<Long> query = entityManager.createQuery( jpql,Long.class);
		query.setParameter("groupID",groupID);

		Long count = query.getSingleResult();
		entityManager.close();

		return count;
	}

	@Override
	public List<User> paginationPageSearchUsersGroup(int index, int numberOfPage, int groupID, String keyword) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpql = "SELECT u FROM User u JOIN u.UserGroups g WHERE (g.groupID = :groupID) and ((LOWER(CONCAT(u.firstName, ' ', u.midName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword))";
		TypedQuery<User> list = entityManager.createQuery(jpql, User.class);
		list.setParameter("groupID", groupID);
		list.setParameter("keyword", "%" + keyword + "%");
		list.setFirstResult(index * numberOfPage);
		list.setMaxResults(numberOfPage);
		List<User> users = list.getResultList();
		System.out.println(users);
		entityManager.close();
		return users;
	}

	@Override
	public Long CountSearchUsersGroup(int groupID, String keyword) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpql = "SELECT COUNT(u) FROM User u JOIN u.UserGroups g WHERE (g.groupID = :groupID) and ((LOWER(CONCAT(u.firstName, ' ', u.midName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword))";
		TypedQuery<Long> query = entityManager.createQuery( jpql,Long.class);
		query.setParameter("groupID",groupID);
		query.setParameter("keyword", "%" + keyword + "%");
		Long count = query.getSingleResult();
		entityManager.close();

		return count;
	}
	
	//hieu-them
	@Override
	public List<Group> paginationPage(int index, int numberOfPage) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Group> list  = enma.createQuery("select b from Group b",Group.class);
		list.setFirstResult(index*numberOfPage);
		list.setMaxResults(numberOfPage);
		return list.getResultList();
	}
	@Override
	public Long countAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Long> count = enma.createQuery("select count(u) from Group u", Long.class);
		return count.getSingleResult();
	}
	//hieu-end
}
