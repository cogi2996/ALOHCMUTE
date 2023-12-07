package Services;


import Entity.User;

public interface IUserService {
	User findUser(String userID);
	void insert(User user) ;
}
