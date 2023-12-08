package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import Entity.UserPost;
import JpaConfig.JPAConfig;

public class UserPostDaoImpl implements IUserPostDao {

	public static void main(String[] args) {
//		System.out.println(new UserPostDaoImpl().paginationPage(12, 6));
		List<UserPost> list = new UserPostDaoImpl().paginationPostUser(1, 4, "mxFasgmO8bSvQtpiHqNUG9WrEai1");
		System.out.println(list.size());
		for (UserPost p : list) {
			System.out.println(p);
		}

	}

	@Override
	public List<UserPost> paginationPage(int index, int numberOfPage) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<UserPost> query = entityManager.createNamedQuery("UserPost.findAll", UserPost.class);
		query.setFirstResult(index);
		query.setMaxResults(numberOfPage);
		return query.getResultList();
	}

	@Override
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String jpqlQuery = "SELECT up FROM User u " + "JOIN u.followingUsers fu " + "JOIN fu.userPosts up "
				+ "WHERE u.userID = :userId " + "ORDER BY up.UserPostCreateTime DESC";
//		String jpqlQuery = "SELECT DISTINCT up FROM User u " + "LEFT JOIN u.followingUsers fu "
//				+ "LEFT JOIN u.userPosts up " + "LEFT JOIN fu.userPosts followedPosts "
//				+ "WHERE u.userID = :userId OR fu.userID = :userId "
//				+ "ORDER BY COALESCE(up.UserPostCreateTime, followedPosts.UserPostCreateTime) DESC";
		List<UserPost> userFollowedPosts = entityManager.createQuery(jpqlQuery, UserPost.class)
				.setParameter("userId", uid).setFirstResult(index).setMaxResults(numberOfPage) 
				.getResultList();

		return userFollowedPosts;
	}
//	String jpqlQuery = "SELECT DISTINCT up FROM User u " +
//            "LEFT JOIN u.followingUsers fu " +
//            "LEFT JOIN u.userPosts up " +
//            "LEFT JOIN fu.userPosts followedPosts " +
//            "WHERE u.userID = :userId OR fu.userID = :userId " +
//            "ORDER BY COALESCE(up.UserPostCreateTime, followedPosts.UserPostCreateTime) DESC";
//
//List<UserPost> userFollowedPosts = entityManager.createQuery(jpqlQuery, UserPost.class)
// .setParameter("userId", userId)
// .getResultList();

}
