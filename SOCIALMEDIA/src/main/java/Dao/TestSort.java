package Dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;
import Entity.UserPost;
import JpaConfig.JPAConfig;

public class TestSort {
	public static void main(String[] args) {
		try {
			System.out.println("Initial");
			List<User> user = new TestSort().findAll();
			for (User u : user) {
				System.out.println(u);
			}
			System.out.println("Sorted Name:");
			List<User> usersortname = new TestSort().SortUserByName(user);
			for (User u : usersortname) {
				System.out.println(u);
			}
			
			System.out.println("Sorted WorkPlace:");
			List<User> usersortworkplace = new TestSort().SortUserByWorkplace(user);
			for (User u : usersortworkplace) {
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
	
	public List<User> SortUserByName(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getFirstName));
		return list;
	}

	public List<User> SortUserByWorkplace(List<User> list) {
		Collections.sort(list, Comparator.comparing(User::getWorkPlace));
		return list;
	}
}
