package Dao;


import java.util.List;

import com.google.firebase.auth.FirebaseAuthException;

import Entity.User;

public interface IUserDAO {
	User findUser(String userID);
	void insert(User user);
	void update(User user);
	void delete(String userID); //hieu them
	List<User> findAll();//hieu them
	List<User> searchUsersByKeyword(String keyword);
	List<User> paginationPageSearchUsers(int index, int numberOfPage,String keyword);
	Long countSearchUsers(String keyword);
	Long countAll();//hieu them
	List<User> paginationPage(int index, int numberOfPage);//hieu them
	List<User> SortUserByName(List<User> list);
	List<User> SortUserByWorkplace(List<User> list);//hieu end
	User findUserByEmail(String email) throws FirebaseAuthException;
	
}
