package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.UserPost;
import JpaConfig.JPAConfig;

public class UserPostDaoImpl implements IUserPostDao {

	public static void main(String[] args) {
		//System.out.println(new UserPostDaoImpl().paginationPage(0,2));
		System.out.println(new UserPostDaoImpl().getAllPostsOfUser(1));
	}
	@Override
	public List<UserPost> paginationPage(int index, int numberOfPage) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<UserPost> query = entityManager.createNamedQuery("UserPost.findAll", UserPost.class);
		query.setFirstResult(index);
		query.setMaxResults(numberOfPage);
		return query.getResultList();
	}
	public List<UserPost> getAllPostsOfUser(int userId) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpql = "select uP from UserPost uP where uP.user.userID = " + String.valueOf(userId);
		TypedQuery<UserPost> query = entityManager.createQuery(jpql, UserPost.class);
		return query.getResultList();
	}

}
