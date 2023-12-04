package Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Dao.IUserPostDao;
import Dao.UserPostDaoImpl;
import Entity.UserPost;
import JpaConfig.JPAConfig;
import Model.UserPostModel;

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
	//hieu-begin
		
	@Override
	public void update(UserPost userPost) {
		userPostDao.update(userPost);
	}

	@Override
	public void delete(int userPostID) {
		userPostDao.delete(userPostID);
	}
	//hieu-end
}
