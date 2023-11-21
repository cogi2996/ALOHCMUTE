package Dao;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import JpaConfig.JPAConfig;

public class UserDAOImpl implements IUserDAO{
	@Override
	public User findUser(int userID) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.userID = :userID", User.class);
        query.setParameter("userID", userID);
        
        return query.getSingleResult();
	}
	@Override
	public List<User> SortUserByCreateDate(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getCreateDate));
		return list;	
		}
}
