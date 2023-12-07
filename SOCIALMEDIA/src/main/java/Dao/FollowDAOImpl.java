package Dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entity.Follow;
import JpaConfig.JPAConfig;

public class FollowDAOImpl implements IFollowDAO {

	public static void main(String[] args) {
//		try {
//			Follow newFollow = new Follow("mxFasgmO8bSvQtpiHqNUG9WrEai1", "6SsHvCz90kNaaUoZWDQUdsu84o02", new Date());
//			System.out.println(newFollow);
//			new FollowDAOImpl().insert(newFollow);
//		} catch (Exception e) {
//			// TODO: handle exception
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

}
