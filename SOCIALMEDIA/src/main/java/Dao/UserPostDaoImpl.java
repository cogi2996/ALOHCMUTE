package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.UserPost;
import JpaConfig.JPAConfig;

public class UserPostDaoImpl implements IUserPostDao {

	public static void main(String[] args) {
		//System.out.println(new UserPostDaoImpl().paginationPage(12,6));
		System.out.println(new UserPostDaoImpl().likeUserPost(2));
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
	public UserPost likeUserPost(int userPostID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		UserPost userPost = entityManager.find(UserPost.class, userPostID);
		System.out.println(userPost);
		if (userPost != null) {
			userPost.setLikes(userPost.getLikes() + 1);
			EntityTransaction transaction = entityManager.getTransaction();
			try {
				transaction.begin();
				entityManager.merge(userPost);// merge là update
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
				throw e;
			} finally {
				entityManager.close();
			}
		}
		return userPost;
	}
	
}
