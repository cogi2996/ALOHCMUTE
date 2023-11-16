package Services;

import java.util.List;

import Entity.User;

public interface IUserService {
	List<User> findFollowersByUserId(int userId);
}
