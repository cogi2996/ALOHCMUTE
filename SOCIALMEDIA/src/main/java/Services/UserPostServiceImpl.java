package Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Dao.IUserPostDao;
import Dao.UserPostDaoImpl;
import Entity.UserPost;
import JpaConfig.JPAConfig;

public class UserPostServiceImpl implements IUserPostService {
	IUserPostDao userPostDao = new UserPostDaoImpl();

	@Override
	public List<UserPost> paginationPage(int index, int numberOfPage) {
		return userPostDao.paginationPage(index, numberOfPage);
	}

	@Override
	public void insert(UserPost userPost) {
		// TODO Auto-generated method stub
		EntityManager entityManager = JPAConfig.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(userPost);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public UserPost likeUserPost(int userPostID) {
		return userPostDao.likeUserPost(userPostID);
	}
	
}
