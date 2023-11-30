package Services;


import java.util.List;

import Entity.User;

public interface IUserService {
	User findUser(int userID);
	List<User> SortUserByName(List<User> list);
	List<User> SortUserByWorkplace(List<User> list);
	void insert(User user) ;
}
