package Services;


import java.util.List;

import Entity.User;

public interface IUserService {
	User findUser(String userID);
	void insert(User user) ;
	void update(User user);
	List<User> searchUsersByKeyword(String keyword);
}
