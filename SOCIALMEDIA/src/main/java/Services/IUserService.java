package Services;


import Entity.User;

public interface IUserService {
	User findUser(int userID);
	void insert(User user) ;
}
