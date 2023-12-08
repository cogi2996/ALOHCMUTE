package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.Group;
import Entity.User;
import JpaConfig.JPAConfig;

public class GroupDAOImpl implements iGroupDAO{
	
	@Override
	public List<Group> findAllGroup() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Group> query = enma.createNamedQuery("Group.findAll", Group.class);
		// trả về ds
		return query.getResultList();
	}

	public static void main(String[] args) {
		IUserDAO userDAO = new UserDAOImpl();
		User user = userDAO.findUser("2");
		System.out.println(user);
		
		iGroupDAO pro = new GroupDAOImpl();
		Group list = pro.findGroup(2);
		//List<MyGroup> list = pro.findAll();
		System.out.println(list);
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
}
