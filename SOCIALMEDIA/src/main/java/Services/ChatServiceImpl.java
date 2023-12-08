package Services;

import java.util.ArrayList;
import java.util.List;

import Entity.Chat;
import Entity.User;
import Dao.IChatDao;
import Dao.ChatDaoImpl;
import Dao.IUserDAO;
import Dao.UserDAOImpl;

public class ChatServiceImpl implements IChatService {
	private IChatDao _chatDao = new ChatDaoImpl();

	@Override
	public List<User> findBySourceId(String sourceId) {
		IUserDAO userDao = new UserDAOImpl();
		List<Chat> listChat = _chatDao.findBySourceId(sourceId);
		List<User> listUser = new ArrayList<User>();

		for (Chat chat : listChat) {
			User user = userDao.findUser(chat.getTargetId());
			User userChat = new User(user.getUserID(), user.getLastLogin(), user.getFirstName(), user.getMidName(),
					user.getLastName(), user.getPosition(), user.getAvatar());
			listUser.add(userChat);
		}
		return listUser;
	}

	@Override
	public boolean insert(Chat chat) {
		return _chatDao.insert(chat);
	}

	@Override
	public boolean delete(Chat chat) {
		return _chatDao.delete(chat);
	}
}
