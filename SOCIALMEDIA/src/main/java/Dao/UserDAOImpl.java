package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import JpaConfig.JPAConfig;

public class UserDAOImpl implements IUserDAO{
	@Override
	public List<User> findFollowersByUserId(int userId) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		// Tạo truy vấn JPA
	    TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u INNER JOIN Follow f "
	    		+ "											ON u.userID = f.sourceID WHERE f.targetID = userId", User.class);

	    // Thiết lập tham số cho truy vấn
	    query.setParameter("userId", userId);

	    // Thực hiện truy vấn và trả về kết quả
	    List<User> followers = query.getSingleResult().getFollowers();

		entityManager.close(); // Đảm bảo đóng EntityManager sau khi sử dụng
		return followers;
	}
}
