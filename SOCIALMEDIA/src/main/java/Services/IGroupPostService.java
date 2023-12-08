package Services;

import java.util.List;

import Entity.GroupPost;

public interface IGroupPostService {
	List<GroupPost> searchgroupPostText(String keyword);
}
