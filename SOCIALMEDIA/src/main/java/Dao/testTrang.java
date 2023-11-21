package Dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import JpaConfig.JPAConfig;


public class testTrang {
	public static void main(String[] args) {
		try {
			System.out.println("Initial");
			List<User> user = new testTrang().findAll();
			for (User u : user) {
				System.out.println(u);
			}
			System.out.println("Sorted create date:");
			List<User> usersort = new testTrang().SortUserByCreateDate(user);
			for (User u : usersort) {
				System.out.println(u);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> findAll() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		TypedQuery<User> query = entityManager.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	
	public List<User> SortUserByCreateDate(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getCreateDate));
		return list;	
		}

}
