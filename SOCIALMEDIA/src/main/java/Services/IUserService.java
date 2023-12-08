package Services;


import java.util.List;

import Entity.User;

public interface IUserService {
	User findUser(String userID);
	void insert(User user) ;
	void update(User user);
	void delete(String userID); //hieu them
	List<User> findAll(); //hieu them
	List<User> searchUsersByKeyword(String keyword);
	Long countAll(); //hieu them
	List<User> paginationPage(int index, int numberOfPage); //hieu them
	List<User> SortUserByWorkplace(List<User> list);
	List<User> SortUserByName(List<User> list); //hieu end
}
