package Dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.LikeUserPost;
import Entity.User;
import JpaConfig.JPAConfig;

public class UserDAOImpl implements IUserDAO {
	@Override
	public User findUser(String userID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.userID = :userID", User.class);
		query.setParameter("userID", userID);
		System.out.println(userID);
		return query.getSingleResult();
	}

	@Override
	public void insert(User user) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void update(User user) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(user);// merge là update
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		} finally {
			entityManager.close();
		}

	}

	@Override
	public List<User> searchUsersByKeyword(String keyword) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword",
				User.class);
		query.setParameter("keyword", "%" + keyword + "%");

		List<User> users = query.getResultList();
		entityManager.close();

		return users;
	}

	public static void main(String[] args) {
		IUserDAO pro = new UserDAOImpl();
		// List<MyGroup> list = pro.findGroupsByUserId(2);
		// List<MyGroup> list = pro.findAll();
		// User user = new UserServiceImpl().findUser("user1");
		List<User> user = pro.searchUsersByKeyword("John");
		// System.out.println(list.getFollowers());
		// System.out.println(user.getFollowingUsers());
		System.out.println(user);
	}

	@Override
	public void delete(String userID) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User user = enma.find(User.class, userID);
			if (user != null) {
				Query deleteFollowQuery = enma.createQuery("DELETE FROM Follow f WHERE f.sourceID = :userID OR f.targetID = :userID");
		        deleteFollowQuery.setParameter("userID", userID);
		        deleteFollowQuery.executeUpdate();

		        enma.remove(user);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			//throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public List<User> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	//hieu them
	@Override
	public Long countAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Long> count = enma.createQuery("select count(u) from User u", Long.class);
		return count.getSingleResult();
	}

	@Override
	public List<User> paginationPage(int index, int numberOfPage) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> list  = enma.createQuery("select b from User b",User.class);
		list.setFirstResult(index*numberOfPage);
		list.setMaxResults(numberOfPage);
		return list.getResultList();
	}
	@Override
	public List<User> SortUserByName(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getFirstName));
		return list;
	}

	@Override
	public List<User> SortUserByWorkplace(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getWorkPlace));
		return list;
	}
	//hieu end

}
