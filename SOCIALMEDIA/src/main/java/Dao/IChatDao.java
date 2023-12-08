package Dao;

import java.util.List;

import Entity.Chat;

public interface IChatDao {
	public List<Chat> findBySourceId(String sourceId);

	public boolean insert(Chat chat);

	// Chat có 2 trường sourceId, targetId là khóa chính nên truyền khóa chính vào
	// phải là kiểu object có 2 thuộc tính là khóa chính
	public boolean delete(Chat chat);
}
