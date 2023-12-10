package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entity.GroupMember;
import JpaConfig.JPAConfig;

public class GroupMemberDaoImpl implements IGroupMemberDao {

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

}
