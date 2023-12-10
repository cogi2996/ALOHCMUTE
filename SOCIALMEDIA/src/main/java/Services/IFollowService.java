package Services;

import java.util.List;

import Entity.Follow;
import Entity.User;

public interface IFollowService {
	void insert(Follow follow);
	List<User> suggestFollow(String uid);
}
