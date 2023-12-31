package Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Follow;
import Entity.User;
import JpaConfig.JPAConfig;

public class FollowDAOImpl implements IFollowDAO {

	public static void main(String[] args) {
//		try {
//			Follow newFollow = new Follow("mxFasgmO8bSvQtpiHqNUG9WrEai1", "4Mp0hZK1s7WcnTq462EInqBYCbC2", new Date());
//			System.out.println(newFollow);
//			new FollowDAOImpl().insert(newFollow);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		List<User> list =  new FollowDAOImpl().suggestFollow("6SsHvCz90kNaaUoZWDQUdsu84o02");
//		for(User u : list) {
//			System.out.println(u);
//		}
	}

	@Override
	public void insert(Follow follow) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(follow);
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
	public List<User> suggestFollow(String uid) {
		// load ra những người user chưa từng follow
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.userID != :userID AND :userID NOT MEMBER OF u.followers",
				User.class);
		query.setParameter("userID", uid).setMaxResults(5);
		return query.getResultList();
	}

	@Override
	public void delete(String sourceID, String targetID) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Query deleteFollowQuery = enma.createQuery("DELETE FROM Follow f WHERE f.sourceID = :sourceID AND f.targetID = :targetID");
	        deleteFollowQuery.setParameter("sourceID", sourceID);
	        deleteFollowQuery.setParameter("targetID", targetID);
	        deleteFollowQuery.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			//throw e;
		} finally {
			enma.close();
		}
	}

}
