package Services;

import java.util.List;

import Entity.User;
import Entity.Chat;

public interface IChatService {
	public List<User> findBySourceId(String sourceId);

	public boolean insert(Chat chat);

	public boolean delete(Chat chat);
}
