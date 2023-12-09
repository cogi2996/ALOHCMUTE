package Services;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
	public List<UserPost> paginationPostUser(int index, int numberOfPage, String uid) {
		return userPostDao.paginationPostUser(index, numberOfPage, uid);
	}

	@Override
	public void delete(int userPostID) {
		userPostDao.delete(userPostID);
	}
	public Long countAll() {
		return userPostDao.countAll();
	}
	//hieu-end
	
	@Override
	public List<UserPost> paginationPageSearchUserPost(int index, int numberOfPage, String keyword) {
		return userPostDao.paginationPageSearchUserPost(index, numberOfPage, keyword);
	}

	@Override
	public Long countSearchUserPost(String keyword) {
		return userPostDao.countSearchUserPost(keyword);
	}


	@Override
	public List<UserPost> paginationPostProfile(int index, int numberOfPage, String uid) {
		return userPostDao.paginationPostProfile(index,numberOfPage,uid);
	}

	@Override
	public void insertLikePost(String userID, int userPostID, Date likeTime) {
		userPostDao.insertLikePost(userID, userPostID, likeTime);
	}

	@Override
	public UserPost findOne(int userPostID) {
		return userPostDao.findOne(userPostID);
	}
}
