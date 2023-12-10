package Services;

import java.util.List;

import Entity.Follow;
import Entity.User;

public interface IFollowService {
	void insert(Follow follow);

	List<User> suggestFollow(String uid);

	// hieu-begin
	void delete(String sourceID, String targetID);
	// hieu-end
}
