package Dao;


import java.util.List;

import Entity.Follow;
import Entity.User;


public interface IFollowDAO {
	void insert(Follow follow);
	List<User> suggestFollow(String uid);
	//hieu-begin
	void delete(String sourceID, String targetID);
	//hieu-end
}
