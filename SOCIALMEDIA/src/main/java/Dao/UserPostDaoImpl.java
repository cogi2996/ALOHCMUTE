package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.User;
import Entity.UserPost;
import JpaConfig.JPAConfig;

public class UserPostDaoImpl implements IUserPostDao {

	public static void main(String[] args) {
//		System.out.println(new UserPostDaoImpl().paginationPage(12, 6));
//		List<UserPost> list = new UserPostDaoImpl().paginationPostProfile(0, 6, "6SsHvCz90kNaaUoZWDQUdsu84o02");
//		System.out.println(list.size());
//		for (UserPost p : list) {
//			System.out.println(p);
//		}
		new UserPostDaoImpl().insertLikePost("mxFasgmO8bSvQtpiHqNUG9WrEai1", 43, new Date(0));
//		new UserPostDaoImpl().


	}

	@Override
	public List<UserPost> paginationPage(int index, int numberOfPage) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<UserPost> query = entityManager.createNamedQuery("UserPost.findAll", UserPost.class);
		query.setFirstResult(index*numberOfPage); //them *numberOfPage
		query.setMaxResults(numberOfPage);
		return query.getResultList();
	}
	//hieu-begin
	@Override
	public void update(UserPost userPost) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(userPost);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		}finally {
			enma.close();
		}
	}
	@Override
	public void delete(int userPostID){
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			UserPost userPost = enma.find(UserPost.class, userPostID);
			if(userPost != null) {
				enma.remove(userPost);
			}
			else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally {
			enma.close();
		}
	}
	@Override
	public Long countAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Long> count = enma.createQuery("select count(p) from UserPost p", Long.class);
		return count.getSingleResult();
	}
	//hieu-end
	
	@Override
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid) {
		EntityManager entityManager = JPAConfig.getEntityManager();
//		String jpqlQuery = "SELECT up FROM User u " + "JOIN u.followingUsers fu " + "JOIN fu.userPosts up "
//				+ "WHERE u.userID = :userId " + "ORDER BY up.UserPostCreateTime DESC";
		String jpqlQuery = "SELECT up FROM User u " + "JOIN u.followingUsers fu " + "JOIN fu.userPosts up "
				+ "WHERE u.userID = :userId " + "ORDER BY up.UserPostCreateTime";
		List<UserPost> userFollowedPosts = entityManager.createQuery(jpqlQuery, UserPost.class)
				.setParameter("userId", uid).setFirstResult(index).setMaxResults(numberOfPage) 
				.getResultList();

		return userFollowedPosts;
	}

	@Override
	public List<UserPost> paginationPostProfile(int index, int numberOfPage, String uid) {
		EntityManager entityManager = JPAConfig.getEntityManager();
//		String jpqlQuery = "SELECT up FROM User u " + "JOIN u.followingUsers fu " + "JOIN fu.userPosts up "
//				+ "WHERE u.userID = :userId " + "ORDER BY up.UserPostCreateTime DESC";
		List<UserPost> list = entityManager.createQuery("SELECT uP FROM UserPost uP WHERE uP.user.userID = :uid",UserPost.class)
				.setParameter("uid", uid).setFirstResult(index).setMaxResults(numberOfPage) 
				.getResultList();
		return list;
	}
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void insertLikePost(String userID, int userPostID, Date likeTime){
		  String sql = "INSERT INTO LikeUserPost (userID, userPostID, likeTime) VALUES (?, ?, ?)";
		  try {
		      conn = new DBConnection().getConnection();
		        ps = conn.prepareStatement(sql);
		        ps.setString(1, userID);
		        ps.setInt(2, userPostID);
		        ps.setDate(3, likeTime);
		        ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
