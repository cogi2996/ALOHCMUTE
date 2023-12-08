package Dao;

import java.util.List;

import Entity.GroupPost;

public interface IGroupPostDao {
	List<GroupPost> searchgroupPostText(String keyword);
}
