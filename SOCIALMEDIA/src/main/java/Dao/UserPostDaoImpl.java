package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.UserPost;
import JpaConfig.JPAConfig;
import Model.UserPostModel;

public class UserPostDaoImpl implements IUserPostDao {

	public static void main(String[] args) {
		System.out.println(new UserPostDaoImpl().paginationPage(12,6));
	}
	@Override
	public List<UserPost> paginationPage(int index, int numberOfPage) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<UserPost> query = entityManager.createNamedQuery("UserPost.findAll", UserPost.class);
		query.setFirstResult(index);
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
	//hieu-end
}
