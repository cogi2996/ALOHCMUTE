package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.User;
import JpaConfig.JPAConfig;

public class UserDAOImpl implements IUserDAO {
	@Override
	public User findUser(String userID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.userID = :userID", User.class);
		query.setParameter("userID", userID);

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
	/*
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
	}*/
	/*
	@Override
	public List<User> searchUsersByKeyword(String keyword) {
	    EntityManager entityManager = JPAConfig.getEntityManager();

	    // Tạo câu truy vấn JPQL với LIKE và AND
	    TypedQuery<User> query = entityManager.createQuery(
	        "SELECT u FROM User u WHERE " +
	        "LOWER(u.firstName) LIKE LOWER(:firstName) AND " +
	        "LOWER(u.midName) LIKE LOWER(:midName) AND " +
	        "LOWER(u.lastName) LIKE LOWER(:lastName)",
	        User.class
	    );

	    // Xử lý keyword
	    String[] nameParts = keyword.split("\\s+");
	    
	    // Đặt tham số cho mỗi phần của tên
	    query.setParameter("firstName", "%" + nameParts[0] + "%");

	    if (nameParts.length > 1) {
	        // Gộp các phần còn lại thành midName
	        query.setParameter("midName", "%" + String.join(" ", Arrays.copyOfRange(nameParts, 1, nameParts.length)) + "%");
	    } else {
	        query.setParameter("midName", "%%");
	    }

	    // Kiểm tra xem có phần lastName trong keyword hay không
	    if (nameParts.length > 1) {
	        query.setParameter("lastName", "%" + nameParts[nameParts.length - 1] + "%");
	    } else {
	        query.setParameter("lastName", "%%");
	    }

	    List<User> users = query.getResultList();
	    entityManager.close();

	    return users;
	}*/
	/*
	@Override
	public List<User> searchUsersByKeyword(String keyword) {
	    EntityManager entityManager = JPAConfig.getEntityManager();

	    // Xử lý keyword và loại bỏ khoảng trắng dư thừa
	    String cleanedKeyword = keyword.replaceAll("\\s+", " ").trim();

	    // Tạo câu truy vấn JPQL với LIKE và AND
	    TypedQuery<User> query = entityManager.createQuery(
	        "SELECT u FROM User u WHERE " +
	        "LOWER(u.firstName) LIKE LOWER(:firstName) AND " +
	        "LOWER(u.midName) LIKE LOWER(:midName) AND " +
	        "LOWER(u.lastName) LIKE LOWER(:lastName)",
	        User.class
	    );

	    // Đặt tham số cho mỗi phần của tên
	    String[] nameParts = cleanedKeyword.split("\\s+");
	    query.setParameter("firstName", "%" + nameParts[0] + "%");

	    if (nameParts.length > 1) {
	        // Gộp các phần còn lại thành midName
	        query.setParameter("midName", "%" + String.join(" ", Arrays.copyOfRange(nameParts, 1, nameParts.length)) + "%");
	    } else {
	        query.setParameter("midName", "%%");
	    }

	    // Kiểm tra xem có phần lastName trong keyword hay không
	    if (nameParts.length > 1) {
	        query.setParameter("lastName", "%" + nameParts[nameParts.length - 1] + "%");
	    } else {
	        query.setParameter("lastName", "%%");
	    }

	    List<User> users = query.getResultList();
	    entityManager.close();

	    return users;
	}*/
	@Override
	public List<User> searchUsersByKeyword(String keyword) {
	    EntityManager entityManager = JPAConfig.getEntityManager();
	    /*
	    TypedQuery<User> query = entityManager.createQuery( "SELECT u FROM User u WHERE LOWER(CONCAT(u.firstName, ' ', u.midName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%'))",
	            User.class);*/
	    TypedQuery<User> query = entityManager.createQuery( "SELECT u FROM User u WHERE (LOWER(CONCAT(u.firstName, ' ', u.midName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword)",
	            User.class);
	    query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");

	    List<User> users = query.getResultList();
	    entityManager.close();

	    return users;
	}


	@Override
	public List<User> paginationPageSearchUsers(int index, int numberOfPage, String keyword) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		/*
		TypedQuery<User> list = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword",User.class);*/
		 TypedQuery<User> list = entityManager.createQuery( "SELECT u FROM User u WHERE (LOWER(CONCAT(u.firstName, ' ', u.midName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword)",
		            User.class);
		    
		list.setParameter("keyword", "%" + keyword + "%");
		list.setFirstResult(index * numberOfPage);
		list.setMaxResults(numberOfPage);
		List<User> users = list.getResultList();
		entityManager.close();
		return users;
	}
	@Override
	public Long countSearchUsers(String keyword) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		/*TypedQuery<Long> query = entityManager.createQuery(
				
				"SELECT COUNT(u) FROM User u WHERE u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword",
				Long.class);*/
		TypedQuery<Long> query = entityManager.createQuery( "SELECT COUNT(u) FROM User u WHERE (LOWER(CONCAT(u.firstName, ' ', u.midName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :keyword, '%')) OR u.firstName LIKE :keyword OR u.lastName LIKE :keyword OR u.midName LIKE :keyword)",
	            Long.class);
		query.setParameter("keyword", "%" + keyword + "%");

		Long count = query.getSingleResult();
		entityManager.close();

		return count;
	}

	public static void main(String[] args) {
		IUserDAO pro = new UserDAOImpl();
		// List<MyGroup> list = pro.findGroupsByUserId(2);
		// List<MyGroup> list = pro.findAll();
		// User user = new UserServiceImpl().findUser("user1");
		//List<User> user = pro.searchUsersByKeyword("John a doe");
		// Long user = pro.countSearchUsers("John");
		// System.out.println(list.getFollowers());
		// System.out.println(user.getFollowingUsers());
		List<User> user = pro.paginationPageSearchUsers(0, 2, "Joh");
		System.out.println(user);
	}
}
